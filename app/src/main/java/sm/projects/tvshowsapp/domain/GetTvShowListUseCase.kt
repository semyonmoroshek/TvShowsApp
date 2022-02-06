package sm.projects.tvshowsapp.domain

import androidx.lifecycle.LiveData
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class GetTvShowListUseCase(private val tvShowRepository: TvShowRepository) {

    fun getTvShowList(): List<TvShowItem> {
        return tvShowRepository.getTvShowList()
    }
}