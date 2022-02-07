package sm.projects.tvshowsapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem
import sm.projects.tvshowsapp.data.network.network_entities.TvShowList
import kotlin.collections.ArrayList


class TvShowListFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var tvShowListAdapter: TvShowListAdapter
    var viewModel = MainViewModel()
    private lateinit var searchTvShowList: ArrayList<TvShowItem>
    private lateinit var tempList: ArrayList<TvShowItem>
    private lateinit var heading: ArrayList<String>
    private lateinit var newRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tv_show_list, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        setupRecyclerView(view)
//        initMainViewModel()

        setupSearchView()
        setHasOptionsMenu(true)

        return view
    }

    private fun setupSearchView() {


    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_tvShowListFromApi)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        tvShowListAdapter = TvShowListAdapter()
        recyclerView.adapter = tvShowListAdapter
    }

    private fun getTvShowDataFromMainViewHolder() {
        viewModel.getRecyclerListObserver().observe(this, Observer<TvShowList> {
            if (it != null) {
                tvShowListAdapter.setUpdatedData(it)//////////////////////////////////
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {


        inflater.inflate(R.menu.menu_item, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    getTvShowDataFromMainViewHolder()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })


//        searchView?.isSubmitButtonEnabled = true


//        val searchManager = requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        (menu.findItem(R.id.menu_search).actionView as SearchView).apply {
//            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
//        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TvShowListFragment()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.i("query", "quesry")
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.i("query", "quesry")
        return true
    }


}