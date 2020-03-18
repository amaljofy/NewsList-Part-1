package digital.lamp.dagger_test.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import digital.lamp.dagger_test.api.AppService
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Amal Jofy Dept. on 10,March,2020
 */

@Singleton
class NewsListingRepository @Inject constructor(private val service: AppService){

    fun getNewsList (oPage: Int, oLimit: Int): LiveData<NewsResponse> {
        return liveData(Dispatchers.IO) {
            try {
                val newsList = service.getNewsList(oPage,oLimit)
                emit(newsList)
            }catch (er: Exception){
                er.printStackTrace()
            }
        }
    }
}