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
import care.data4life.sdk.util.test.coroutine.runWithContextBlockingTest
import care.data4life.sdk.util.test.coroutine.testCoroutineContext
import co.touchlab.stately.freeze
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext
import kotlin.test.*

@ExperimentalCoroutinesApi
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

    @Test
    fun `Given createCoroutineScope is called with a CoroutineContextName and a Dispatcher, creates a runnable CoroutineScope`() {
        // Given
        val name = "test"
        val capturedItem = Channel<Int>()
        val wasCalled = Channel<Boolean>()
        val dispatcher = DispatcherSpy(
            CoroutineScope(testCoroutineContext),
            wasCalled
        )

        // When
        val scope = CoroutineScopeFactory.createScope(
            name,
            dispatcher
        )

        // Then
        runWithContextBlockingTest(Dispatchers.Default) {
            flowOf(1)
                .onEach { item ->
                    capturedItem.send(item)
                }.launchIn(scope)
                .start()

            assertEquals(
                actual = capturedItem.receive(),
                expected = 1
            )
            assertTrue(wasCalled.receive())
        }
    }

    @Test
    fun `Given createCoroutineScope is called with a CoroutineContextName and a Supervisor, creates a runnable CoroutineScope`() {
        // Given
        val name = "test"
        val supervisor = Job()

        // When
        val scope = CoroutineScopeFactory.createScope(
            name,
            supervisor = supervisor
        )

        // Then
        assertTrue(scope.isActive)
        supervisor.cancel()
        assertFalse(scope.isActive)
    }

    @Test
    fun `Given createCoroutineScope is called with a CoroutineContextName and a ExceptionHandler, creates a runnable CoroutineScope`() {
        // Given
        val name = "test"
        val error = RuntimeException().freeze()
        val result = Channel<Boolean>()

        // When
        val scope = CoroutineScopeFactory.createScope(
            name,
            supervisor = SupervisorJob(),
            exceptionHandler = CoroutineExceptionHandler { _, actual ->
                CoroutineScope(Dispatchers.Default).launch {
                    result.send(actual === error)
                }.start()
            }
        )

        runWithContextBlockingTest(Dispatchers.Default) {
            scope.launch {
                throw error
            }.join()

            // Then
            assertTrue(result.receive())
        }
    }

    private class DispatcherSpy(
        private val scope: CoroutineScope,
        private val wasCalled: Channel<Boolean>
    ) : CoroutineDispatcher() {
        override fun dispatch(
            context: CoroutineContext,
            block: Runnable
        ) {
            Dispatchers.Default.dispatch(context, block)

            scope.launch {
                wasCalled.send(true)
            }.start()
        }
    }
}
