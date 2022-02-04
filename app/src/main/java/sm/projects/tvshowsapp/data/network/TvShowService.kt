package sm.projects.tvshowsapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import sm.projects.tvshowsapp.data.network.network_entities.TvShow

interface TvShowService {

    @GET("/search/shows?q=man")
    suspend fun getTvShows(): Response<TvShow>
}