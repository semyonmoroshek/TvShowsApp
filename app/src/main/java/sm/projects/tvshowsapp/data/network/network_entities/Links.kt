package sm.projects.tvshowsapp.data.network.network_entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Links(
    val previousepisode: Previousepisode,
    val self: Self
)