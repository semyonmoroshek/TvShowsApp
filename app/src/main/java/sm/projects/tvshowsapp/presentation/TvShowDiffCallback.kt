package sm.projects.tvshowsapp.presentation

import androidx.recyclerview.widget.DiffUtil
import sm.projects.tvshowsapp.domain.TvShowObject

class TvShowDiffCallback: DiffUtil.ItemCallback<TvShowObject>() {
    override fun areItemsTheSame(oldItem: TvShowObject, newItem: TvShowObject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TvShowObject, newItem: TvShowObject): Boolean {
        return oldItem == newItem
    }
}