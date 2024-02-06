<<<<<<<< HEAD:feature_auth/sign_up/src/androidTest/java/com/test/sign_up/ExampleInstrumentedTest.kt
package com.test.sign_up
========
package com.test.di
>>>>>>>> origin/feature_home:feature_profile/src/androidTest/java/com/test/di/ExampleInstrumentedTest.kt

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
<<<<<<<< HEAD:feature_auth/sign_up/src/androidTest/java/com/test/sign_up/ExampleInstrumentedTest.kt
        assertEquals("com.test.sign_up.test", appContext.packageName)
========
        assertEquals("com.test.di.test", appContext.packageName)
>>>>>>>> origin/feature_home:feature_profile/src/androidTest/java/com/test/di/ExampleInstrumentedTest.kt
    }
}