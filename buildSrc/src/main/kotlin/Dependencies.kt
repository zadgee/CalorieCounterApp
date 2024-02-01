import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val androidCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationFragment}"
    const val googlePlayAdsLite = "com.google.android.gms:play-services-ads-lite:${Versions.adsLite}"
    const val googlePlayAds = "com.google.android.gms:play-services-ads:${Versions.adsServices}"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidTestJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val googleServices = "com.google.gms:google-services:${Versions.gmsServices}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Firebase
    const val firebaseBom="com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAuth="com.google.firebase:firebase-auth-ktx"
    const val firebaseFireStore="com.google.firebase:firebase-firestore-ktx"
    const val crashlytics="com.google.firebase:firebase-crashlytics-ktx:${Versions.crashlytics}"
    const val analytics="com.google.firebase:firebase-analytics:${Versions.analytics}"
    const val crashlyticsPlugin = "com.google.firebase.crashlytics:com.google.firebase.crashlytics.gradle.plugin:${Versions.crashlyticsGradlePlugin}"
    const val googlePlayServicesAuth="com.google.android.gms:play-services-auth:${Versions.gmsAuthServices}"

    // WorkManager
    const val workManagerRuntime = "androidx.work:work-runtime:${Versions.workManager}"

    // Lifecycle
    const val lifecycleRuntime="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Glide
    const val glide="com.github.bumptech.glide:glide:${Versions.glide}"

    // Ktor
    const val ktorAndroid="io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorLogging="io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
    const val ktorSerialization="io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val kotlinSerialization="org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"

    // Plugins
    const val gmsServices="com.google.gms:google-services:${Versions.gmsServices}"
    const val kspPlugin="com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.ksp}"
    const val serializationPlugin="org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    // Testing
    const val coroutinesTest="org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val mockK="io.mockk:mockk:${Versions.mockK}"

    // modules
    const val coreModule=":core"
    const val validation=":core:validation"
    const val feature_auth=":feature_auth"
    const val firebase = ":firebase"
    const val congrats=":feature_auth:congrats"
    const val emailVerification=":feature_auth:email_verification"
    const val forgotPassword=":feature_auth:forgot_password"
    const val sign_in=":feature_auth:sign_in"
    const val sign_up=":feature_auth:sign_up"
    const val feature_home=":feature_home"
    const val home=":feature_home:home"
    const val feature_profile=":feature_profile"
    const val feature_search=":feature_search"
    const val dbModule=":db"
    const val networkModule=":network"
}

fun DependencyHandler.appModule(){
    implementation(Dependencies.androidCore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
    implementation(Dependencies.googlePlayAdsLite)
}

fun DependencyHandler.firebaseModule(){
    implementation(project(Dependencies.firebase))
}

fun DependencyHandler.firebaseDependencies(){
    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseAuth)
    implementation(Dependencies.googlePlayServicesAuth)
    implementation(Dependencies.firebaseFireStore)
}

fun DependencyHandler.androidLibrary(){
    implementation(Dependencies.androidCore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
}

fun DependencyHandler.adMob(){
    implementation(Dependencies.googlePlayAds)
}

fun DependencyHandler.mockK(){
    testImplementation(Dependencies.mockK)
}

fun DependencyHandler.testing(){
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.androidTestJUnit)
}

fun DependencyHandler.coroutinesTesting(){
    testImplementation(Dependencies.coroutinesTest)
}

fun DependencyHandler.room(){
    implementation(Dependencies.room)
    implementation(Dependencies.roomKtx)
    ksp(Dependencies.roomCompiler)
}

fun DependencyHandler.workManager(){
    implementation(Dependencies.workManagerRuntime)
}

fun DependencyHandler.lifecycle(){
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
}

fun DependencyHandler.glide(){
    implementation(Dependencies.glide)
}

fun DependencyHandler.ktor(){
    implementation(Dependencies.ktorAndroid)
    implementation(Dependencies.ktorLogging)
    implementation(Dependencies.ktorSerialization)
    implementation(Dependencies.kotlinSerialization)
}

fun DependencyHandler.dagger(){
    implementation(Dependencies.dagger)
    ksp(Dependencies.daggerCompiler)
}

fun DependencyHandler.core(){
    implementation(project(Dependencies.coreModule))
}

fun DependencyHandler.validation(){
    implementation(project(Dependencies.validation))
}

fun DependencyHandler.network(){
    implementation(project(Dependencies.networkModule))
}

fun DependencyHandler.featureAuth(){
    implementation(project(Dependencies.feature_auth))
    implementation(project(Dependencies.congrats))
    implementation(project(Dependencies.emailVerification))
    implementation(project(Dependencies.forgotPassword))
    implementation(project(Dependencies.sign_in))
    implementation(project(Dependencies.sign_up))
}

fun DependencyHandler.featureHome(){
    implementation(project(Dependencies.feature_home))
    implementation(project(Dependencies.home))
}

fun DependencyHandler.featureSearch(){
    implementation(project(Dependencies.feature_search))
}

fun DependencyHandler.featureProfile(){
    implementation(project(Dependencies.feature_profile))
}

fun DependencyHandler.db(){
    implementation(project(Dependencies.dbModule))
}

fun DependencyHandler.congrats(){
    implementation(project(Dependencies.congrats))
}

fun DependencyHandler.analyticsDependencies(){
    implementation(Dependencies.crashlytics)
    implementation(Dependencies.analytics)
}