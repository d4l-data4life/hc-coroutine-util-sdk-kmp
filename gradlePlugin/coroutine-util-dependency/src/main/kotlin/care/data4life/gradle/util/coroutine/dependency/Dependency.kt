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
package care.data4life.gradle.util.coroutine.dependency

object Dependency {
    val kotlin = Kotlin
    object Kotlin {
        const val stdLib = Multiplatform.Kotlin.stdlibJdk
    }

    val multiplatform = Multiplatform
    object Multiplatform {

        val kotlin = Kotlin
        object Kotlin {
            const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${Version.kotlin}"
            const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
            const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
            const val stdlibJs = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
            const val stdlibNative = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
            const val stdlibAndroid = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"

            const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:${Version.kotlin}"
            const val testCommonAnnotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Version.kotlin}"
            const val testJvm = "org.jetbrains.kotlin:kotlin-test:${Version.kotlin}"
            const val testJvmJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin}"
        }

        val coroutines = Coroutines

        object Coroutines {
            // https://github.com/Kotlin/kotlinx.coroutines
            const val common =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutines}"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinCoroutines}"

            const val stately = "co.touchlab:stately-common:${Version.stately}"
        }

        val d4l = D4L

        object D4L {
            const val sdkObjcUtil = "care.data4life.hc-objc-util-sdk-kmp:objc-util:${Version.sdkObjcUtil}"
            const val sdkCoroutineTestUtil = "care.data4life.hc-test-util-sdk-kmp:test-util-coroutine:${Version.sdkTestUtil}"
        }
    }

    val test = Test
    object Test {
        const val junit = "junit:junit:${Version.testJUnit}"
    }

    val android = Android
    object Android {
        // Kotlin
        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"

        // Android
        const val desugar = "com.android.tools:desugar_jdk_libs:${Version.androidDesugar}"

        val androidX = AndroidX
        object AndroidX {
            // AndroidX
            const val ktx = "androidx.core:core-ktx:${Version.androidXKtx}"
            const val appCompat = "androidx.appcompat:appcompat:${Version.androidXAppCompat}"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.androidXConstraintLayout}"
        }

        // Material
        const val material = "com.google.android.material:material:${Version.material}"

        // Test
        const val robolectric = "org.robolectric:robolectric:${Version.robolectric}"
    }

    val androidTest = AndroidTest
    object AndroidTest {
        const val core = "androidx.test:core:${Version.androidXTest}"
        const val runner = "androidx.test:runner:${Version.androidXTest}"
        const val rules = "androidx.test:rules:${Version.androidXTest}"

        const val junit = "androidx.test.ext:junit:${Version.androidXTest}"

        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.androidXEspresso}"
        const val espressoIntents =
            "androidx.test.espresso:espresso-intents:${Version.androidXEspresso}"
        const val espressoWeb = "androidx.test.espresso:espresso-web:${Version.androidXEspresso}"

        const val uiAutomator =
            "androidx.test.uiautomator:uiautomator:${Version.androidXUiAutomator}"
    }
}
