package ebinjoy999.app.screens.login.api.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ebinjoy999.app.screens.login.model.Workmeter


/**
 * Created by ebinjoy999 on 03/06/19.
 */
interface GetWorkMeterDataService {

    @GET("services/c/{key}")
    fun getWorkMeterDataService( @Path("key") id :String) :Call<Workmeter>
}