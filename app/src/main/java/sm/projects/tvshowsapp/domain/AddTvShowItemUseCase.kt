package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class AddTvShowItemUseCase(private val tvShowRepository: TvShowRepository) {

    fun addTvShowItem(tvShowItem: TvShowItem){
        tvShowRepository.addTvShowItem(tvShowItem)
    }
}