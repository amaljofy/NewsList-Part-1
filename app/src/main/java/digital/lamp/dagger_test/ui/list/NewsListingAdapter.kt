package digital.lamp.dagger_test.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import digital.lamp.dagger_test.binding.bindImageFromUrl
import digital.lamp.dagger_test.data.NewsItem
import digital.lamp.dagger_test.databinding.NewsListRowBinding
/**
 * Created by Amal Jofy Dept. on 11,March,2020
 */
class NewsListingAdapter(
    private val items: List<NewsItem>,
    private val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<NewsListingAdapter.NewsListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListingViewHolder {
        val view = NewsListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsListingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsListingViewHolder, position: Int) {
        val newsItem = items[position]
        holder.apply { bind(newsItem) }
    }

    inner class NewsListingViewHolder(private val binding: NewsListRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsItem) {
            binding.apply {
                newsItem = item
                bindImageFromUrl(binding.newsImageView,item.newsContent.imageThumb)
                binding.newsCard.setOnClickListener { listener.onItemClick(item) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: NewsItem)
    }

}