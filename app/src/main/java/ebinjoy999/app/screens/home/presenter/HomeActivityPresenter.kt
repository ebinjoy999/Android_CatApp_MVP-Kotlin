package ebinjoy999.app.screens.home.presenter

import ebinjoy999.app.base.presenter.MVPPresenter
import ebinjoy999.app.screens.home.model.CatBreed
import ebinjoy999.app.screens.home.view.HomeActivityView

/**
 * Created by macadmin on 8/21/19.
 */

interface HomeActivityPresenter<V : HomeActivityView> : MVPPresenter<V>{
    fun loadCatList(page :Int)
}