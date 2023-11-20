package data.di
import android.content.Context
import androidx.room.Room
import app.DatabaseScope
import dagger.Module
import dagger.Provides
import data.dao.UserDAO
import data.db.AppDatabase
import data.impl.UserDataSourceImpl
import domain.repository.UserDataSource
import javax.inject.Singleton


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
    fun provideUserDataSource(dao: UserDAO): UserDataSource {
        return UserDataSourceImpl(
            dao
        )
    }

}