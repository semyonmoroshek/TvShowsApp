package sm.projects.tvshowsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class TvShowListAdapter() :
    RecyclerView.Adapter<TvShowListAdapter.TvShowViewHolder>() {

    var items = ArrayList<TvShowItem>()

    fun setUpdatedData(items: ArrayList<TvShowItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tvshow_raw, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TvShowViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.txt_tvShowItemName)

        fun bind(tvShowItem: TvShowItem) {
            name.text = tvShowItem.show.name
        }
    }
}
