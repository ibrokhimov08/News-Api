package uz.ibrokhimov.mynewsapi.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.ibrokhimov.mynewsapi.core.model.Article
import uz.ibrokhimov.mynewsapi.databinding.ItemNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val data = ArrayList<Article?>()
    var itemNewsClick: ((data:Article) -> Unit)? = null

    fun setData(data: List<Article?>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Article) {
            binding.newsImage.load(data.urlToImage)
            binding.titleText.text = data.publishedAt
            binding.text.text = data.description

            binding.root.setOnClickListener{
                itemNewsClick?.invoke(data)
            }

            itemView.setOnClickListener {
                itemNewsClick?.invoke(data)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(data[position]!!)
    }


}