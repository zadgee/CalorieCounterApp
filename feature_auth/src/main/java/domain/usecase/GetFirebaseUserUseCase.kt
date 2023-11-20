package domain.usecase
import com.google.firebase.auth.FirebaseUser
import domain.repository.AuthenticationRepository
import javax.inject.Inject

class GetFirebaseUserUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

     fun user():FirebaseUser?{
        return repository.user
    }

}