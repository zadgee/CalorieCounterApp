package glue.email_verification.repo
import com.test.email_verification.domain.repo.EmailVerificationRepository
import domain.usecases.AddUserToFireStoreUseCase
import domain.usecases.DeleteUserFromFirebaseUseCase
import domain.usecases.GetFirebaseUserUseCase
import domain.usecases.SendEmailVerificationLetterUseCase
import domain.usecases.SignOutWhileUsingEmailPasswordUseCase
import domain.usecases.SignOutWhileUsingGmailAuth
import javax.inject.Inject

class EmailVerificationRepositoryImpl @Inject constructor(
    private val getFirebaseUserUseCase: GetFirebaseUserUseCase,
    private val sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
    private val deleteUserFromFirebaseUseCase: DeleteUserFromFirebaseUseCase,
    private val signOutWhileUsingGmailAuth: SignOutWhileUsingGmailAuth,
    private val signOutWhileUsingEmailPasswordUseCase: SignOutWhileUsingEmailPasswordUseCase,
    private val addUserToFireStoreUseCase: AddUserToFireStoreUseCase
) : EmailVerificationRepository {

    override suspend fun reloadUser():Boolean{
        return getFirebaseUserUseCase.isEmailVerified()
    }

    override suspend fun sendEmailVerificationLetter() {
        return sendEmailVerificationLetterUseCase.send()
    }

    override suspend fun deleteUserFromFirebase() {
        return deleteUserFromFirebaseUseCase.delete()
    }

    override suspend fun signOutWhileUsingGmailAuth() {
        signOutWhileUsingGmailAuth.signOut()
    }

    override suspend fun signOutWhileUsingEmailPassword() {
        return signOutWhileUsingEmailPasswordUseCase.signOut()
    }

    override suspend fun addUserToFireStore(name: String, email: String, password: String) {
        return addUserToFireStoreUseCase.add(
            name,
            email,
            password
        )
    }

}