package glue.profile.di
import dagger.Subcomponent
import presentation.fragment.UserProfileFragment

@Subcomponent(
    modules = [
        ProfileModule::class
    ]
)
interface ProfileComponent {
     @Subcomponent.Builder
     interface Builder{
         fun profileModule(profileModule: ProfileModule):Builder
         fun build():ProfileComponent
     }
    fun inject(fragment:UserProfileFragment)
}