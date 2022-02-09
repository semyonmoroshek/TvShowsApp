package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.entities.TvShowItem

interface TvShowRepository {

    fun addTvShowItem(tvShowItem: TvShowItem)
    fun getTvShowList(): List<TvShowItem>
    fun getTvShowItem(tvShowId: Int): TvShowItem
    fun downloadTvShowListFromApi(searchQuery: String) : List<TvShowItem>
}