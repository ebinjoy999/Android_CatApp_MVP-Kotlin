package ebinjoy999.app.screens.home.view

import ebinjoy999.app.base.view.BaseView
import ebinjoy999.app.screens.home.model.CatBreed

/**
 * Created by macadmin on 8/21/19.
 */

public interface HomeActivityView : BaseView{
    fun onCatListResponse(list: ArrayList<CatBreed>)
}