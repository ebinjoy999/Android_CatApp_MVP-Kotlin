package workmeter.orange.ebin.com.dogapp.screens.home.module

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import workmeter.orange.ebin.com.dogapp.screens.home.HomeActivity
import workmeter.orange.ebin.com.dogapp.screens.home.scope.HomeActivityScope

/**
 * Created by ebinjoy999 on 01/06/19.
 */

@Module
class HomeActivityModule {

    lateinit var homeActivity : HomeActivity

    constructor(homeActivity : HomeActivity){
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    fun getAdapter(picasso: Picasso ) : String {
        return "";
    }
}