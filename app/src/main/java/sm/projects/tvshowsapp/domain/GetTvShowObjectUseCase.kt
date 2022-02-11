package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class GetTvShowObjectUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun getTvShowObject(tvShowObjectId: Int): TvShowObject{
        return tvShowRepository.getTvShowObject(tvShowObjectId)
    }
}