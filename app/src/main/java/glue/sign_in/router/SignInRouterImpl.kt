package glue.sign_in.router
import android.content.IntentSender
import androidx.activity.result.ActivityResult
import com.test.sign_in.domain.models.GmailUserModel
import com.test.sign_in.domain.models.UserModel
import com.test.sign_in.presentation.router.SignInRouter
import domain.models.GmailUserEntity
import domain.models.UserEntity
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase
import domain.usecases.GetFirebaseUserDataUseCase
import domain.usecases.GetUserNameFromFireStoreByEmail
import domain.usecases.GmailAuthUseCase
import domain.usecases.GmailSignInUseCase
import domain.usecases.GmailSignUpUseCase
import domain.usecases.SendEmailVerificationLetterUseCase
import javax.inject.Inject

class SignInRouterImpl @Inject constructor(
    private val sendEmailVerificationLetterUseCase: SendEmailVerificationLetterUseCase,
    private val insertUserUseCase:InsertUserUseCase,
    val getUserNameFromFireStoreByEmail: GetUserNameFromFireStoreByEmail,
    private val gmailSignInUseCase: GmailSignInUseCase,
    private val gmailSignUpUseCase: GmailSignUpUseCase,
    private val gmailAuthUseCase: GmailAuthUseCase,
    private val getFirebaseUserDataUseCase: GetFirebaseUserDataUseCase,
    private val insertGmailUserUseCase:InsertGmailUserUseCase
): SignInRouter {

    override suspend fun launchGmailSignUp(): IntentSender {
        return gmailSignUpUseCase.gmailSignUp()
    }

    override suspend fun launchGmailSignIn(): IntentSender {
        return gmailSignInUseCase.gmailSignIn()
    }

    override suspend fun sendEmailVerification() {
       return sendEmailVerificationLetterUseCase.send()
    }

    override suspend fun getUserNameFromFireStore(email: String): String {
        return getUserNameFromFireStoreByEmail.retrieve(email)
    }

    override suspend fun saveUserDataToDatabase(userModel: UserModel) {
        return insertUserUseCase.insertUser(
            UserEntity(
                email = userModel.email,
                password = userModel.password,
                name = userModel.name
            )
        )
    }

    override suspend fun saveGmailUserToDataBase(user: GmailUserModel) {
        val gmailUserData = getFirebaseUserDataUseCase.getData()
        return insertGmailUserUseCase.insert(
            GmailUserEntity(
                id = gmailUserData.id,
                name = user.name,
                photoUrl = user.photoUrl
            )
        )
    }

    override suspend fun initGmailAuth(activityResult: ActivityResult) {
        return gmailAuthUseCase.gmailAuth(activityResult)
    }



}