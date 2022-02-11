package sm.projects.tvshowsapp.domain

import androidx.lifecycle.LiveData

interface TvShowRepository {

    suspend fun addTvShowItemObject(tvShowObject: TvShowObject)
    suspend fun deleteTvShowObject(tvShowObject: TvShowObject)
    suspend fun getTvShowObject(tvShowObjectId: Int): TvShowObject
    fun getTvShowObjectList(): LiveData<List<TvShowObject>>

}