package domain.usecases
import com.google.firebase.auth.FirebaseUser
import domain.repo.AuthenticationRepository
import javax.inject.Inject


class GetFirebaseUserUseCase @Inject constructor(
    private val repository: AuthenticationRepository,
    private val reloadUserUseCase: ReloadUserUseCase
) {

     fun user():FirebaseUser?{
        return repository.user
    }

    fun isEmailVerified():Boolean{
        reloadUserUseCase.reload()
        return user()?.isEmailVerified?:false
    }
}