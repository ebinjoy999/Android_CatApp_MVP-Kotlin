package workmeter.orange.ebin.com.dogapp.screens.login.component

import dagger.Component
import workmeter.orange.ebin.com.dogapp.di.components.DogAppComponent
import workmeter.orange.ebin.com.dogapp.screens.login.LoginActivity
import workmeter.orange.ebin.com.dogapp.screens.login.module.LoginActivityModule
import workmeter.orange.ebin.com.dogapp.screens.login.scope.LoginActivityScope

/**
 * Created by ebinjoy999 on 03/06/19.
 */
@LoginActivityScope
@Component(modules = arrayOf(LoginActivityModule::class), dependencies = arrayOf(DogAppComponent::class))
interface LoginActivityComponent {
    fun inject(target: LoginActivity)
}