package workmeter.orange.ebin.com.dogapp.appication

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import retrofit2.Retrofit
import timber.log.Timber
import workmeter.orange.ebin.com.dogapp.di.components.DaggerDogAppComponent
import workmeter.orange.ebin.com.dogapp.di.components.DogAppComponent
import workmeter.orange.ebin.com.dogapp.modules.*

/**
 * Created by ebinjoy999 on 31/05/19.
 */
class DogApp : Application() {

    lateinit var dogAppComponent : DogAppComponent
    private lateinit var retrofit :Retrofit
    private lateinit var picasso :Picasso
    private lateinit var sharedPreferences :SharedPreferences

    companion object {
        fun get(activity: Activity) :DogApp{
            return activity.applicationContext as DogApp
        }
    }

    override fun onCreate() {
        super.onCreate()
      Timber.plant(Timber.DebugTree())
         dogAppComponent = DaggerDogAppComponent.builder()
                .contextModule(ContextModule(this))   //have constructor, Dagger don't know how initialize so we need to specify
//                .orangeServiceModule(DogAPIServiceModule())
//                .networkModule(NetworkModule())
//                .picassoModule(PicassoModule())
//                .persistentStorageModule(PersistentStorageModule())
                //not needed modules unless a constructor there....it will create for you
                .build()
        retrofit = dogAppComponent.getRetrofitOrangeService() //each time call, returns differ object; so scope

        picasso = dogAppComponent.getPicasso()
//        picasso1 = dogAppComponent.getPicasso()
//        picasso2 = dogAppComponent.getPicasso()
//        Log.e("picasso", picasso.toString())
//        Log.e("picasso1", picasso1.toString())
//        Log.e("picasso2", picasso2.toString())

        sharedPreferences = dogAppComponent.getSharedPref()
    }

    fun getOrangAppComponent() :DogAppComponent{
        return dogAppComponent
    }
}