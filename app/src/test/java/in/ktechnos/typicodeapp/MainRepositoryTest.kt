package `in`.ktechnos.typicodeapp


import `in`.ktechnos.typicodeapp.api.MainRepository
import `in`.ktechnos.typicodeapp.api.RetrofitService
import `in`.ktechnos.typicodeapp.model.Photos
import `in`.ktechnos.typicodeapp.network.NetworkState
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class MainRepositoryTest {

    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var apiService: RetrofitService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainRepository = MainRepository(apiService)
    }

    @Test
    fun `get all movie test`() {
        runBlocking {
            Mockito.`when`(apiService.getAllMovies()).thenReturn(Response.success(listOf<Photos>()))
            val response = mainRepository.getAllMovies()
            assertEquals(listOf<Photos>(),  NetworkState.Success(response).data)
        }

    }

}