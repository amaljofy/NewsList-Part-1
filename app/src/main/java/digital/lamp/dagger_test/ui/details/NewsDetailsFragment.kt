package digital.lamp.dagger_test.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import digital.lamp.dagger_test.binding.bindImageFromUrl
import digital.lamp.dagger_test.databinding.NewsDetailsLayoutBinding
import digital.lamp.dagger_test.di.Injectable
import digital.lamp.dagger_test.di.injectViewModel
import javax.inject.Inject

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
class NewsDetailsFragment : Fragment(),Injectable {

    private val args: NewsDetailsFragmentArgs by navArgs()
    private lateinit var binding: NewsDetailsLayoutBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: NewsDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        viewModel = injectViewModel(viewModelFactory)
        // Inflate the layout for this fragment
        binding = NewsDetailsLayoutBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = args.data
        binding.newsDetailViewModel = viewModel
        binding.apply { newsItem = item }
        bindImageFromUrl(binding.newsImage,item?.newsContent?.imageThumb)


        binding.nextBtn.setOnClickListener {
            val direction = NewsDetailsFragmentDirections.actionNewsDetailsFragmentToNewsDetailOneFragment(item)
            findNavController().navigate(direction)
            viewModel.changeNumber.value = viewModel.changeNumber.value?.plus(10)
        }
    }
    companion object {
        private val TAG:String = NewsDetailsFragment::class.java.simpleName
    }
}
