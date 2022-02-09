package sm.projects.tvshowsapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sm.projects.tvshowsapp.data.TvShowListRepositoryImpl
import sm.projects.tvshowsapp.data.db.AppDatabase
import sm.projects.tvshowsapp.data.db.TvShowDbModel

class TvShowItemViewModel(application: Application) : AndroidViewModel(application) {




    private val memberDao = AppDatabase.getInstance(application).shopListDao()
    private val repository: TvShowListRepositoryImpl = TvShowListRepositoryImpl(memberDao)


//    private val addShowItemUseCase = AddTvShowItemUseCase(repository)

//    private val getShopListUseCase = GetShopListUseCase(repository)
//    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
//    private val editShopItemUseCase = EditShopItemUseCase(repository)
//
//    val shopList = getShopListUseCase.getShopList()


    fun addShow(showDbModel: TvShowDbModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTvShowDbModel(showDbModel)
        }
    }

    fun getTvShowDbModelList(){
        viewModelScope.launch(Dispatchers.IO) {
           repository.getTvShowDbModelList()
        }
    }

    fun getTvShowDbModelItem(tvShowDbModelId: Int){
        viewModelScope.launch {
            repository.getTvShowDbModelById(tvShowDbModelId)
        }
    }
}