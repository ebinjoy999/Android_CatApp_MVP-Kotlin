package ebinjoy999.app.di.components

import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import dagger.Component
import ebinjoy999.app.api.ApiHelper
import retrofit2.Retrofit
import ebinjoy999.app.database.DBHandler
import ebinjoy999.app.di.scope.ApplicationScope
import ebinjoy999.app.di.modules.*
import ebinjoy999.app.di.qualifiers.CatApiServiceQualifier

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@ApplicationScope
@Component(modules = arrayOf(PicassoModule::class, PersistentStorageModule::class,
        CatAPIServiceModule::class)) //module will do the grouping

 interface AppComponent {
    fun getPicasso(): Picasso
    fun getApiHelper(): ApiHelper
    fun getSharedPref() :SharedPreferences
    fun getDBhandler() :DBHandler
}