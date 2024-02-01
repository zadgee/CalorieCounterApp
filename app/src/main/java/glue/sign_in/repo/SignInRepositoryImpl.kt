package glue.sign_in.repo

import com.test.sign_in.domain.event.EventSignIn
import com.test.sign_in.domain.repo.SignInRepository
import domain.usecases.LoginUseCase
import glue.sign_in.mapper.toEventSignIn
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val signInUseCase: LoginUseCase
) : SignInRepository {


    override suspend fun signIn(email: String, password: String):EventSignIn {
        return signInUseCase.login(email, password).toEventSignIn()
    }


}