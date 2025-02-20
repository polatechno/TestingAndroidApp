package com.polatechno.testingtutorial

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After

import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer


    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEquel(context, R.string.app_name, "TestingTutorial")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentThanGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEquel(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }

}