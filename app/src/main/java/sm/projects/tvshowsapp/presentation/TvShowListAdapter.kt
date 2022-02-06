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

    fun setUpdatedData(items: ArrayList<TvShowItem>){
        this.items = items
        notifyDataSetChanged()
    }

    var onShopItemLongClickListener: ((TvShowItem) -> Unit)? = null
    var onShopItemClickListener: ((TvShowItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tvshow_raw, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TvShowViewHolder, position: Int) {
//        val name = tvShowList[position].show.name
//        viewHolder.tvName.text = name
        viewHolder.bind(items.get(position))


    }
    override fun getItemCount(): Int {
        return items.size
    }

    class TvShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txt_tvShowItemName)

        fun bind(tvShowItem: TvShowItem){
            name.text = tvShowItem.show.name
        }


//        val tvName = view.findViewById<TextView>(R.id.txt_tvShowItemName)
    }
}
