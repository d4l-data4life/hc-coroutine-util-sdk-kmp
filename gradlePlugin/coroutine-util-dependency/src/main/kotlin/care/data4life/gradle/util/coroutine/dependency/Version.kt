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

object Version {
    object GradlePlugin {
        const val kotlin = Version.kotlin
        const val android = "7.0.2"
    }

    // Kotlin
    /**
     * https://github.com/JetBrains/kotlin
     */
    const val kotlin = "1.5.21"

    /**
     * https://github.com/Kotlin/kotlinx.coroutines
     */
    const val kotlinCoroutines = "1.5.1-native-mt"

    // https://github.com/touchlab/Stately
    const val stately = "1.1.6"

    // D4L
    /**
     * https://github.com/d4l-data4life/hc-test-util-sdk-kmp
     */
    const val sdkTestUtil = "0.2.0-bump-updates-SNAPSHOT"

    // Android
    /**
     * https://developer.android.com/studio/write/java8-support
     */
    const val androidDesugar = "1.0.4"

    // AndroidX
    /**
     * https://developer.android.com/jetpack/androidx
     */
    const val androidX = "1.1.0"
    const val androidXKtx = "1.6.0"
    const val androidXAppCompat = "1.3.1"

    const val androidXConstraintLayout = "2.0.1"

    /**
     * https://developer.android.com/testing
     */
    const val androidXTest = "1.4.0"
    const val androidXEspresso = "3.4.0"
    const val androidXUiAutomator = "2.2.0"

    // Material
    /**
     * [Material Android](https://github.com/material-components/material-components-android)
     */
    const val material = "1.4.0"

    // Junit Test
    const val testJUnit = "4.13.2"

    /**
     * [Robolectric](https://github.com/robolectric/robolectric)
     */
    const val robolectric = "4.6.1"
}
