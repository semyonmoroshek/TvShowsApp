package sm.projects.tvshowsapp.presentation.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sm.projects.tvshowsapp.data.TvShowListRepositoryImpl
import sm.projects.tvshowsapp.data.db.AppDatabase
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShowList
import sm.projects.tvshowsapp.domain.*

class TvShowFavoriteListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TvShowListRepositoryImpl(application)

    private val addTvShowObjectUseCase = AddTvShowObjectUseCase(repository)
    private val deleteTvShowObjectUseCase = DeleteTvShowObjectUseCase(repository)
    private val getTvShowListUseCase = GetTvShowListUseCase(repository)
    private val getTvShowObjectUseCase = GetTvShowObjectUseCase(repository)

    val tvShowList = getTvShowListUseCase.getTvShowObjectList()


    fun addTvShowObject(tvShowObject: TvShowObject) {
            viewModelScope.launch {
               addTvShowObjectUseCase.addTvShowItem(tvShowObject)
        }
    }

    fun deleteTvShowObject(tvShowObject: TvShowObject) {
        viewModelScope.launch {
            deleteTvShowObjectUseCase.deleteTvShowObject(tvShowObject)
        }
    }

    fun getTvShowObject(tvShowObjectId: Int){
        viewModelScope.launch {
            val tvShowObject = getTvShowObjectUseCase.getTvShowObject(tvShowObjectId)
        }
    }

}