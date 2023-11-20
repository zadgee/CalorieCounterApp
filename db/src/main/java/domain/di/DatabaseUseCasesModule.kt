package domain.di

import app.DatabaseScope
import dagger.Module
import dagger.Provides
import domain.repository.UserDataSource
import domain.usecases.GetGmailUserUseCase
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.InsertGmailUserUseCase
import domain.usecases.InsertUserUseCase

@Module
class DatabaseUseCasesModule {

    @Provides
    @DatabaseScope
    fun provideGetUserFromUserFromDataBaseUseCase(
        userDataSource: UserDataSource
    ): GetUserFromDatabaseUseCase {
        return GetUserFromDatabaseUseCase(
            userDataSource
        )
    }

    @Provides
    @DatabaseScope
    fun provideInsertUserUseCase(
        userDataSource: UserDataSource
    ): InsertUserUseCase {
        return InsertUserUseCase(
            userDataSource
        )
    }

    @Provides
    @DatabaseScope
    fun provideInsertGmailUserUseCase(
        userDataSource: UserDataSource
    ): InsertGmailUserUseCase {
        return InsertGmailUserUseCase(
            userDataSource
        )
    }

    @Provides
    @DatabaseScope
    fun provideGetGmailUserUseCase(
        userDataSource: UserDataSource
    ):GetGmailUserUseCase{
        return GetGmailUserUseCase(
            userDataSource
        )
    }


}