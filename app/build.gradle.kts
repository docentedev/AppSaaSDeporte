plugins {
    alias(libs.plugins.android.application)
    // Elimina esta línea:
    // alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.duoc.saasdeporte"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.duoc.saasdeporte"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    // Compose Bill of Materials (BOM) para alinear versiones
    val composeBom = platform("androidx.compose:compose-bom:2024.04.01")
    implementation(composeBom)

    // UI y Material Design 3
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.tooling.preview)

    // Integración de Activity con Compose
    implementation(libs.androidx.activity.compose)

    // ViewModel para Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}