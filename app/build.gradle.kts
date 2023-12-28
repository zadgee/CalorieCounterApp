plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.nutrition.caloriecountingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nutrition.caloriecountingapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    viewBinding.isEnabled = true

    packaging{
        resources{
            pickFirsts.add("google/protobuf/*.proto")
            pickFirsts.add("google/protobuf/compiler/*.proto")
            pickFirsts.add("META-INF/AL2.0")
            pickFirsts.add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
    appModule()
    featureAuth()
    featureHome()
    featureSearch()
    featureProfile()
    core()
    validation()
    db()
    dagger()
    firebaseModule()
}