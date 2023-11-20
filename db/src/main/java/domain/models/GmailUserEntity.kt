package domain.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "gmail_user",
)
data class GmailUserEntity(
    @PrimaryKey
    val id:String,
    val name:String?,
    val photoUrl:String
)