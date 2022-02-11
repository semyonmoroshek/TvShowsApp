package sm.projects.tvshowsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShowItem

class FavoriteTvShowListAdapter() :
    RecyclerView.Adapter<FavoriteTvShowListAdapter.FavoriteTvShowListViewHolder>() {

    var favoriteTvShowList = emptyList<TvShowDbModel>()

    fun setUpdatedData(items: ArrayList<TvShowDbModel>) {
        this.favoriteTvShowList = items
        notifyDataSetChanged()
    }


    class FavoriteTvShowListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.txt_tvShowItemName)

        fun bind(tvShowDbModel: TvShowDbModel) {
            name.text = tvShowDbModel.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvShowListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tvshow_raw, parent, false)
        return FavoriteTvShowListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowListViewHolder, position: Int) {
        holder.bind(favoriteTvShowList[position])

        val name = favoriteTvShowList[position].name




    }

    override fun getItemCount(): Int {
        return favoriteTvShowList.size
    }


}