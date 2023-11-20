package domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
)
data class UserEntity(
    @ColumnInfo("name")
    val name:String,
    @PrimaryKey(autoGenerate = false)
    val email:String,
    @ColumnInfo("password")
    val password:String,
    @ColumnInfo("authorized_to_system_time")
    val whenAuthorized:Long = System.currentTimeMillis(),
)