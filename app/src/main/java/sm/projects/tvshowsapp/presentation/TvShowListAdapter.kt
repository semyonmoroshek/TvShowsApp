package sm.projects.tvshowsapp.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.TvShowData
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class TvShowListAdapter() :
    RecyclerView.Adapter<TvShowListAdapter.TvShowViewHolder>() {

    var tvShowListItems = ArrayList<TvShowItem>()

    fun setUpdatedData(items: ArrayList<TvShowItem>) {
        this.tvShowListItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tvshow_raw, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TvShowViewHolder, position: Int) {
        viewHolder.bind(tvShowListItems[position])

        val tvShow = tvShowListItems[position].show
        val id = tvShow.id
        val name = tvShow.name
        val genres = tvShow.genres
        val summary = tvShow.summary
        val language = tvShow.language


        val tvShowData = TvShowData(id, name, genres, summary, language)

        val action = TvShowListFragmentDirections.actionTvShowListFragmentToTvShowDescriptionFragment(tvShowData)

        viewHolder.itemView.setOnClickListener {
            viewHolder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return tvShowListItems.size
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.txt_tvShowItemName)

        fun bind(tvShowItem: TvShowItem) {
            name.text = tvShowItem.show.name
        }
    }
}
