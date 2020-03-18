package digital.lamp.dagger_test

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import digital.lamp.dagger_test.di.AppInjector
import javax.inject.Inject

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
    override fun activityInjector() = dispatchingAndroidInjector
}