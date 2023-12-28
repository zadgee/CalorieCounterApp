package com.test.email_verification.domain.worker
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.test.email_verification.domain.repo.EmailVerificationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EmailVerificationWorker @Inject constructor(
    private val repository: EmailVerificationRepository,
    context: Context,
    params:WorkerParameters
) :CoroutineWorker(context,params){

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.Default){
            val isEmailVerified  = repository.reloadUser()
            if(!isEmailVerified){
                repository.deleteUserFromFirebase()
                delay(10)
                repository.signOutWhileUsingEmailPassword()
                Result.failure()
            } else {
                Result.success()
            }
        }
    }
}