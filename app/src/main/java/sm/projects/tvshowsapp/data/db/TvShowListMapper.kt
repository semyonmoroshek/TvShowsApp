package sm.projects.tvshowsapp.data.db

import sm.projects.tvshowsapp.domain.TvShowObject

class TvShowListMapper {

    fun mapEntityToDbModel(tvShowObject: TvShowObject) = TvShowDbModel(
        id = tvShowObject.id,
        name = tvShowObject.name,
        summary = tvShowObject.summary,
        language = tvShowObject.language
    )

    fun mapDbModelToEntity(tvShowDbModel: TvShowDbModel) = TvShowObject(
        id = tvShowDbModel.id,
        name = tvShowDbModel.name,
        summary = tvShowDbModel.summary,
        language = tvShowDbModel.language
    )

    fun mapListDbModelToListEntity(list: List<TvShowDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}