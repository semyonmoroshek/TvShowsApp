package sm.projects.tvshowsapp.domain

class AddTvShowObjectUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun addTvShowItem(tvShowObject: TvShowObject){
        tvShowRepository.addTvShowItemObject(tvShowObject)
    }
}