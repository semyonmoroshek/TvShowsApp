package sm.projects.tvshowsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTvShowItem(tvShowItemDbModel: TvShowDbModel)

    @Query("SELECT * FROM show_table")
    fun getShopList(): LiveData<List<TvShowDbModel>>

    @Query("DELETE FROM show_table WHERE id=:shopItemId")
    suspend fun deleteShopItem(shopItemId: Int)
}