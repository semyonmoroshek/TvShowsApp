package sm.projects.tvshowsapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import sm.projects.tvshowsapp.databinding.FragmentTvShowDescriptionBinding
import sm.projects.tvshowsapp.domain.TvShowObject
import sm.projects.tvshowsapp.presentation.viewmodels.TvShowDescriptionViewModel

class TvShowDescriptionFragment : Fragment() {

    private val args by navArgs<TvShowDescriptionFragmentArgs>()
    private var _binding: FragmentTvShowDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TvShowDescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowDescriptionBinding.inflate(inflater, container, false)

        setFields()

        viewModel = ViewModelProvider(this)[TvShowDescriptionViewModel::class.java]

        binding.imgAddToFavorite.setOnClickListener {
            addTvShowToFavoriteList()
            Toast.makeText(context, "Successfully added to favorites!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun setFields() {
        binding.txtName.text = args.currentTvShowObject.name
        binding.txtSummary.text = args.currentTvShowObject.summary
        binding.txtLanguage.text = args.currentTvShowObject.language
    }

    private fun addTvShowToFavoriteList() {
        val id = args.currentTvShowObject.id
        val name = args.currentTvShowObject.name
        val summary = args.currentTvShowObject.summary
        val language = args.currentTvShowObject.language
        val tvShowObject = TvShowObject(id, name, summary, language)
        viewModel.addTvShowObject(tvShowObject)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TvShowDescriptionFragment()
    }
}