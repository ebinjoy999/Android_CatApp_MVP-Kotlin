package ebinjoy999.app.screens.home.presenter

import ebinjoy999.app.api.ApiHelper
import ebinjoy999.app.appication.App
import ebinjoy999.app.base.presenter.BasePresenter
import ebinjoy999.app.screens.home.component.DaggerHomeActivityComponent
import ebinjoy999.app.screens.home.view.HomeActivityView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by macadmin on 8/21/19.
 */
class HomeActivityPresenterImpl<V :HomeActivityView> : BasePresenter<V>(), HomeActivityPresenter<V>{

    @Inject
    lateinit var mCompositeDisposable: CompositeDisposable
    @Inject
    lateinit var mApiHelper: ApiHelper

    override fun loadCatList(page :Int){
        mCompositeDisposable.add(mApiHelper.getCatListWithImages(page =  page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ breeds -> getView1().onCatListResponse( breeds )
        }, { error ->  }))
    }

    override fun onAttachView(view: V) {
        super.onAttachView(view)

    }

}