package sm.projects.tvshowsapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sm.projects.tvshowsapp.data.TvShowListRepositoryImpl
import sm.projects.tvshowsapp.domain.AddTvShowObjectUseCase
import sm.projects.tvshowsapp.domain.GetTvShowObjectUseCase
import sm.projects.tvshowsapp.domain.TvShowObject

class TvShowDescriptionViewModel(application: Application): AndroidViewModel(application) {

    private val repository = TvShowListRepositoryImpl(application)
    private val addTvShowObjectUseCase = AddTvShowObjectUseCase(repository)
    private val getTvShowObjectUseCase = GetTvShowObjectUseCase(repository)


    private val _showObject = MutableLiveData<TvShowObject>()
    val shopItem: LiveData<TvShowObject>
        get() = _showObject


    fun addTvShowObject(tvShowObject: TvShowObject) {
        viewModelScope.launch {
            addTvShowObjectUseCase.addTvShowItem(tvShowObject)
        }
    }

    fun getTvShowObject(tvShowObjectId: Int){
        viewModelScope.launch {
            val tvShowObject = getTvShowObjectUseCase.getTvShowObject(tvShowObjectId)
            _showObject.value = tvShowObject
        }
    }
}