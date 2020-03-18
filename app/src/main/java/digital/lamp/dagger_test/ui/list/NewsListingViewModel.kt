package digital.lamp.dagger_test.ui.list


import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import digital.lamp.dagger_test.data.NewsListingRepository
import digital.lamp.dagger_test.data.NewsResponse
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Amal Jofy Dept. on 10,March,2020
 */
class NewsListingViewModel @Inject constructor(private val newsRepository: NewsListingRepository) : ViewModel() {

    var oPage by Delegates.notNull<Int>()
    var oLimit by Delegates.notNull<Int>()

    var scrollPosition = MutableLiveData<Int>().apply { value = 0 }
    var isShowProgress = MutableLiveData<Int>().apply { value = View.VISIBLE }

    val newsList by lazy { newsRepository.getNewsList(oPage,oLimit) }

    fun loadNews(): LiveData<NewsResponse>{
        return newsRepository.getNewsList(oPage,oLimit)
    }

}