package digital.lamp.dagger_test.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import digital.lamp.dagger_test.MainActivity

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}