package ebinjoy999.app.screens.home.presenter

import ebinjoy999.app.api.ApiHelper
import ebinjoy999.app.base.presenter.BasePresenter
import ebinjoy999.app.screens.home.model.CatBreed
import ebinjoy999.app.screens.home.view.HomeActivityView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by macadmin on 8/21/19.
 */
class HomeActivityPresenterImpl<V : HomeActivityView>(private var mApiHelper: ApiHelper) : BasePresenter<V>(), HomeActivityPresenter<V>{


    override fun loadCatList(page :Int){
        var call : Call<ArrayList<CatBreed>> = mApiHelper.getCatListWithImages(page =  page)
        call.enqueue(object : Callback<ArrayList<CatBreed>> {
            override fun onResponse(call: Call<ArrayList<CatBreed>>?, response: Response<ArrayList<CatBreed>>?) {
                response?.body()?.let { getView1().onCatListResponse( it )}
            }
            override fun onFailure(call: Call<ArrayList<CatBreed>>?, t: Throwable?) {
            }
        })
    }

}