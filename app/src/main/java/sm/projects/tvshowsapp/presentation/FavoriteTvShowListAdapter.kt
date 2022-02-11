package sm.projects.tvshowsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.data.network.entities.TvShowItem
import sm.projects.tvshowsapp.domain.TvShowObject
import sm.projects.tvshowsapp.presentation.fragments.TvShowFavoriteListFragmentDirections

class FavoriteTvShowListAdapter() :
    RecyclerView.Adapter<FavoriteTvShowListAdapter.FavoriteTvShowListViewHolder>(){

     var favoriteTvShowList = emptyList<TvShowObject>()

    fun setUpdatedData(items: List<TvShowObject>) {
        this.favoriteTvShowList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvShowListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.favorite_tvshow_raw, parent, false)
        return FavoriteTvShowListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowListViewHolder, position: Int) {
        holder.bind(favoriteTvShowList[position])

        val name = favoriteTvShowList[position].name
        val tvShow = favoriteTvShowList[position]

        holder.name.text = name

        val action = TvShowFavoriteListFragmentDirections.actionTvShowFavoriteListFragmentToTvShowDescriptionFragment(tvShow)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(action)
        }
    }
    override fun getItemCount(): Int {
        return favoriteTvShowList.size
    }


    class FavoriteTvShowListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.txt_rawFavoriteShowName)

        fun bind(tvShowObject: TvShowObject) {
            name.text = tvShowObject.name
        }
    }




}