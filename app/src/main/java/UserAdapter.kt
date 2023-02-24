//package `in`.ktechnos.typicodeapp
//
//import `in`.ktechnos.typicodeapp.model.Photos
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//
//class UserAdapter(private val listener : (Photos) -> Unit) : ListAdapter<Photos, UserAdapter.ViewHolder>(
//    DiffUserCallBack()
//){
//    lateinit var context: Context
//
//    inner class ViewHolder(private val containerView : View) : RecyclerView.ViewHolder(containerView){
//        init {
//            itemView.setOnClickListener {
//                listener.invoke(getItem(adapterPosition))
//            }
//        }
//
//        fun bind(photos : Photos){
//            containerView.findViewById<TextView>(R.id.name).text = photos.title
//            containerView.findViewById<TextView>(R.id.email).text = photos.thumbnailUrl
//            containerView.findViewById<TextView>(R.id.phone).text = photos.url
//            //containerView.findViewById<TextView>(R.id.website).text = photos.website
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
//        return ViewHolder(itemLayout)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//}
//
//class DiffUserCallBack : DiffUtil.ItemCallback<Photos>(){
//    override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
//        return oldItem == newItem
//    }
//
//}