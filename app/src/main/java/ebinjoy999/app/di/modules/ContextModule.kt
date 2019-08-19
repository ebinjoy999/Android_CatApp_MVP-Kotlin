package ebinjoy999.app.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ebinjoy999.app.di.scope.ApplicationScope

/**
 * Created by ebinjoy999 on 31/05/19.
 */

@Module
class ContextModule {

    private var context: Context

    constructor(context: Context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    fun context(): Context {
        return context;
    }

}