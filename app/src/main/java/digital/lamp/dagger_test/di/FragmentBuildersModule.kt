package digital.lamp.dagger_test.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import digital.lamp.dagger_test.ui.detail_one.NewsDetailOneFragment
import digital.lamp.dagger_test.ui.details.NewsDetailsFragment
import digital.lamp.dagger_test.ui.list.NewsListingFragment

/**
 * Created by Amal Jofy Dept. on 09,March,2020
 */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeNewsListingFragment(): NewsListingFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsDetailsFragment(): NewsDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsDetailsOneFragment(): NewsDetailOneFragment
}
