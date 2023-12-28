package domain.di
import dagger.Component
import domain.di.scopes.AuthScope
import domain.repo.AuthenticationRepository
import domain.usecases.ReloadUserUseCase

@Component(
    modules = [
        AuthModule::class
    ]
)
@AuthScope
interface AuthComponent{
    @Component.Builder
    interface Builder{
        fun authModule(authModule: AuthModule): Builder
        fun build(): AuthComponent
    }
    fun getAuthRepository():AuthenticationRepository
    fun getReloadUserUseCase():ReloadUserUseCase
    fun getAuthComponent():AuthComponent
}