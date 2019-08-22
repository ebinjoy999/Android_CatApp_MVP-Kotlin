package ebinjoy999.app.api

import ebinjoy999.app.screens.home.model.CatBreed
import ebinjoy999.app.utils.AppConstants
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by macadmin on 8/19/19.
 */
interface ApiHelper {

    @GET("images/search")
    fun getCatListWithImages(@Query("size") size: String = "thumb",
                             @Query("mime_types") mime_types: String = "jpg", @Query("format") format: String = "json",
                             @Query("has_breeds") has_breeds: Boolean = true, @Query("order") order: String = "RANDOM",
                             @Query("limit") limit: Int = AppConstants.PAGE_LIMIT, @Query("page") page: Int): Observable<ArrayList<CatBreed>>
}
