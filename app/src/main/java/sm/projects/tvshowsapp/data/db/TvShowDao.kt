package sm.projects.tvshowsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTvShowItem(tvShowItemDbModel: TvShowDbModel)

    @Query("SELECT * FROM show_table")
    fun getTvShowList(): LiveData<List<TvShowDbModel>>

    @Delete
    suspend fun deleteShopItem(tvShowItemDbModel: TvShowDbModel)

    @Query("SELECT * FROM show_table WHERE id=:tvShowDbModelId LIMIT 1")
    suspend fun getShopItem(tvShowDbModelId: Int): TvShowDbModel


}