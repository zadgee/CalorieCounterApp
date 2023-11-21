package domain.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EmailVerificationWorker @Inject constructor(
    context:Context,params:WorkerParameters,
    private val authenticationRepository: AuthenticationRepository
):CoroutineWorker(context,params){

    private val isEmailVerified get () = authenticationRepository.user?.isEmailVerified?: false


    override suspend fun doWork(): Result {
      return withContext(Dispatchers.Default){
          authenticationRepository.reloadUser()
           if(!isEmailVerified){
              authenticationRepository.deleteUserFromFirebase()
              authenticationRepository.signOutWhileUsingEmailPassword()
              Result.failure()
          } else {
              Result.success()
          }
      }

    }
}