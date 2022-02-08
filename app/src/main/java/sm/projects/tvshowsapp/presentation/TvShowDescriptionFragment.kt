package sm.projects.tvshowsapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import sm.projects.tvshowsapp.R
import sm.projects.tvshowsapp.databinding.FragmentTvShowDescriptionBinding


class TvShowDescriptionFragment : Fragment() {

    private val args by navArgs<TvShowDescriptionFragmentArgs>()
    private var _binding: FragmentTvShowDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowDescriptionBinding.inflate(inflater, container, false)

        binding.txtName.text = args.currentTvShow.name
        binding.txtGenres.text = args.currentTvShow.genres.toString()
        binding.txtSummary.text = args.currentTvShow.summary
        binding.txtLanguage.text = args.currentTvShow.language

        binding.imgAddToFavorite.setOnClickListener {
            Toast.makeText(context,"Successfully added to favorites!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TvShowDescriptionFragment()
    }
}