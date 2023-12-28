package domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
)
data class UserEntity(
    @ColumnInfo(name = "name")
    val name:String,
    @PrimaryKey(autoGenerate = false)
    val email:String,
    @ColumnInfo(name = "password")
    val password:String,
    @ColumnInfo(name = "authorized_to_system_time")
    val whenAuthorized:Long = System.currentTimeMillis(),
)