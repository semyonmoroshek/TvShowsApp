package sm.projects.tvshowsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import sm.projects.tvshowsapp.domain.TvShowObject

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTvShowObject(tvShowItemDbModel: TvShowDbModel)

    @Query("SELECT * FROM show_table")
    fun getTvShowList(): LiveData<List<TvShowDbModel>>

    @Query("DELETE FROM show_table WHERE id=:tvShowObjectId")
    suspend fun deleteTvShowObject(tvShowObjectId: Int)

    @Query("SELECT * FROM show_table WHERE id=:tvShowObjectId LIMIT 1")
    suspend fun getTvShowObject(tvShowObjectId: Int): TvShowDbModel


}