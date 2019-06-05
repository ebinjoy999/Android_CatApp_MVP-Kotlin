package workmeter.orange.ebin.com.dogapp.screens.home

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import workmeter.orange.ebin.com.dogapp.R
import workmeter.orange.ebin.com.dogapp.appication.DogApp
import workmeter.orange.ebin.com.dogapp.database.DBHandler
import workmeter.orange.ebin.com.dogapp.screens.home.component.DaggerHomeActivityComponent
import workmeter.orange.ebin.com.dogapp.screens.home.component.HomeActivityComponent
import workmeter.orange.ebin.com.dogapp.screens.home.module.HomeActivityModule
import workmeter.orange.ebin.com.dogapp.screens.home.view.CountingTextView
import workmeter.orange.ebin.com.dogapp.screens.login.LoginActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

//    @Inject  @field:OmdbService lateinit var retrofitOmdbService: Retrofit
//    @Inject @field:Named("orangeservice_retrofit") lateinit var retrofitOrangeService: Retrofit


    @Inject lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var dbHandler : DBHandler
    lateinit var countingTextView : CountingTextView

//    https://github.com/uguratar/countingtextview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        getSupportActionBar()?.hide();
        var homeActivityComponent :HomeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(HomeActivityModule(this))
                .dogAppComponent(DogApp.get(this).getOrangAppComponent()) //dependencies = arrayOf(DogAppComponent

                .build()
        homeActivityComponent.inject(this)
        if(checkKeyNeeded()){
            var intent = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(intent)
            this@HomeActivity.finish()
        }
        initViews();
        loadValues()

    }

    private fun loadValues() {
//        countingTextView.animateText(0,7);
    }

    private fun initViews() {
//        countingTextView = findViewById(R.id.textViewHour)
    }

    private fun checkKeyNeeded(): Boolean {
        return sharedPreferences.getString("key","").equals("");

    }
}
