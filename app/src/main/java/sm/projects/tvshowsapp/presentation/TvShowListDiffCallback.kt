package sm.projects.tvshowsapp.presentation

import androidx.recyclerview.widget.DiffUtil
import sm.projects.tvshowsapp.data.network.network_entities.TvShowItem

class TvShowListDiffCallback(
    private val oldList: List<TvShowItem>,
    private val newList: List<TvShowItem>,
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.show.id == newItem.show.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}
