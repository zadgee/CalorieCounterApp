package app
import dagger.Component
import data.dao.UserDAO
import data.db.AppDatabase
import data.di.RoomModule
import domain.di.DatabaseUseCasesModule
import domain.repository.UserDataSource
import domain.usecases.GetUserFromDatabaseUseCase
import domain.usecases.InsertUserUseCase


@Component(modules = [
    RoomModule::class,
    DatabaseUseCasesModule::class
 ]
)
@DatabaseScope
interface DatabaseComponent{
    @Component.Builder
    interface Builder{
        fun build(): DatabaseComponent
        fun roomModule(roomModule: RoomModule):Builder
    }
    fun provideRoomDatabase(): AppDatabase
    fun provideUserDao(): UserDAO
    fun provideUserDataSource():UserDataSource
    fun provideInsertUseCase():InsertUserUseCase
    fun provideGetUserUseCase():GetUserFromDatabaseUseCase
}