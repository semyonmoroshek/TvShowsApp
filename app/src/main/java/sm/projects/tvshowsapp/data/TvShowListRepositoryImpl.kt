package sm.projects.tvshowsapp.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import sm.projects.tvshowsapp.data.db.AppDatabase
import sm.projects.tvshowsapp.data.db.TvShowListMapper
import sm.projects.tvshowsapp.domain.TvShowObject
import sm.projects.tvshowsapp.domain.TvShowRepository


class TvShowListRepositoryImpl(
    application: Application
) : TvShowRepository {

    private val tvShowListDao = AppDatabase.getInstance(application).tvShowDao()
    private val mapper = TvShowListMapper()

    override suspend fun addTvShowItemObject(tvShowObject: TvShowObject) {
        Log.i("showadded", "showadded")

        tvShowListDao.addTvShowObject(mapper.mapEntityToDbModel(tvShowObject))
    }

    override suspend fun deleteTvShowObject(tvShowObject: TvShowObject) {
        tvShowListDao.deleteTvShowObject(tvShowObject.id)
    }

    override suspend fun getTvShowObject(tvShowObjectId: Int): TvShowObject {
        val dbModel = tvShowListDao.getTvShowObject(tvShowObjectId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getTvShowObjectList(): LiveData<List<TvShowObject>> = Transformations.map(
        tvShowListDao.getTvShowList()
    ) {
        mapper.mapListDbModelToListEntity(it)
    }
}
