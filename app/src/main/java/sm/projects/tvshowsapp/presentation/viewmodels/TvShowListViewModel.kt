package sm.projects.tvshowsapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sm.projects.tvshowsapp.data.network.RetroService
import sm.projects.tvshowsapp.data.network.RetrofitInstance
import sm.projects.tvshowsapp.data.network.entities.TvShowList

class TvShowListViewModel : ViewModel() {

    var recyclerListLiveData: MutableLiveData<TvShowList> = MutableLiveData()

    fun getRecyclerListObserver(): MutableLiveData<TvShowList> {
        return recyclerListLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance =
                RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
            val tvShowItem = retroInstance.getTvShowsFromApi(query)
            recyclerListLiveData.postValue(tvShowItem)
        }
    }
}

