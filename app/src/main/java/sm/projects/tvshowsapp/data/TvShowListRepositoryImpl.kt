package sm.projects.tvshowsapp.data

import android.util.Log
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem
import sm.projects.tvshowsapp.domain.TvShowRepository
import java.lang.RuntimeException

object TvShowListRepositoryImpl : TvShowRepository {

    private val tvShowList = mutableListOf<TvShowItem>()


    override fun addTvShowItem(tvShowItem: TvShowItem) {
        Log.i("ADDLIST", "adding item")
        tvShowList.add(tvShowItem)
    }


    override fun getTvShowList(): List<TvShowItem> {
        Log.i("GETLIST", "getting list")
        return tvShowList.toList()
    }

    override fun getTvShowItem(tvShowId: Int): TvShowItem {
        Log.i("GETITEM", "getting item")

        return tvShowList.find { it.show.id == tvShowId } ?:
        throw RuntimeException ("Element with id $tvShowId not found")
    }


}
