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

package care.data4life.sdk.util.coroutine

import care.data4life.sdk.util.test.coroutine.runBlockingTest
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CoroutineScopeFactoryTest {
    @Test
    fun `It fulfils CoroutineHelper`() {
        val helper: Any = CoroutineScopeFactory

        assertTrue(helper is CoroutineScopeFactoryContract)
    }

    @Test
    fun `Given createCoroutineScope is called with a CoroutineContextName, creates a runnable CoroutineScope`() {
        // Given
        val name = "test"
        val capturedItem = Channel<Int>()

        // When
        val scope = CoroutineScopeFactory.createScope(name)

        // Then
        runBlockingTest {
            flowOf(1)
                .onEach { item ->
                    capturedItem.send(item)
                }.launchIn(scope)
                .start()

            assertEquals(
                actual = capturedItem.receive(),
                expected = 1
            )
        }
    }
}
