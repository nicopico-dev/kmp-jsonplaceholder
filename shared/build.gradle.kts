plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    jvmToolchain(17)

    androidTarget()
    ios()
    // Note: iosSimulatorArm64 target requires that all dependencies have M1 support
    iosSimulatorArm64()

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("kotlin.time.ExperimentalTime")
            }
        }

        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
            }
        }

        val androidMain by getting {
            dependencies {
            }
        }
        val androidUnitTest by getting {
            dependencies {
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosTest by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }
    }
    sourceSets.matching { it.name.endsWith("Test") }
        .configureEach {
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
}

android {
    namespace = "fr.nicopico.kmp.jsonplaceholder"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
