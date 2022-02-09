package sm.projects.tvshowsapp.domain

import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class GetTvShowListUseCase(private val tvShowRepository: TvShowRepository) {

    fun getTvShowList(): List<TvShowItem> {
        return tvShowRepository.getTvShowList()
    }
}