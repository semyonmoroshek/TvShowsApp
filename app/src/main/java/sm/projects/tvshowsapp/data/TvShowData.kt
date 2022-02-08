package sm.projects.tvshowsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import sm.projects.tvshowsapp.data.network.network_entities.*

@Parcelize
data class TvShowData(
    val id: Int,
    val name: String,
    val genres: List<String>,
    val summary: String,
    val language: String
    ): Parcelable