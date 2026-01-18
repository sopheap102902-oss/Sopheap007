plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.sopheap007.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sopheap007.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    // ... កូដផ្សេងៗទៀត
}

