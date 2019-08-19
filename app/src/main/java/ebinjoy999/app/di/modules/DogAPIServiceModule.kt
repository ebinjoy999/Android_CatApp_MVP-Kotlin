package ebinjoy999.app.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ebinjoy999.app.R
import ebinjoy999.app.di.qualifiers.CatApiServiceQualifier
import ebinjoy999.app.di.scope.ApplicationScope

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(NetworkModule::class, ContextModule::class))
class DogAPIServiceModule {

    @Provides
    @ApplicationScope
    @CatApiServiceQualifier //@Named("service_retrofit")     //qualifier - annotation will help to differentiate different same class object
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson, c: Context): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(c.getString(R.string.base_url))
                .build()
    }
}