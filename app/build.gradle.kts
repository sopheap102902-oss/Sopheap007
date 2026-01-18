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

    // បើកឱ្យប្រើប្រាស់ Resource សម្រាប់រូបតំណាង និងភាសា
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // បណ្ណាល័យមូលដ្ឋាន
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // បណ្ណាល័យសម្រាប់អាន JSON (Gson)
    implementation("com.google.code.gson:gson:2.10.1")

    // សម្រាប់ការធ្វើតេស្ត
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

