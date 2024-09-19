plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.amitesh.network"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = Config.java
        targetCompatibility = Config.java
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    // retrofit
    implementation(Square.retrofit)
    // moshi
    implementation(Square.moshi)
    implementation(Square.retrofitMoshiConvertor)

    // Okhttp
    implementation (Square.okHttp)
    implementation (Square.okHttpLoggingInterceptor)
    implementation (Square.okhttpURLConnection)

    // Dagger Hilt
    implementation(Hilt.hilt)
    kapt(Hilt.androidCompiler)

    // testing tool
    testImplementation(TestTool.junit)
    androidTestImplementation(TestTool.extJunit)
    androidTestImplementation(TestTool.espresso)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}