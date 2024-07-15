package com.polatechno.testingtutorial


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "", "Test123", "Test123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "polatechno", "Test123", "Test123"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "ExistingUser1", "Test123", "Test123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "MrBean", "Test123", "Test132"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Peter", "", ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "username", "Password1", "Password1"
        )

        assertThat(result).isFalse()
    }
}