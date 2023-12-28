package data.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import domain.models.GmailUserEntity
import domain.models.UserEntity

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getAuthorizedUserData(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGmailUser(gmailUserEntity: GmailUserEntity)

    @Query("SELECT * FROM gmail_user")
    suspend fun getGmailUser():GmailUserEntity?

}