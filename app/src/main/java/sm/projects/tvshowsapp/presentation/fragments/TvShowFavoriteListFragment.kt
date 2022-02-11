package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.presentation.FavoriteTvShowListAdapter
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowFavoriteListViewModel


class TvShowFavoriteListFragment : Fragment() {
    private lateinit var viewModel: TvShowFavoriteListViewModel
    private lateinit var tvShowFavoriteAdapter: FavoriteTvShowListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tv_show_favorite_list, container, false)
        viewModel = ViewModelProvider(this)[TvShowFavoriteListViewModel::class.java]
        viewModel.tvShowList.observe(this) {

        }

        getFavoriteTvShowList()
        setupRecyclerView(view)
        return view
    }

    private fun getFavoriteTvShowList() {

       val list = viewModel.tvShowList

        Log.i("listfavor", list.toString())

//        viewModel.tvShowList.observe(viewLifecycleOwner, {data->
//            tvShowFavoriteAdapter.
//        })
//        viewModel.getAllData.observe(viewLifecycleOwner, {data ->
//            viewModel.checkIfDatabaseEmpty(data)
//            adapter.setData(data)
//        })
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_favoriteTvShowList)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

//        tvShowListAdapter = TvShowQueryListAdapter()
//        recyclerView.adapter = tvShowListAdapter
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            TvShowFavoriteListFragment().apply {
            }
    }
}