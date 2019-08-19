package ebinjoy999.app.screens.login.module

import dagger.Module
import ebinjoy999.app.screens.login.LoginActivity
import ebinjoy999.app.screens.login.scope.LoginActivityScope

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