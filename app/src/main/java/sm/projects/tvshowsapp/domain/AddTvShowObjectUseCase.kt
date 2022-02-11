package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShow
import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class AddTvShowObjectUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun addTvShowItem(tvShowObject: TvShowObject){
        tvShowRepository.addTvShowItemObject(tvShowObject)
    }
}