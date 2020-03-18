package digital.lamp.dagger_test.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import digital.lamp.dagger_test.data.NewsItem
import digital.lamp.dagger_test.databinding.NewsListLayoutBinding
import digital.lamp.dagger_test.di.Injectable
import digital.lamp.dagger_test.di.injectViewModel
import javax.inject.Inject

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
class NewsListingFragment : Fragment(), Injectable, NewsListingAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NewsListingViewModel
    private lateinit var mAdapter: NewsListingAdapter
    private lateinit var binding: NewsListLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        // Inflate the layout for this fragment
        binding = NewsListLayoutBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newsListViewModel = viewModel
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        viewModel.oPage = 1
        viewModel.oLimit = 10


            viewModel.newsList.observe(viewLifecycleOwner, Observer {newsResponse ->
                populateNewsList(newsResponse.newsList)
                viewModel.isShowProgress.value = View.GONE

            })

    }

    override fun onPause() {
        super.onPause()
        viewModel.scrollPosition.value = (binding.recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
    }

    private fun populateNewsList(newsList: List<NewsItem>) {
        mAdapter = NewsListingAdapter(newsList,context!!,this)
        binding.recyclerView.adapter = mAdapter
        binding.recyclerView.scrollToPosition(viewModel.scrollPosition.value!!)

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadNews().observe(viewLifecycleOwner, Observer {
                populateNewsList(it.newsList)
                binding.swipeRefresh.isRefreshing = false
                viewModel.scrollPosition.value = 0
            })
        }
    }

    override fun onItemClick(item: NewsItem) {

        val direction = NewsListingFragmentDirections.actionNewsListingFragmentToNewsDetailsFragment2(item)
        findNavController().navigate(direction)
    }
    companion object{
        var TAG : String = NewsListingFragment::class.java.simpleName
    }

}
