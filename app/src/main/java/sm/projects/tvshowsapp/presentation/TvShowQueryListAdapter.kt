package sm.projects.tvshowsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShowItem
import sm.projects.tvshowsapp.presentation.fragments.TvShowListFragmentDirections

class TvShowQueryListAdapter() :
    RecyclerView.Adapter<TvShowQueryListAdapter.TvShowViewHolder>() {

    private var tvShowListItems = ArrayList<TvShowItem>()

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
        val summary = tvShow.summary
        val language = tvShow.language

        if (language != null && summary != null && name != null) {
            val tvShowDbModel = TvShowDbModel(id, name, summary, language)
            goToDescriptionFragment(tvShowDbModel, viewHolder)
        } else if (id == null) {
            val tvShowDbModel = TvShowDbModel(id, name, summary, "language not found")
            goToDescriptionFragment(tvShowDbModel, viewHolder)
        } else if (summary == null){
            val tvShowDbModel = TvShowDbModel(id, name, "summary not found", language)
            goToDescriptionFragment(tvShowDbModel, viewHolder)
        } else if (name == null){
            val tvShowDbModel = TvShowDbModel(id, "name not found", summary, language)
            goToDescriptionFragment(tvShowDbModel, viewHolder)

        }
    }

    private fun goToDescriptionFragment(tvShowDbModel: TvShowDbModel, viewHolder: TvShowViewHolder) {
        val action =
            TvShowListFragmentDirections.actionTvShowListFragmentToTvShowDescriptionFragment(
                tvShowDbModel
            )

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
