package sm.projects.tvshowsapp.presentation

import androidx.recyclerview.widget.DiffUtil
import sm.projects.tvshowsapp.data.db.TvShowDbModel

class TvShowDbModelDiffCallback: DiffUtil.ItemCallback<TvShowDbModel>() {

    override fun areItemsTheSame(oldItem: TvShowDbModel, newItem: TvShowDbModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TvShowDbModel, newItem: TvShowDbModel): Boolean {
        return oldItem == newItem
    }
}
