package glue.sign_up.repo
import com.test.sign_up.domain.event.EventSignUp
import com.test.sign_up.domain.repo.SignUpRepository
import domain.usecases.SignUpUseCase
import glue.sign_up.mapper.toEventSignUp
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
  private val signUpUseCase: SignUpUseCase
):SignUpRepository {

    override suspend fun signUp(email: String, password: String): EventSignUp {
        return signUpUseCase.signUp(email, password).toEventSignUp()
    }

}