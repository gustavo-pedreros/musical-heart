package labs.gas.musical.search.data.remote.itunes

import labs.gas.musical.search.data.model.MediaResponseRemoteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesApi {
    @GET("search")
    suspend fun search(@Query("term") artist: String): Response<MediaResponseRemoteModel>
}
