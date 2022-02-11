package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import sm.projects.tvshowsapp.domain.TvShowObject
import sm.projects.tvshowsapp.presentation.FavoriteTvShowListAdapter
import sm.projects.tvshowsapp.presentation.SwipeToDelete
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowFavoriteListViewModel


class TvShowFavoriteListFragment : Fragment() {

    private lateinit var favoriteTvShowListAdapter: FavoriteTvShowListAdapter
    private lateinit var viewModel: TvShowFavoriteListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            sm.projects.tvshowsapp.R.layout.fragment_tv_show_favorite_list,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[TvShowFavoriteListViewModel::class.java]


        setupRecyclerView(view)

        setHasOptionsMenu(true)

        return view
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView =
            view.findViewById<RecyclerView>(sm.projects.tvshowsapp.R.id.recyclerView_favoriteTvShow)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        favoriteTvShowListAdapter = FavoriteTvShowListAdapter()
        recyclerView.adapter = favoriteTvShowListAdapter

        viewModel.tvShowList.observe(this, Observer<List<TvShowObject>> {
            if (it != null) {
                favoriteTvShowListAdapter.setUpdatedData(it)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.tvShowList /////

        swipeToDelete(recyclerView)

    }



    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDeleteCallback = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedItem = favoriteTvShowListAdapter.favoriteTvShowList[viewHolder.adapterPosition]
                viewModel.deleteTvShowObject(deletedItem)
                favoriteTvShowListAdapter.notifyItemRemoved(viewHolder.adapterPosition)
                restoreDeletedData(viewHolder.itemView, deletedItem, viewHolder.adapterPosition)
                view?.let { setupRecyclerView(it) }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun restoreDeletedData(view: View, deletedItem: TvShowObject, position: Int) {
        val snackBar = Snackbar.make(
            view, "Deleted '${deletedItem.name}'",
            Snackbar.LENGTH_LONG
        )
        snackBar.setAction("Undo") {
            viewModel.addTvShowObject(deletedItem)
            favoriteTvShowListAdapter.notifyItemChanged(position)
        }
        snackBar.show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TvShowListFragment()
    }
}