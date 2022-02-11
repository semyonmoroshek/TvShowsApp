package sm.projects.tvshowsapp.presentation

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import sm.projects.tvshowsapp.R

class BindingAdapters {

    companion object {

        @BindingAdapter("android:navigateToTvShowDescriptionFragment")
        @JvmStatic
        fun navigateToTvShowDescriptionFragment(view: View, navigate: Boolean) {
            view.setOnClickListener {
                if (navigate) {
                    view.findNavController().navigate(R.id.action_tvShowListFragment_to_tvShowDescriptionFragment)
                }
            }
        }

        @BindingAdapter("android:emptyDatabase")
        @JvmStatic
        fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>){
            when(emptyDatabase.value) {
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE
            }
        }
    }
}