package ebinjoy999.app.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ebinjoy999.app.database.DBHandler
import ebinjoy999.app.di.scope.ApplicationScope

/**
 * Created by ebinjoy999 on 30/05/19.
 */

@Module(includes = arrayOf(ContextModule::class))
 class PersistentStorageModule {

    @Provides
    @ApplicationScope
      fun sharedPrefernce(context :Context) :SharedPreferences{
         return PreferenceManager.getDefaultSharedPreferences(context)
      }

    @Provides
    @ApplicationScope
    fun databaseHandler(context :Context) :DBHandler{
        return  DBHandler(context);
    }

}