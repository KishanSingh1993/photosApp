package `in`.ktechnos.typicodeapp

import `in`.ktechnos.typicodeapp.model.Photos

object ValidationUtil {

    fun validateMovie(movie: Photos) : Boolean {
        if (movie.title.isNotEmpty() && movie.thumbnailUrl.isNotEmpty()) {
            return true
        }
        return false
    }
}