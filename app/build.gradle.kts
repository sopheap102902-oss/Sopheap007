plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
}

dependencies {
    // ប្រើការហៅឈ្មោះបណ្ណាល័យចំៗដើម្បីជៀសវាង Unresolved reference
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // បណ្ណាល័យសម្រាប់អាន JSON (សំខាន់សម្រាប់ Step 2 របស់អ្នក)
    implementation("com.google.code.gson:gson:2.10.1")

    // បណ្ណាល័យសម្រាប់តេស្ត (ដាក់ឈ្មោះពេញ)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

