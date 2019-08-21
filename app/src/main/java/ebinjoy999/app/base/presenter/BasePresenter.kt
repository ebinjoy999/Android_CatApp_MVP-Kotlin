package ebinjoy999.app.base.presenter

import ebinjoy999.app.base.view.BaseView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by macadmin on 8/19/19.
 */

open class BasePresenter<V : BaseView> : MVPPresenter<V> {

    override lateinit var view: V

    override fun onAttachView(view: V) {
        this.view = view
    }

    fun getView1(): V {
        return view
    }


    protected fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}
