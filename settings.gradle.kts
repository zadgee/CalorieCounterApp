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

rootProject.name = "CalorieCoutingApp"
include(":app")
include(":di")
include(":feature_home")
include(":feature_search")
include(":feature_settings")
include(":feature_auth")
