package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class GetTvShowItemUseCase(private val tvShowRepository: TvShowRepository) {

    fun getShowItem(tvShowId: Int): TvShowItem{
        return tvShowRepository.getTvShowItem(tvShowId)
    }
}