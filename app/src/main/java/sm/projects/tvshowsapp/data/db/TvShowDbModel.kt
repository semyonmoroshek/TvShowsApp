package sm.projects.tvshowsapp.data.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "show_table")
data class TvShowDbModel(

    @PrimaryKey
    val id: Int,
    val name: String,
    val summary: String,
    val language: String

    ): Parcelable