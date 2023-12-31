package application
import android.app.Application
import app.DaggerDatabaseComponent
import auth_application.DaggerAuthComponent
import data.di.AuthModule
import data.di.RoomModule
import domain.di.WorkerModule

class CalorieCountingApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        val databaseComponent by lazy {
            DaggerDatabaseComponent.builder()
                .roomModule(RoomModule(this))
                .build()
        }

        val authComponent by lazy {
            DaggerAuthComponent
                .builder()
                .authModule(AuthModule(this))
                .workerModule(WorkerModule(this))
                .databaseComponent(databaseComponent)
                .buildAuthComponent()
        }

        DaggerApplicationComponent.builder()
            .databaseComponent(databaseComponent)
            .authComponent(authComponent)
            .build()
    }
}