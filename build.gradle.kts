// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version libs.versions.hiltVersion apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("androidx.room") version libs.versions.roomVersion apply false
    alias(libs.plugins.detektPlugin) version libs.versions.detektPluginVersion apply false
}
