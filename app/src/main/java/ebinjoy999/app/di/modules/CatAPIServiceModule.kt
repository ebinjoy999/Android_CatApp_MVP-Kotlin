package ebinjoy999.app.di.modules

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ebinjoy999.app.R
import ebinjoy999.app.api.ApiHelper
import ebinjoy999.app.di.qualifiers.CatApiServiceQualifier
import ebinjoy999.app.di.scope.ApplicationScope

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(NetworkModule::class, ContextModule::class))
class CatAPIServiceModule {

    @Provides
    @ApplicationScope
    @CatApiServiceQualifier //@Named("service_retrofit")     //qualifier - annotation will help to differentiate different same class object
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson, c: Context): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(c.getString(R.string.base_url))
                .build()
    }

    @Provides
    @ApplicationScope
     fun provideApiService( @CatApiServiceQualifier retrofit: Retrofit): ApiHelper {
//         retrofit.create<ApiHelper>(ApiHelper::class.java)
        return retrofit.create(ApiHelper::class.java)
    }
}