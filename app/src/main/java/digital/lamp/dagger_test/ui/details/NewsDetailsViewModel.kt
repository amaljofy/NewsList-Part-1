package digital.lamp.dagger_test.ui.details


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject


/**
 * Created by Amal Jofy Dept. on 16,March,2020
 */
class NewsDetailsViewModel @Inject constructor() : ViewModel() {

    var changeNumber = MutableLiveData<Int>().apply { value = 0 }
}
