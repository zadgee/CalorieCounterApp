<<<<<<<< HEAD:firebase/src/androidTest/java/com/test/firebase/ExampleInstrumentedTest.kt
package com.test.firebase
========
package com.test.di
>>>>>>>> d44073d43986e8b9e35961b6cd0e076539fefa12:feature_profile/src/androidTest/java/com/test/di/ExampleInstrumentedTest.kt

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
<<<<<<<< HEAD:firebase/src/androidTest/java/com/test/firebase/ExampleInstrumentedTest.kt
        assertEquals("com.test.firebase.test", appContext.packageName)
========
        assertEquals("com.test.di.test", appContext.packageName)
>>>>>>>> d44073d43986e8b9e35961b6cd0e076539fefa12:feature_profile/src/androidTest/java/com/test/di/ExampleInstrumentedTest.kt
    }
}