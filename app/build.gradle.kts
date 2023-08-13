plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.fpliu.android.ndk.pkg.prefab.example.ffmpeg"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.fpliu.android.ndk.pkg.prefab.example.ffmpeg"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        externalNativeBuild {
            cmake {
                arguments += "-DANDROID_STL=c++_shared"
                cppFlags  += "-std=c++17"
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt")
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

    ndkVersion = "25.2.9519653"

    externalNativeBuild {
        cmake {
            version = "3.18.1+"
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    buildFeatures {
        prefab = true
    }

    dataBinding {
        enable = false
    }

    viewBinding {
        enable = false
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api("com.fpliu.ndk.pkg.prefab.android.21:ffmpeg:6.0@aar")
}
