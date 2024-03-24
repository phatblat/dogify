plugins {
    base

    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.sqldelight).apply(false)
}

// Value stored in gradle.properties
val gradleWrapperVersion: String by project

val wrapper by tasks.existing(Wrapper::class) {
    // Change this version and run `./gradlew wrapper` in order to update the gradle wrapper.
    gradleVersion = gradleWrapperVersion
    distributionType = Wrapper.DistributionType.BIN
}
