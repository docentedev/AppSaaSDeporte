plugins { // Start plugin declarations for this Android app module
    alias(libs.plugins.android.application) // Apply Android Application plugin from version catalog
    alias(libs.plugins.kotlin.compose) // Apply Kotlin Compose compiler plugin
} // End plugin declarations

android { // Start Android-specific build configuration
    namespace = "com.duoc.saasdeporte" // Kotlin/Java package namespace used by generated R and BuildConfig
    compileSdk = 37 // Android API level used to compile the app

    defaultConfig { // Start default values shared by all build variants
        applicationId = "com.duoc.saasdeporte" // Unique app id used for install and Play Store identity
        minSdk = 26 // Minimum Android API level supported by the app
        targetSdk = 37 // Target Android API level for runtime behavior compatibility
        versionCode = 1 // Internal integer version used for updates
        versionName = "1.0" // Human-readable app version shown to users

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // Runner used for instrumented Android tests
    } // End defaultConfig block

    buildTypes { // Start build type definitions
        release { // Configure release build type
            optimization { // Configure optimization options for release
                enable = false // Disable optimization/minification in release for now
            } // End optimization config
        } // End release build type
    } // End buildTypes block

    buildFeatures { // Start optional Android build features
        compose = true // Enable Jetpack Compose support for this module
    } // End buildFeatures block
} // End Android configuration

dependencies { // Start library dependency declarations
    implementation(libs.androidx.appcompat) // AndroidX AppCompat for compatibility support APIs
    implementation(libs.androidx.core.ktx) // Kotlin extensions for core Android framework APIs
    implementation(libs.material) // Google Material components dependency
    testImplementation(libs.junit) // JUnit dependency for local unit tests
    androidTestImplementation(libs.androidx.espresso.core) // Espresso dependency for UI instrumentation tests
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit extensions for instrumentation tests

    // Compose Bill of Materials (BOM) para alinear versiones // Explain purpose of Compose BOM section
    val composeBom = platform("androidx.compose:compose-bom:2024.04.01") // Define Compose BOM platform dependency with fixed version set
    implementation(composeBom) // Import Compose BOM so Compose artifacts use aligned versions

    // UI y Material Design 3 // Explain purpose of Compose UI dependencies section
    implementation(libs.androidx.ui) // Core Compose UI toolkit dependency
    implementation(libs.androidx.material3) // Material 3 components for Compose UI
    implementation(libs.androidx.ui.tooling.preview) // Preview annotations and preview support for Android Studio
    debugImplementation(libs.androidx.ui.tooling) // Extra tooling for preview/inspection only in debug builds

    // Integracion de Activity con Compose // Explain bridge between Activity lifecycle and Compose
    implementation(libs.androidx.activity.compose) // Compose integration APIs for Android Activity setContent

    // ViewModel para Compose // Explain ViewModel integration section
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Helpers to use ViewModel directly from composables
} // End dependency declarations