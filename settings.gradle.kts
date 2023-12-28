pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CalorieCountingApp"
include(":app")
include(":feature_home")
include(":feature_search")
include(":feature_auth")
include(":core")
include(":db")
include(":feature_profile")
include(":feature_auth:sign_up")
include(":feature_auth:sign_in")
include(":feature_auth:email_verification")
include(":feature_auth:congrats")
include(":feature_auth:forgot_password")
include(":network")
include(":core:validation")
include(":firebase")
include(":feature_home:home")
