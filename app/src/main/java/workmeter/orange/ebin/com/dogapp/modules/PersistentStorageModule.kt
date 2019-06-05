package workmeter.orange.ebin.com.dogapp.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import workmeter.orange.ebin.com.dogapp.database.DBHandler
import workmeter.orange.ebin.com.dogapp.di.scope.OrangeApplicationScope

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(ContextModule::class))
 class PersistentStorageModule {

    @Provides
    @OrangeApplicationScope
      fun sharedPrefernce(context :Context) :SharedPreferences{
         return PreferenceManager.getDefaultSharedPreferences(context)
      }

    @Provides
    @OrangeApplicationScope
    fun databaseHandler(context :Context) :DBHandler{
        return  DBHandler(context);
    }

}