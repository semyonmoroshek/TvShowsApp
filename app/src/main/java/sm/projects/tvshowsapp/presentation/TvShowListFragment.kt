package sm.projects.tvshowsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList


class TvShowListFragment : Fragment() {

    private lateinit var tvShowListAdapter: TvShowListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tv_show_list, container, false)

        initViewModel(view)
        initViewModel()

        return view
    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_tvShowListFromApi)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        tvShowListAdapter = TvShowListAdapter()
        recyclerView.adapter = tvShowListAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(this, Observer<TvShowList> {
            if (it != null){
                tvShowListAdapter.setUpdatedData(it)//////////////////////////////////
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TvShowListFragment()
    }
}