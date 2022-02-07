package sm.projects.tvshowsapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList

interface RetroService {

    @GET("/search/shows?q=man/")
    suspend fun getTvShowsFromApi(@Query("q") query: String): TvShowList
}