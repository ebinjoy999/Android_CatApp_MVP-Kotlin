package workmeter.orange.ebin.com.dogapp.di.scope

import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class OrangeApplicationScope
// each time call, returns differ object; so define scope

