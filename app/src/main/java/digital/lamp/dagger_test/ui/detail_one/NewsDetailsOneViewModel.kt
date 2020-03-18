package digital.lamp.dagger_test.ui.detail_one

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Amal Jofy Dept. on 18,March,2020
 */
class NewsDetailsOneViewModel @Inject constructor(): ViewModel() {

    companion object{
        private val TAG = NewsDetailsOneViewModel::class.java.simpleName
    }
    var changeNumber = MutableLiveData<Int>().apply { value = 0 }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG,"ViewModel Cleared")
    }
}