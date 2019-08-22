package ebinjoy999.app.base.view

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MenuItem
/**
 * Created by macadmin on 8/21/19.
 */

abstract class BaseActivity : AppCompatActivity() { //HasFragmentInjector {

    protected abstract val contentView: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        // AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(contentView)
        onViewReady(savedInstanceState, intent)
    }

    @CallSuper
    open fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        resolveDaggerDependency()
        //To be used by child activities
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected fun resolveDaggerDependency() {}

    protected fun showBackArrow() {
        val supportActionBar = supportActionBar
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true)
            supportActionBar.setDisplayShowHomeEnabled(true)
            supportActionBar.setDisplayShowTitleEnabled(false)
        }
    }

    protected fun forceUserToLogin() {

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        //replaces the default 'Back' button action
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val i: Intent? = null
        when (item.itemId) {
            android.R.id.home -> {
                onKeyDown(KeyEvent.KEYCODE_BACK, null)
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }


}
