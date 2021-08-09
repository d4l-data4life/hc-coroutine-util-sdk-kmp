/*
 * Copyright (c) 2021 D4L data4life gGmbH / All rights reserved.
 *
 * D4L owns all legal rights, title and interest in and to the Software Development Kit ("SDK"),
 * including any intellectual property rights that subsist in the SDK.
 *
 * The SDK and its documentation may be accessed and used for viewing/review purposes only.
 * Any usage of the SDK for other purposes, including usage for the development of
 * applications/third-party applications shall require the conclusion of a license agreement
 * between you and D4L.
 *
 * If you are interested in licensing the SDK for your own applications/third-party
 * applications and/or if you’d like to contribute to the development of the SDK, please
 * contact D4L by email to help@data4life.care.
 */

plugins {
    kotlinMultiplatform()

    // Android
    androidLibrary()

    // Publish
    id("scripts.publishing-config")
}

group = LibraryConfig.group

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }

    jvm()

    ios {
        binaries {
            framework {
                baseName = LibraryConfig.name
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.stdlibCommon)
                implementation(Dependencies.multiplatform.coroutines.common)
                implementation(Dependencies.multiplatform.coroutines.stately) // TODO: Remove with Kotlin 1.5.x
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.testCommon)
                implementation(Dependencies.multiplatform.kotlin.testCommonAnnotations)
                implementation(Dependencies.multiplatform.d4l.sdkCoroutineTestUtil)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.stdlibAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.testJvm)
                implementation(Dependencies.multiplatform.kotlin.testJvmJunit)

                implementation(Dependencies.android.robolectric)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.stdlibJdk8)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.testJvm)
                implementation(Dependencies.multiplatform.kotlin.testJvmJunit)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(Dependencies.multiplatform.kotlin.stdlibNative)
            }
        }

        val iosTest by getting {
            dependencies {
                dependencies {
                    implementation(Dependencies.multiplatform.kotlin.testCommon)
                    implementation(Dependencies.multiplatform.kotlin.testCommonAnnotations)
                    implementation(Dependencies.multiplatform.d4l.sdkUtil)
                }
            }
        }
    }
}

android {
    compileSdkVersion(LibraryConfig.android.compileSdkVersion)

    defaultConfig {
        minSdkVersion(LibraryConfig.android.minSdkVersion)
        targetSdkVersion(LibraryConfig.android.targetSdkVersion)

        versionCode = 1
        versionName = "${project.version}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments(
            mapOf(
                "clearPackageData" to "true"
            )
        )
    }

    resourcePrefix(LibraryConfig.android.resourcePrefix)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.setSrcDirs(setOf("src/androidMain/kotlin"))
            res.setSrcDirs(setOf("src/androidMain/res"))
        }

        getByName("test") {
            java.setSrcDirs(setOf("src/androidTest/kotlin"))
            res.setSrcDirs(setOf("src/androidTest/res"))
        }
    }
}
