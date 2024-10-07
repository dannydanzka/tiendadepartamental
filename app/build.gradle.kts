plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.roberto.tiendadepartamental"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.roberto.tiendadepartamental"
        minSdk = 24
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
}

dependencies {
    // Dependencias tradicionales de Android
    implementation(libs.androidx.appcompat)  // Para AppCompatActivity
    implementation(libs.androidx.constraintlayout)  // Para ConstraintLayout
    implementation(libs.androidx.core.ktx)  // Para funciones Kotlin extendidas
    implementation(libs.google.material)  // Para componentes de Material Design

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
