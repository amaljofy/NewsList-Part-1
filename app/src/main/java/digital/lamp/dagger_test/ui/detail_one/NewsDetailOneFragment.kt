package digital.lamp.dagger_test.ui.detail_one

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import digital.lamp.dagger_test.R
import digital.lamp.dagger_test.api.AppService
import digital.lamp.dagger_test.data.Dummy
import digital.lamp.dagger_test.databinding.FragmentNewsDetailOneBinding
import digital.lamp.dagger_test.databinding.NewsDetailsLayoutBinding
import digital.lamp.dagger_test.di.Injectable
import digital.lamp.dagger_test.di.injectViewModel
import digital.lamp.dagger_test.ui.details.NewsDetailsViewModel
import javax.inject.Inject

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
class NewsDetailOneFragment : Fragment(), Injectable {

    private lateinit var binding: FragmentNewsDetailOneBinding
    private val args: NewsDetailOneFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: NewsDetailsOneViewModel

    @Inject
    lateinit var dummy: Dummy

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        viewModel = injectViewModel(viewModelFactory)
        // Inflate the layout for this fragment
        binding = FragmentNewsDetailOneBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = args.newsItem
        binding.newsViewModel = viewModel

        binding.addBtbn.setOnClickListener { viewModel.changeNumber.value =
            viewModel.changeNumber.value?.plus(1)
        }

        binding.minusBtn.setOnClickListener { viewModel.changeNumber.value =
            viewModel.changeNumber.value?.minus(1)
        }
    }

    companion object{
        public val TAG = NewsDetailOneFragment::class.java.simpleName
    }
}
