package sm.projects.tvshowsapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import sm.projects.tvshowsapp.data.network.entities.TvShowList

interface RetroService {

    @GET("/search/shows?q=")
    suspend fun getTvShowsFromApi(@Query("q") query: String): TvShowList
}