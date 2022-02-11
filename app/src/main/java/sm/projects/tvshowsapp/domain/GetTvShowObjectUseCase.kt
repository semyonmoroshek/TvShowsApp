package sm.projects.tvshowsapp.domain

class GetTvShowObjectUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun getTvShowObject(tvShowObjectId: Int): TvShowObject{
        return tvShowRepository.getTvShowObject(tvShowObjectId)
    }
}