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
