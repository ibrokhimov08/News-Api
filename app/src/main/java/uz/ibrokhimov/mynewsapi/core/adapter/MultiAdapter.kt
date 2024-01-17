package uz.ibrokhimov.mynewsapi.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ibrokhimov.mynewsapi.core.model.base.BaseModel
import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingNewsResponse
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineResponse
import uz.ibrokhimov.mynewsapi.databinding.ItemBannerParentBinding
import uz.ibrokhimov.mynewsapi.databinding.ItemNewsParentBinding

class MultiAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val data = ArrayList<BaseModel>()
    fun setData(multiData: ArrayList<BaseModel>){
        this.data.clear()
        this.data.addAll(multiData)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    inner class BannerParentViewHolder(private val binding: ItemBannerParentBinding) :
        RecyclerView.ViewHolder(binding.root) {

            private val adapter = BannerAdapter()

        fun bindDataToBannerParent(data: TopHeadlineResponse) {
            binding.viewPager.adapter = adapter
            adapter.setData(data = data.articles!!)
        }


    }

    inner class NewsParentViewHolder(private val binding: ItemNewsParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
            private val adapter = NewsAdapter()
        fun bindDataToNewsParent(data: EverythingNewsResponse) {
            binding.newsRecyclerView.adapter = adapter
            adapter.setData(data.articles!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            BaseModel.TOP_HEAD_LINE -> {
                BannerParentViewHolder(
                    ItemBannerParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                NewsParentViewHolder(
                    ItemNewsParentBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BaseModel.TOP_HEAD_LINE -> {
                (holder as BannerParentViewHolder).bindDataToBannerParent(data = data[position] as TopHeadlineResponse)
            }

            BaseModel.EVERY_THING -> {
                (holder as NewsParentViewHolder).bindDataToNewsParent(data = data[position] as EverythingNewsResponse)
            }
        }
    }
}