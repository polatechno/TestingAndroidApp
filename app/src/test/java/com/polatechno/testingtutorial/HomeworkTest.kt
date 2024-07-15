package com.polatechno.testingtutorial

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class HomeworkTest {

    @Test
    fun `fib(0) should return 0`() {
        val result = Homework.fib(0)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `fib(2) should return 1`() {
        val result = Homework.fib(2)

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `fib(8) should return fib(7) + fib(6)`() {
        val fib6 = Homework.fib(6)
        val fib7 = Homework.fib(7)
        val fib8 = Homework.fib(8)

        assertThat(fib8).isEqualTo(fib6 + fib7)
    }

    @Test
    fun `fib(855) should return fib(854) + fib(853)`() {
        val fib853 = Homework.fib(853)
        val fib854 = Homework.fib(854)
        val fib855 = Homework.fib(855)

        assertThat(fib855).isEqualTo(fib853 + fib854)
    }

    @Test
    fun `(a+b)) should return false`() {
        val result = Homework.checkBraces("(a+b))")

        assertThat(result).isFalse()
    }

    @Test
    fun `(a+b))( should return false`() {
        val result = Homework.checkBraces("(a+b))(")

        assertThat(result).isFalse()
    }

    @Test
    fun `((a+b)-5)+(a+b) should return true`() {
        val result = Homework.checkBraces("((a+b)*5)+(a+b)")

        assertThat(result).isTrue()
    }

}