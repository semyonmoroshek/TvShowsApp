package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShow
import sm.projects.tvshowsapp.data.network.entities.TvShowItem

interface TvShowRepository {

    suspend fun addTvShowItem(tvShowDbModel: TvShowDbModel)
    fun getTvShowList(): List<TvShowItem>
    fun getTvShowItem(tvShowId: Int): TvShowItem
    fun downloadTvShowListFromApi(searchQuery: String) : List<TvShowItem>
}