package ebinjoy999.app.screens.home.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import ebinjoy999.app.R
import ebinjoy999.app.appication.App
import ebinjoy999.app.database.DBHandler
import ebinjoy999.app.screens.home.component.HomeActivityComponent
import ebinjoy999.app.screens.home.HomeActivityModule
import javax.inject.Inject
import ebinjoy999.app.screens.home.model.CatBreed
import android.support.v7.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import ebinjoy999.app.base.EndlessRecyclerViewScrollListener
import ebinjoy999.app.base.view.BaseActivity
import ebinjoy999.app.screens.home.view.adapter.CarListAdapter
import ebinjoy999.app.screens.home.component.DaggerHomeActivityComponent
import ebinjoy999.app.screens.home.presenter.HomeActivityPresenter
import ebinjoy999.app.screens.home.presenter.HomeActivityPresenterImpl
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity(), HomeActivityView{
    override val contentView: Int
        get() = R.layout.activity_home //To change initializer of created properties use File | Settings | File Templates.
    val linearLayoutManager = LinearLayoutManager(this)
    var adapter : CarListAdapter? = null
    @Inject lateinit var sharedPreferences: SharedPreferences
    @Inject lateinit var dbHandler: DBHandler
    @Inject lateinit var picasso: Picasso
    @Inject lateinit var homeActivityPresenter: HomeActivityPresenterImpl<HomeActivityView>

    override fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
        super.onViewReady(savedInstanceState, intent)


        var homeActivityComponent: HomeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(HomeActivityModule(this))
                .appComponent(App.get(this).appComponent) //dependencies = arrayOf(AppComponent
                .build()
        homeActivityComponent.inject(this)
        homeActivityComponent.inject(homeActivityPresenter)

        homeActivityPresenter.onAttachView(this)
        homeActivityPresenter.loadCatList(1)
    }


    override fun onCatListResponse(list: ArrayList<CatBreed>) {
        if ( adapter == null ){
            setUpRV(list)
        }else{
            addToRV(list)
        }
    }


    val rvPagination = object: EndlessRecyclerViewScrollListener(linearLayoutManager) {
        override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
            homeActivityPresenter.loadCatList(page+1)
        }
    }
    private fun addToRV(catBreeds :List<CatBreed>) {
        adapter?.addItems(catBreeds)
        adapter?.notifyDataSetChanged()
    }

    private fun setUpRV(catBreeds :ArrayList<CatBreed>) {
         adapter = CarListAdapter(picasso,this@HomeActivity, catBreeds)
        rv.layoutManager = linearLayoutManager
        rv.setOnScrollListener(rvPagination)
        rv.adapter = adapter
    }

    override fun onShowProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAlert(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onHideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
