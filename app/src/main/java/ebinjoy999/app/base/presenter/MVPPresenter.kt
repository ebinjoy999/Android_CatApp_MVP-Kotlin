package ebinjoy999.app.base.presenter

import ebinjoy999.app.base.view.BaseView

/**
 * Created by macadmin on 8/19/19.
 */


interface MVPPresenter<V : BaseView> {
    val view: V
    fun onAttachView(view: V)
}
