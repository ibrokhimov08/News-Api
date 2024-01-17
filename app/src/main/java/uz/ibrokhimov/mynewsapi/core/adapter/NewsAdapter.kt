package uz.ibrokhimov.mynewsapi.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingArticle
import uz.ibrokhimov.mynewsapi.databinding.ItemNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val data = ArrayList<EverythingArticle?>()
    var itemNewsClick: ((data: EverythingArticle) -> Unit)? = null

    fun setData(data: List<EverythingArticle?>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: EverythingArticle) {
            binding.newsImage.load(data.urlToImage)
            binding.titleText.text = data.publishedAt
            binding.text.text = data.description

            binding.itemView.setOnClickListener {
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


    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.bindData(data[position]!!)
    }


}