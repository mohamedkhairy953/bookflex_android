plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("androidx.room")
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.khairy.bookflex"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.khairy.bookflex"
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
    // Enable BuildConfig features
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}
//noinspection UseTomlInstead
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    hilt()
    implementation(libs.gson)
    // Retrofit
    retrofit()
    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    modules()
    compose()
}

/**
 * Add the modules to the project
 */
fun DependencyHandlerScope.modules() {
    implementation(project(":folioreader"))
    implementation(project(":di"))
    implementation(project(":booklist"))
    implementation(project(":database"))
}

fun DependencyHandlerScope.retrofit() {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Or another converter of your choice
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
}

fun DependencyHandlerScope.hilt() {
    implementation(libs.hilt.android) // or the latest version
    kapt(libs.hilt.compiler) // or the latest version
}

fun DependencyHandlerScope.compose() {
    implementation(libs.androidx.ui.compose)
    implementation(libs.androidx.material.compose)
    implementation(libs.androidx.ui.tooling.preview.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.compose)
    implementation(libs.androidx.foundation.compose)
}

fun DependencyHandlerScope.room() {
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    kapt(libs.androidx.room.kts)
    kapt(libs.androidx.room.paging3)
}