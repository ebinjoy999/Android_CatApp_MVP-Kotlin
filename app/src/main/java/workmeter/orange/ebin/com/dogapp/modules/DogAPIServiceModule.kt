package workmeter.orange.ebin.com.dogapp.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import workmeter.orange.ebin.com.dogapp.R
import workmeter.orange.ebin.com.dogapp.di.scope.OrangeApplicationScope
import javax.inject.Named

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(NetworkModule::class, ContextModule::class))
class DogAPIServiceModule{

    //qualifier - annotation will help to differentiate different same class object
    @Provides
    @OrangeApplicationScope
    @Named("orangeservice_retrofit")
    fun retrofit(okHttpClient :OkHttpClient, gson : Gson, c :Context): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(c.getString(R.string.base_url))
                .build()
    }


}