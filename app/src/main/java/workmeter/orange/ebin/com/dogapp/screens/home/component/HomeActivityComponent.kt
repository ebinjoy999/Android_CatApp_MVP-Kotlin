package workmeter.orange.ebin.com.dogapp.screens.home.component

import dagger.Component
import workmeter.orange.ebin.com.dogapp.di.components.DogAppComponent
import workmeter.orange.ebin.com.dogapp.screens.home.HomeActivity
import workmeter.orange.ebin.com.dogapp.screens.home.module.HomeActivityModule
import workmeter.orange.ebin.com.dogapp.screens.home.scope.HomeActivityScope



/**
 * Created by ebinjoy999 on 01/06/19.
 */

@HomeActivityScope
@Component(modules = arrayOf(HomeActivityModule::class), dependencies = arrayOf(DogAppComponent::class))
public interface HomeActivityComponent {
    //General rule is if something have a different lifecycle then should have different components
    //fun getAdapter(): String
    fun inject(target: HomeActivity)
}