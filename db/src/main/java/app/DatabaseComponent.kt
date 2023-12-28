package app
import app.scope.DatabaseScope
import dagger.Component
import domain.repository.UserDataSource


@Component(
    modules = [
    RoomModule::class
 ]
)
@DatabaseScope
interface DatabaseComponent{
    @Component.Builder
    interface Builder{
        fun roomModule(roomModule: RoomModule): Builder
        fun build(): DatabaseComponent
    }
    fun getRepo():UserDataSource
    fun getDatabaseComponent(): DatabaseComponent
}