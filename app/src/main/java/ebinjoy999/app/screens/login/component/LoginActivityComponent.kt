package ebinjoy999.app.screens.login.component

import dagger.Component
import ebinjoy999.app.di.components.AppComponent
import ebinjoy999.app.screens.login.LoginActivity
import ebinjoy999.app.screens.login.module.LoginActivityModule
import ebinjoy999.app.screens.login.scope.LoginActivityScope

/**
 * Created by ebinjoy999 on 03/06/19.
 */
@LoginActivityScope
@Component(modules = arrayOf(LoginActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginActivityComponent {  //if any component have different lifecycle define its component
    fun inject(target: LoginActivity)
}