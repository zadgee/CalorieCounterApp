 plugins{
     `kotlin-dsl`
 }

 repositories {
     google()
     mavenCentral()
 }

 dependencies {
     implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
     implementation("com.android.tools.build:gradle:8.1.2")
 }

 kotlin{
     jvmToolchain{
         languageVersion.set(JavaLanguageVersion.of(17))
     }
 }