package ebinjoy999.app.screens.home.module

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import ebinjoy999.app.screens.home.view.HomeActivity
import ebinjoy999.app.screens.home.scope.HomeActivityScope

/**
 * Created by ebinjoy999 on 01/06/19.
 */

@Module
class HomeActivityModule {
    var homeActivity: HomeActivity

    constructor(homeActivity: HomeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    fun getAdapter(picasso: Picasso): String {
        return "";
    }
}