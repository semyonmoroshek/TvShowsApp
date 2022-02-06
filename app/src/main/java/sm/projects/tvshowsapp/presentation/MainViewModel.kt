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

    fun getRecyclerListObserver() : MutableLiveData<TvShowList> {
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
            val response = retroInstance.getTvShowsFromApi()
            recyclerListLiveData.postValue(response)
        }
    }



//    private val repository = TvShowListRepositoryImpl
//    private val getTvShowListUseCase = GetTvShowListUseCase(repository)
//
//    val shopList = getTvShowListUseCase.getTvShowList()
//
//
////    private val repository = ShopListRepositoryImpl
////
////    private val getShopListUseCase = GetShopListUseCase(repository)
////    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
////    private val editShopItemUseCase = EditShopItemUseCase(repository)
////
////    val shopList = getShopListUseCase.getShopList()
////
////    fun deleteShopItem(shopItem: ShopItem) {
////        deleteShopItemUseCase.deleteShopItem(shopItem)
////    }
////
////    fun changeEnableState(shopItem: ShopItem) {
////        val newItem = shopItem.copy(enabled = !shopItem.enabled)
////        editShopItemUseCase.editShopItem(newItem)
////    }
//
////    val retService: TvShowService = RetrofitInstance
////        .getRetrofitInstance()
////        .create(TvShowService::class.java)
////
////    val responseLiveData: LiveData<Response<TvShowList>> = liveData {
////        val response: Response<TvShowList> = retService.getTvShows()
////        emit(response)
////    }
////
////    fun getTvShowList(){
////        responseLiveData.observe(AppCompatActivity(), Observer {
////            val tvShowsList = it.body()?.listIterator()
////            if (tvShowsList != null) {
////                while (tvShowsList.hasNext()){
////                    val tvShowItem = tvShowsList.next()
//////                    Log.i("MYTAG", tvShowItem.show.toString())
////                }
////            }
////        })
    }

