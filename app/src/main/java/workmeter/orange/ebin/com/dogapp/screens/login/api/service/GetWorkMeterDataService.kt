package workmeter.orange.ebin.com.dogapp.screens.login.api.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import workmeter.orange.ebin.com.dogapp.screens.login.model.Workmeter


/**
 * Created by ebinjoy999 on 03/06/19.
 */
interface GetWorkMeterDataService {

    @GET("services/c/{key}")
    fun getWorkMeterDataService( @Path("key") id :String) :Call<Workmeter>
}