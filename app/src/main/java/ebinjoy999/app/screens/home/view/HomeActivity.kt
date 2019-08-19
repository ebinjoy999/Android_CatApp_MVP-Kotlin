package ebinjoy999.app.screens.home.view

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import ebinjoy999.app.R
import ebinjoy999.app.appication.App
import ebinjoy999.app.database.DBHandler
import ebinjoy999.app.screens.home.component.HomeActivityComponent
import ebinjoy999.app.screens.home.HomeActivityModule
import javax.inject.Inject
import ebinjoy999.app.screens.home.model.CatBreed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import ebinjoy999.app.api.ApiHelper
import ebinjoy999.app.base.EndlessRecyclerViewScrollListener
import ebinjoy999.app.screens.home.adapter.CarListAdapter
import ebinjoy999.app.screens.home.component.DaggerHomeActivityComponent
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(){
    @Inject lateinit var sharedPreferences: SharedPreferences
    @Inject lateinit var dbHandler: DBHandler
    @Inject lateinit var picasso: Picasso
    @Inject lateinit var mApiHelper: ApiHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var homeActivityComponent: HomeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(HomeActivityModule(this))
                .appComponent(App.get(this).appComponent) //dependencies = arrayOf(AppComponent
                .build()
        homeActivityComponent.inject(this)
        loadCatList(1)
    }

    private fun loadCatList(page :Int) {
        var call : Call<ArrayList<CatBreed>> = mApiHelper.getCatListWithImages(page =  page)
        call.enqueue(object : Callback<ArrayList<CatBreed>> {
            override fun onResponse(call: Call<ArrayList<CatBreed>>?, response: Response<ArrayList<CatBreed>>?) {
                if(page==1)response?.body()?.let { setUpRV(it) }
                else response?.body()?.let { addToRV(it) }
            }
            override fun onFailure(call: Call<ArrayList<CatBreed>>?, t: Throwable?) {
            }
        })
    }

    private fun initViews() {

    }

    val linearLayoutManager = LinearLayoutManager(this)
    lateinit var adapter :CarListAdapter
    val rvPagination = object: EndlessRecyclerViewScrollListener(linearLayoutManager) {
        override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
            loadCatList(page+1)
        }
    }
    private fun addToRV(catBreeds :List<CatBreed>) {
        adapter.addItems(catBreeds)
        adapter.notifyDataSetChanged()
    }

    private fun setUpRV(catBreeds :ArrayList<CatBreed>) {
         adapter = CarListAdapter(picasso,this@HomeActivity, catBreeds)
        rv.layoutManager = linearLayoutManager
        rv.setOnScrollListener(rvPagination)
        rv.adapter = adapter
    }

}
