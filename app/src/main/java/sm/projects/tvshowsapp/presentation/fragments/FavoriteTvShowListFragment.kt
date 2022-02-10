package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.databinding.FragmentTvShowDescriptionBinding

class FavoriteTvShowListFragment : Fragment() {

    private var _binding: FragmentTvShowDescriptionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowDescriptionBinding.inflate(inflater, container, false)


        return binding.root

    }

    companion object {
         @JvmStatic
            fun newInstance() =
                TvShowDescriptionFragment()
    }
}
