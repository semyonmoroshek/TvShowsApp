package sm.projects.tvshowsapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowObject(

    val id: Int,
    val name: String,
    val summary: String,
    val language: String
): Parcelable