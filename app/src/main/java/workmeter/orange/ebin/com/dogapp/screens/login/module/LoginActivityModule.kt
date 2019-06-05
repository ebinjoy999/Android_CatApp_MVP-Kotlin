package workmeter.orange.ebin.com.dogapp.screens.login.module

import dagger.Module
import workmeter.orange.ebin.com.dogapp.screens.login.LoginActivity
import workmeter.orange.ebin.com.dogapp.screens.login.scope.LoginActivityScope

/**
 * Created by ebinjoy999 on 03/06/19.
 */
@LoginActivityScope
@Module
class LoginActivityModule {
    lateinit var loginActivity : LoginActivity

    constructor(loginActivity : LoginActivity){
        this.loginActivity = loginActivity;
    }

//    @Provides
//    @@LoginActivityScope
//    fun getAdapter(picasso: Picasso) : String {
//        return "";
//    }
}