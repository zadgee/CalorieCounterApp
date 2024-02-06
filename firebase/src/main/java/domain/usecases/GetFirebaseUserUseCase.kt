package domain.usecases
import android.util.Log
import com.google.firebase.auth.FirebaseUser
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class GetFirebaseUserUseCase @Inject constructor(
    private val repository: AuthenticationRepository,
    private val reloadUserUseCase: ReloadUserUseCase
) {

     private fun user():FirebaseUser?{
        return repository.user
    }

    fun isEmailVerified():Boolean{
        reloadUserUseCase.reload()
        val isEmailVerified = user()?.isEmailVerified?:false
        Log.d("TAG","isEmailVerified: $isEmailVerified")
        return isEmailVerified
    }
}