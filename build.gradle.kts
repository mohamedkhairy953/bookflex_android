// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version libs.versions.hiltVersion apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("androidx.room") version libs.versions.roomVersion
    alias(libs.plugins.detektPlugin) version libs.versions.detektPluginVersion
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        toolVersion = "1.23.1" // Specify the version of Detekt
        input.setFrom(files("src/main/java", "src/main/kotlin")) // Specify input directories
        //  config.setFrom(files("$rootDir/config/detekt/detekt.yml")) // Path to Detekt configuration file (optional)
        reports {
            xml.required.set(true) // Output the result in XML format
            html.required.set(true) // Output the result in HTML format
        }
    }
}

