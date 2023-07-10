package `in`.ktechnos.typicodeapp

import `in`.ktechnos.typicodeapp.api.MainRepository
import `in`.ktechnos.typicodeapp.api.RetrofitService
import `in`.ktechnos.typicodeapp.databinding.ActivityMainBinding
import `in`.ktechnos.typicodeapp.viewmodel.MainViewModel
import `in`.ktechnos.typicodeapp.viewmodel.MyViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)

        viewModel.movieList.observe(this) {
            adapter.setMovies(it)
            binding.progressDialog.visibility = View.GONE
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.GONE
            } else {
                binding.progressDialog.visibility = View.VISIBLE
            }
        })

        viewModel.getAllMovies()

    }
}