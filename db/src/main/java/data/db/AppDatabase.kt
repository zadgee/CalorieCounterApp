package data.db
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import data.dao.UserDAO
import domain.models.GmailUserEntity
import domain.models.UserEntity

@Database(
    entities = [
        UserEntity::class,
        GmailUserEntity::class
    ],
    autoMigrations =[
      AutoMigration(
          from = 1, to = 2, spec = AppDatabase.MigrationSpec_1_2::class
      ),
       AutoMigration(
            from = 2, to = 3, spec = AppDatabase.MigrationSpec_2_3::class
       )],
    version = 3,
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): UserDAO

    @RenameColumn(
        tableName = "user",
        fromColumnName = "whenCreated",
        toColumnName = "authorized_to_system_time"
    )
    class MigrationSpec_1_2: AutoMigrationSpec

    class MigrationSpec_2_3: AutoMigrationSpec
}