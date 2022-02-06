package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

interface TvShowRepository {

    fun addTvShowItem(tvShowItem: TvShowItem)
    fun getTvShowList(): List<TvShowItem>
    fun getTvShowItem(tvShowId: Int): TvShowItem
}