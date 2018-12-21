package com.example.gajanand.mvvmdemo

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.gajanand.mvvmdemo.network.ApiClient
import com.example.gajanand.mvvmdemo.utils.Utils

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
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.gajanand.mvvmdemo", appContext.packageName)
    }

    @Test
    fun testNumberVaidtion() {
        val validNumber = Utils.isValidNumber("1234")
        assertEquals(true, validNumber)
    }


    @Test
    fun testApi() {
        val apiService = ApiClient.getApiService()
        val heroes = apiService.getHeroes()
        val execute = heroes.execute()
        assertTrue(execute.isSuccessful)
    }


}
