package `in`.ktechnos.typicodeapp

import `in`.ktechnos.typicodeapp.databinding.UserLayoutBinding
import `in`.ktechnos.typicodeapp.model.Photos
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<Photos>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Photos>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        //val binding = AdapterMovieBinding.inflate(inflater, parent, false)

        val binding = UserLayoutBinding.inflate(inflater,parent,false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        if (ValidationUtil.validateMovie(movie)) {
            holder.binding.name.text = movie.title
            Glide.with(holder.itemView.context).load(movie.thumbnailUrl).into(holder.binding.imageview)

            //Picasso.get().load(movie.thumbnailUrl).into(holder.binding.imageview);
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MainViewHolder(val binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

}