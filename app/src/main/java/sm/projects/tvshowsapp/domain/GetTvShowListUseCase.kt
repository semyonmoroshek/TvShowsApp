package sm.projects.tvshowsapp.domain

import androidx.lifecycle.LiveData

class GetTvShowListUseCase(private val tvShowRepository: TvShowRepository) {

    fun getTvShowObjectList(): LiveData<List<TvShowObject>> {
        return tvShowRepository.getTvShowObjectList()
    }
}