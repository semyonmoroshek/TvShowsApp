package sm.projects.tvshowsapp.data

import androidx.lifecycle.LiveData
import sm.projects.tvshowsapp.data.db.TvShowDao
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class TvShowListRepositoryImpl(private val tvShowDao: TvShowDao) {

    private val tvShowList = mutableListOf<TvShowDbModel>()


     suspend fun addTvShowDbModel(tvShowDbModel: TvShowDbModel) {
        tvShowDao.addTvShowItem(tvShowDbModel)
    }

     fun getTvShowDbModelList(): LiveData<List<TvShowDbModel>> {
        return tvShowDao.getTvShowList()
    }

    suspend fun deleteTvShowDbModelItem(tvShowDbModel: TvShowDbModel){
        tvShowDao.deleteShopItem(tvShowDbModel)
    }

    suspend fun getTvShowDbModelById(tvShowDbModelId: Int){
        tvShowDao.getShopItem(tvShowDbModelId)
    }
}
