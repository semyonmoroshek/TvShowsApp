package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import sm.projects.tvshowsapp.data.db.AppDatabase
import sm.projects.tvshowsapp.databinding.FragmentTvShowDescriptionBinding
import sm.projects.tvshowsapp.presentation.MainViewModel
import sm.projects.tvshowsapp.presentation.TvShowItemViewModel


class TvShowDescriptionFragment : Fragment() {

    private val args by navArgs<TvShowDescriptionFragmentArgs>()
    private var _binding: FragmentTvShowDescriptionBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TvShowItemViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowDescriptionBinding.inflate(inflater, container, false)


        binding.txtName.text = args.currentDbShowDbModel.name
        binding.txtSummary.text = args.currentDbShowDbModel.summary
        binding.txtLanguage.text = args.currentDbShowDbModel.language

        viewModel = ViewModelProvider(this)[TvShowItemViewModel::class.java]


        binding.imgAddToFavorite.setOnClickListener {
            viewModel.addShow(args.currentDbShowDbModel)
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