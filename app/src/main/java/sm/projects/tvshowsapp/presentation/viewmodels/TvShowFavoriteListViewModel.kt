package sm.projects.tvshowsapp.presentation.viewmodels

import android.app.Application
import android.text.TextUtils
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
import sm.projects.tvshowsapp.data.network.RetroService
import sm.projects.tvshowsapp.data.network.RetrofitInstance
import sm.projects.tvshowsapp.data.network.entities.TvShowList
import sm.projects.tvshowsapp.domain.*

class TvShowFavoriteListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TvShowListRepositoryImpl(application)

    private val addTvShowObjectUseCase = AddTvShowObjectUseCase(repository)
    private val deleteTvShowObjectUseCase = DeleteTvShowObjectUseCase(repository)
    private val getTvShowListUseCase = GetTvShowListUseCase(repository)
    private val getTvShowObjectUseCase = GetTvShowObjectUseCase(repository)

    val tvShowList = getTvShowListUseCase.getTvShowObjectList()

    var recyclerFavoriteListLiveData: MutableLiveData<List<TvShowDbModel>> = MutableLiveData()

    fun deleteTvShowObject(tvShowObject: TvShowObject) {
        viewModelScope.launch {
            deleteTvShowObjectUseCase.deleteTvShowObject(tvShowObject)
        }
    }

    fun addTvShowObject(tvShowObject: TvShowObject) {
        viewModelScope.launch {
            addTvShowObjectUseCase.addTvShowItem(tvShowObject)
        }
    }

//    var recyclerListLiveData: MutableLiveData<TvShowList> = MutableLiveData()

//    fun getRecyclerListObserver(): MutableLiveData<TvShowList> {
//        return recyclerListLiveData
//    }
//
//    fun makeApiCall(query: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val retroInstance =
//                RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
//            val tvShowItem = retroInstance.getTvShowsFromApi(query)
//            recyclerListLiveData.postValue(tvShowItem)
//        }
//    }


}