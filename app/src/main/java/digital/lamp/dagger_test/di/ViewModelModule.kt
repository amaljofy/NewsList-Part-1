package digital.lamp.dagger_test.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import digital.lamp.dagger_test.ui.detail_one.NewsDetailsOneViewModel
import digital.lamp.dagger_test.ui.details.NewsDetailsViewModel
import digital.lamp.dagger_test.ui.list.NewsListingViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsListingViewModel::class)
    abstract fun bindNewsListViewModel(viewModel: NewsListingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsViewModel::class)
    abstract fun  bindNewsDetailsViewModel(viewModel: NewsDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsOneViewModel::class)
    abstract fun  bindNewsDetailsOneViewModel(viewModel: NewsDetailsOneViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
