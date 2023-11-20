package application
import app.DatabaseComponent
import auth_application.AuthComponent
import dagger.Component

@Component(
    dependencies = [
        AuthComponent::class,
        DatabaseComponent::class
    ]
)
@ApplicationScope
interface ApplicationComponent