package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.entities.TvShowList
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowListViewModel


class TvShowListFragment : Fragment() {

    private lateinit var tvShowListAdapter: TvShowQueryListAdapter
    private lateinit var viewModel: TvShowListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tv_show_list, container, false)
        viewModel = ViewModelProvider(this)[TvShowListViewModel::class.java]

        setupRecyclerView(view)

        setHasOptionsMenu(true)

        return view
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_tvShowListFromApi)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        tvShowListAdapter = TvShowQueryListAdapter()
        recyclerView.adapter = tvShowListAdapter
    }

    private fun getTvShowDataFromMainViewHolder(query: String) {
        viewModel.getRecyclerListObserver().observe(this, Observer<TvShowList> {
            if (it != null) {
                tvShowListAdapter.setUpdatedData(it)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(query)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_item, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    getTvShowDataFromMainViewHolder(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_favorite_show) {
            findNavController().navigate(R.id.action_tvShowListFragment_to_tvShowFavoriteListFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TvShowListFragment()
    }
}