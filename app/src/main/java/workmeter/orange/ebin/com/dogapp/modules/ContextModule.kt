package workmeter.orange.ebin.com.dogapp.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import workmeter.orange.ebin.com.dogapp.di.scope.OrangeApplicationScope

/**
 * Created by ebinjoy999 on 31/05/19.
 */

@Module
 class ContextModule {

    private lateinit var context :Context

    constructor(context :Context){
        this.context = context;
    }

    @Provides
    @OrangeApplicationScope
    fun context() :Context{
      return context;
    }

}