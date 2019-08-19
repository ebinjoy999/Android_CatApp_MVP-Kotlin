package ebinjoy999.app.screens.home.model

/**
 * Created by macadmin on 8/17/19.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weight {

    @SerializedName("imperial")
    @Expose
    var imperial: String? = null
    @SerializedName("metric")
    @Expose
    var metric: String? = null
}