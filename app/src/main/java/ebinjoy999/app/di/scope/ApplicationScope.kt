package ebinjoy999.app.di.scope

import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope
// each time call, returns differ object; so define scope

