package sm.projects.tvshowsapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.RetrofitInstance
import sm.projects.tvshowsapp.data.network.RetroService
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList

class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: MainViewModel
//    var tvList = mutableListOf<TvShowItem>()
//    lateinit var tvShowItem: TvShowItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()

//        getTvShowData()
//        Log.i("MYDATA2", tvList.toString())
//        for (i in 0 until tvList.size) {
//            Log.i("MYDATA", tvList[i].show.name)
//        }
//
//
//    }


//    private fun getTvShowData() {


//        val tvShowRepositoryImpl: TvShowListRepositoryImpl = TvShowListRepositoryImpl
//        tvShowRepositoryImpl.getTvShowList()

//        val retService: RetroService = RetrofitInstance
//            .getRetrofitInstance()
//            .create(RetroService::class.java)
//        Log.i("MYTAG2", "data")
//
//        val responseLiveData: LiveData<Response<TvShowList>> = liveData {
//            val response: Response<TvShowList> = retService.getTvShows()
//            emit(response)
//        }
//        responseLiveData.observe(this, Observer {
//            val tvShowsList = it.body()?.listIterator()
//            if (tvShowsList != null) {
//                while (tvShowsList.hasNext()) {
//                    val tvShowItem = tvShowsList.next()
//                    Log.i("MYTAG3", tvShowItem.toString())
//                }
//            }
//        })
    }

    private fun setupFragment() {
        val fragment = TvShowListFragment.newInstance()
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, fragment)
        fragmentTransaction.commit()
    }
}