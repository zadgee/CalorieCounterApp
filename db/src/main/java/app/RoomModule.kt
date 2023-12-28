package app
import android.content.Context
import androidx.room.Room
import app.scope.DatabaseScope
import dagger.Module
import dagger.Provides
import data.dao.UserDAO
import data.impl.UserDataSourceImpl
import domain.repository.UserDataSource


@Module
class RoomModule(
    private val context: Context
){

    @Provides
    @DatabaseScope
    fun provideRoomDataBaseInstance(): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }


    @Provides
    @DatabaseScope
    fun provideUserDao(appDatabase: AppDatabase): UserDAO {
        return appDatabase.dao()
    }

    @Provides
    @DatabaseScope
    fun provideUserDataSource(
        userDAO: UserDAO
    ): UserDataSource {
        return UserDataSourceImpl(
            userDAO
        )
    }
}