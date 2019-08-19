package ebinjoy999.app.screens.home.model

/**
 * Created by macadmin on 8/17/19.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatBreed {

    @SerializedName("breeds")
    @Expose
    var breeds: List<Breed>? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null

}