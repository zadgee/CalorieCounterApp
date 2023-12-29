package presentation
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class NetworkConnectivityChecking(
    private val context:Context
):ConnectivityState{
    private val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    override fun observeConnection(): Flow<ConnectivityState.Status> {
        return callbackFlow {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val callback = object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        super.onAvailable(network)
                        launch {
                            send(ConnectivityState.Status.Available)
                        }
                    }

                    override fun onLosing(network: Network, maxMsToLive: Int) {
                        super.onLosing(network, maxMsToLive)
                        launch {
                            send(ConnectivityState.Status.Losing)
                        }
                    }

                    override fun onLost(network: Network) {
                        super.onLost(network)
                        launch {
                            send(ConnectivityState.Status.Lost)
                        }
                    }

                    override fun onUnavailable() {
                        super.onUnavailable()
                        launch {
                            send(ConnectivityState.Status.Unavailable)
                        }
                    }
                }
                awaitClose{
                    cm.registerDefaultNetworkCallback(callback)
                }
            } else {
                val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                val receiver = object : BroadcastReceiver() {
                    override fun onReceive(context: Context?, intent: Intent?) {
                        updateConnectionStatus()
                    }
                }
                awaitClose {
                    context.registerReceiver(receiver, filter)
                }
            }
        }.distinctUntilChanged()
    }

    private fun updateConnectionStatus(){
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork?.isConnectedOrConnecting == true
        if(isConnected){
            ConnectivityState.Status.Available
        } else {
            ConnectivityState.Status.Unavailable
        }
    }
}