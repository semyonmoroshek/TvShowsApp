package sm.projects.tvshowsapp.domain

data class TvShowObject(

    val id: Int,
    val name: String,
    val summary: String,
    val language: String
) {
    companion object {

        const val UNDEFINED_ID = 0
    }
}