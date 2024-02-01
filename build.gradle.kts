buildscript{
    repositories {
        google()
        mavenCentral()
    }
   dependencies {
       classpath(Dependencies.serializationPlugin)
       classpath(Dependencies.gmsServices)
       classpath(Dependencies.kspPlugin)
       classpath(Dependencies.crashlyticsPlugin)
       classpath(Dependencies.googleServices)
       classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
   }
}