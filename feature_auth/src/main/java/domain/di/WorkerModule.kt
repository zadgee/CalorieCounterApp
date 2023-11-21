package domain.di

import android.content.Context
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.Module
import dagger.Provides
import domain.repository.AuthenticationRepository
import domain.worker.EmailVerificationWorker


@Module
class WorkerModule(private val context: Context) {

    @Provides
    fun provideWorkManagerInstance(): WorkManager {
        return WorkManager.getInstance(context)
    }

    @Provides
    fun provideEmailVerificationWaiterWorker(
        context: Context,
        params: WorkerParameters,
        authenticationRepository:AuthenticationRepository
    ): EmailVerificationWorker {
        return EmailVerificationWorker(
            context, params,
            authenticationRepository
        )
    }

}