package ebinjoy999.app.di.modules

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import ebinjoy999.app.di.scope.ApplicationScope

/**
 * Created by ebinjoy999 on 31/05/19.
 */

@Module(includes = arrayOf(ContextModule::class, NetworkModule::class))
class PicassoModule  {

    @Provides
    @ApplicationScope
    fun picasso(context: Context
                , okHttp3Downloader :OkHttp3Downloader) :Picasso{
        return Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build()
    }

    @Provides
    @ApplicationScope
    fun okHttp3Downloader(okHttpClient: OkHttpClient) :OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }
}