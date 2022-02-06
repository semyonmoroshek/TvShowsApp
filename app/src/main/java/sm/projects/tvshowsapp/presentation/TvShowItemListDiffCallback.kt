package sm.projects.tvshowsapp.presentation

import androidx.recyclerview.widget.DiffUtil
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class ShopItemDiffCallback: DiffUtil.ItemCallback<TvShowItem>() {

    override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
        return oldItem.show.id == newItem.show.id
    }

    override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
        return oldItem == newItem
    }
}
