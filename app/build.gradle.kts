plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.composemovieapp"

    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.composemovieapp"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation("br.com.devsrsouza.compose.icons:feather:1.1.0")

    // PAGING
    implementation(libs.bundles.pagination)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.firebase.crashlytics.buildtools)
    kapt(libs.hilt.android.compiler)

    // LIFECYCLE EXT
    implementation(libs.lifecycle.extensions)

    // COROUTINES
    implementation(libs.kotlin.coroutines.android)

    // Jetpack-Compose
    implementation(libs.bundles.compose)

    // NETWORK
    implementation(libs.bundles.network)

    // NAVIGATION
    implementation(libs.bundles.navigation)

    // ROOM
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    // OTHER
    implementation(libs.androidx.ktx)

    // OTHER
    implementation(libs.androidx.ktx)

}