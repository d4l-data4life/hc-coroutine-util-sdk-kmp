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

object Dependencies {

    val kotlin = Kotlin
    object Kotlin {
        const val stdLib = multiplatform.kotlin.stdlibJdk
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    }

    val multiplatform = Multiplatform
    object Multiplatform {

        val kotlin = Kotlin
        object Kotlin {
            const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
            const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
            const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
            const val stdlibJs = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
            const val stdlibNative = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
            const val stdlibAndroid = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

            const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
            const val testCommonAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
            const val testJvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
            const val testJvmJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
        }

        val coroutines = Coroutines

        object Coroutines {
            // https://github.com/Kotlin/kotlinx.coroutines
            const val common =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"

            const val stately = "co.touchlab:stately-common:${Versions.stately}"
        }

        val ktor = Ktor

        object Ktor {
            const val common = "io.ktor:ktor-client-core:${Versions.ktor}"
            const val mock = "io.ktor:ktor-client-mock:${Versions.ktor}"
        }

        val d4l = D4L

        object D4L {
            const val sdkUtil = "care.data4life.hc-util-sdk-kmp:util:${Versions.sdkUtil}"
            const val sdkCoroutineTestUtil = "care.data4life.hc-util-sdk-kmp:util-coroutine-test:${Versions.sdkUtil}"
        }
    }

    val test = Test
    object Test {
        const val junit = "junit:junit:${Versions.testJUnit}"
    }

    val android = Android
    object Android {
        // Kotlin
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

        // Android
        const val desugar = "com.android.tools:desugar_jdk_libs:${Versions.androidDesugar}"

        val androidX = AndroidX
        object AndroidX {
            // AndroidX
            const val ktx = "androidx.core:core-ktx:${Versions.androidXKtx}"
            const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXAppCompat}"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidXConstraintLayout}"
        }

        // Material
        const val material = "com.google.android.material:material:${Versions.material}"

        // Test
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }

    val androidTest = AndroidTest
    object AndroidTest {
        const val core = "androidx.test:core:${Versions.androidXTest}"
        const val runner = "androidx.test:runner:${Versions.androidXTest}"
        const val rules = "androidx.test:rules:${Versions.androidXTest}"

        const val junit = "androidx.test.ext:junit:${Versions.androidXTest}"

        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.androidXEspresso}"
        const val espressoIntents =
            "androidx.test.espresso:espresso-intents:${Versions.androidXEspresso}"
        const val espressoWeb = "androidx.test.espresso:espresso-web:${Versions.androidXEspresso}"

        const val uiAutomator =
            "androidx.test.uiautomator:uiautomator:${Versions.androidXUiAutomator}"
    }
}
