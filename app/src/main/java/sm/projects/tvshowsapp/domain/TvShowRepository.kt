package sm.projects.tvshowsapp.domain

import androidx.lifecycle.LiveData
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList

interface TvShowRepository {

    fun addTvShowItem(tvShowItem: TvShowItem)
    fun getTvShowList(): List<TvShowItem>
    fun getTvShowItem(tvShowId: Int): TvShowItem


}