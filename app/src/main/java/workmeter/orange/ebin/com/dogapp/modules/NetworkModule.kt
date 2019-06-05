package workmeter.orange.ebin.com.dogapp.modules

import android.content.Context
import com.fatboyindustrial.gsonjodatime.DateTimeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import timber.log.Timber
import workmeter.orange.ebin.com.dogapp.di.scope.OrangeApplicationScope
import java.io.File

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(ContextModule::class))
public class NetworkModule {

    @Provides
    @OrangeApplicationScope
    fun httpLoggingInterceptor() : HttpLoggingInterceptor {
        var httpLoggingInterceptor :HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger{
            message ->
              Timber.i(message)
        })
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return httpLoggingInterceptor
    }

    @Provides
    @OrangeApplicationScope
    fun gson() : Gson {
      var gsonBuilder :GsonBuilder = GsonBuilder()
      gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())
        return  gsonBuilder.create()
    }

    @Provides
    @OrangeApplicationScope
    fun cache(cachefile : File) : Cache {
        return Cache(cachefile, 10* 1000 *1000) //10Mb cache
    }

    @Provides
    @OrangeApplicationScope
    fun cacheFile(context : Context) : File {
        return File(context.cacheDir, "okhttp_cache")
    }

     @Provides
     @OrangeApplicationScope
      fun okHttpClient(httpLoggingInterceptor :HttpLoggingInterceptor, cache :Cache) :OkHttpClient{
         return OkHttpClient.Builder()
                 .addInterceptor(httpLoggingInterceptor)
                 .cache(cache)
                 .build()
     }

}