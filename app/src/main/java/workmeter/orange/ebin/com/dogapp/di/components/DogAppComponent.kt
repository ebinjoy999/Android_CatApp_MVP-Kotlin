package workmeter.orange.ebin.com.dogapp.di.components

import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import dagger.Component
import retrofit2.Retrofit
import workmeter.orange.ebin.com.dogapp.database.DBHandler
import workmeter.orange.ebin.com.dogapp.di.qualifiers.OmdbService
import workmeter.orange.ebin.com.dogapp.di.scope.OrangeApplicationScope
import workmeter.orange.ebin.com.dogapp.modules.*
import javax.inject.Named

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@OrangeApplicationScope
@Component(modules = arrayOf(PicassoModule::class, PersistentStorageModule::class,
        DogAPIServiceModule::class))
 interface DogAppComponent {
    fun getPicasso(): Picasso
   @Named("orangeservice_retrofit") fun getRetrofitOrangeService(): Retrofit
    fun getSharedPref() :SharedPreferences
    fun getDBhandler() :DBHandler
}