package `in`.ktechnos.typicodeapp

import `in`.ktechnos.typicodeapp.model.Photos
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateMovieTest() {
        val movie = Photos("test",0,"main","")
        assertEquals(true, ValidationUtil.validateMovie(movie))
    }

    @Test
    fun validateMovieEmptyTest() {
        val movie = Photos("test",0,"main","")
        assertEquals(false, ValidationUtil.validateMovie(movie))
    }

}