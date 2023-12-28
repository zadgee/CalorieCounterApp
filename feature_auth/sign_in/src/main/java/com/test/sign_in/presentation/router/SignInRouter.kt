package com.test.sign_in.presentation.router
import android.content.IntentSender
import androidx.activity.result.ActivityResult
import com.test.sign_in.domain.models.GmailUserModel
import com.test.sign_in.domain.models.UserModel

interface SignInRouter {
    suspend fun launchGmailSignUp():IntentSender
    suspend fun launchGmailSignIn():IntentSender
    suspend fun saveUserDataToDatabase(userModel:UserModel)
    suspend fun saveGmailUserToDataBase(user:GmailUserModel)
    suspend fun sendEmailVerification()
    suspend fun getUserNameFromFireStore(email:String): String
    suspend fun initGmailAuth(activityResult: ActivityResult)
}