package sm.projects.tvshowsapp.domain

class DeleteTvShowObjectUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun deleteTvShowObject(tvShowObject: TvShowObject) {
        tvShowRepository.deleteTvShowObject(tvShowObject)
    }
}