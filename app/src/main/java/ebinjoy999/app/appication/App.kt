package ebinjoy999.app.appication

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import timber.log.Timber
import ebinjoy999.app.di.components.AppComponent
import ebinjoy999.app.di.components.DaggerAppComponent
import ebinjoy999.app.di.modules.*

/**
 * Created by ebinjoy999 on 31/05/19.
 */
class App : Application() {

    lateinit var appComponent: AppComponent //public interface to your dependency graph
    private lateinit var retrofit :Retrofit
    private lateinit var picasso :Picasso
    private lateinit var sharedPreferences :SharedPreferences

    companion object {
        fun get(activity: Activity) : App {
            return activity.applicationContext as App
        }
    }

    override fun onCreate() {
        super.onCreate()
      Timber.plant(Timber.DebugTree())
         appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))   //have constructor, Dagger don't know how initialize so we need to specify
//                .orangeServiceModule(CatAPIServiceModule())
//                .networkModule(NetworkModule())
//                .picassoModule(PicassoModule())
//                .persistentStorageModule(PersistentStorageModule())
                //not needed modules, unless a constructor there....Dagger will create for you
                .build()
//        retrofit = appComponent.getRetrofitService() //each time call, returns differ object; so scope
        picasso = appComponent.getPicasso()

        sharedPreferences = appComponent.getSharedPref()
    }

}