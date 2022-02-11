package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import sm.projects.tvshowsapp.data.db.TvShowDbModel
import sm.projects.tvshowsapp.databinding.FragmentTvShowDescriptionBinding
import sm.projects.tvshowsapp.domain.TvShowObject
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowDescriptionViewModel
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowFavoriteListViewModel


class TvShowDescriptionFragment : Fragment() {

    private val args by navArgs<TvShowDescriptionFragmentArgs>()
    private var _binding: FragmentTvShowDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TvShowDescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowDescriptionBinding.inflate(inflater, container, false)


        binding.txtName.text = args.currentDbShowDbModel.name
        binding.txtSummary.text = args.currentDbShowDbModel.summary
        binding.txtLanguage.text = args.currentDbShowDbModel.language

        viewModel = ViewModelProvider(this)[TvShowDescriptionViewModel::class.java]


        binding.imgAddToFavorite.setOnClickListener {
            addTvShowToFavoriteList()
            Toast.makeText(context,"Successfully added to favorites!", Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }

    private fun addTvShowToFavoriteList() {
        val id = args.currentDbShowDbModel.id
        val name = args.currentDbShowDbModel.name
        val summary = args.currentDbShowDbModel.summary
        val language = args.currentDbShowDbModel.language
        val tvShowDbObject = TvShowObject(id, name, summary, language)
            viewModel.addTvShowObject(tvShowDbObject)

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TvShowDescriptionFragment()
    }
}