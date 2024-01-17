package uz.ibrokhimov.mynewsapi.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineArticle
import uz.ibrokhimov.mynewsapi.databinding.ItemBannerBinding


class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private val data = ArrayList<TopHeadlineArticle>()

    fun setData(data: List<TopHeadlineArticle>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class BannerViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: TopHeadlineArticle) {
            binding.bannerImage.load(data.urlToImage)
            binding.text.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}

