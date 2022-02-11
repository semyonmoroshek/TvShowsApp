package sm.projects.tvshowsapp.domain

import androidx.lifecycle.LiveData
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShow
import sm.projects.tvshowsapp.data.network.entities.TvShowItem

interface TvShowRepository {

    suspend fun addTvShowItemObject(tvShowObject: TvShowObject)
    suspend fun deleteTvShowObject(tvShowObject: TvShowObject)
    suspend fun getTvShowObject(tvShowObjectId: Int): TvShowObject
    fun getTvShowObjectList(): LiveData<List<TvShowObject>>

}