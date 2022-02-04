package sm.projects.tvshowsapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import retrofit2.Response
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.RetrofitInstance
import sm.projects.tvshowsapp.data.network.network_entities.TvShow
import sm.projects.tvshowsapp.data.network.TvShowService

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val retService: TvShowService = RetrofitInstance
            .getRetrofitInstance()
            .create(TvShowService::class.java)

        val responseLiveData: LiveData<Response<TvShow>> = liveData {
            val response: Response<TvShow> = retService.getTvShows()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val tvShowsList = it.body()?.listIterator()
            if (tvShowsList != null) {
                while (tvShowsList.hasNext()){
                    val tvShowItem = tvShowsList.next()
                    Log.i("MYTAG", tvShowItem.show.toString())
                }
            }
        })
    }
}