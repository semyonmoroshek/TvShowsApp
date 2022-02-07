package sm.projects.tvshowsapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sm.projects.tvshowsapp.data.network.RetroService
import sm.projects.tvshowsapp.data.network.RetrofitInstance
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList

class MainViewModel : ViewModel() {

    lateinit var recyclerListLiveData: MutableLiveData<TvShowList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<TvShowList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance =
                RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
            val tvShowItem = retroInstance.getTvShowsFromApi()
            recyclerListLiveData.postValue(tvShowItem)
        }
    }
}

