package ebinjoy999.app.screens.home.component

import dagger.Component
import ebinjoy999.app.di.components.AppComponent
import ebinjoy999.app.screens.home.HomeActivityModule
import ebinjoy999.app.screens.home.view.HomeActivity
import ebinjoy999.app.screens.home.scope.HomeActivityScope



/**
 * Created by ebinjoy999 on 01/06/19.
 */

@HomeActivityScope
@Component(modules = arrayOf(HomeActivityModule::class), dependencies = arrayOf(AppComponent::class))
public interface HomeActivityComponent {
    //General rule is if something have a different lifecycle then should have different components
    //fun getAdapter(): String
    fun inject(target: HomeActivity)
}