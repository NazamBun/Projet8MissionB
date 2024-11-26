package com.openclassrooms.p8vitesse.presentation.ui.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.openclassrooms.arista.R
import com.openclassrooms.arista.databinding.FragmentHomeScreenBinding
import com.openclassrooms.p8vitesse.presentation.adapter.CandidateAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {
    private val viewModel: HomeScreenViewModel by viewModels()

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialiser le ViewBinding
        _binding = FragmentHomeScreenBinding.bind(view)

        // Initialiser la RecyclerView
        val adapter = CandidateAdapter(emptyList()) { candidate ->
            // TODO: Ajouter la logique pour cliquer sur un candidat (par exemple, naviguer vers l'écran de détail)
        }

        binding.candidateList.layoutManager = LinearLayoutManager(requireContext())
        binding.candidateList.adapter = adapter

        // Observer les données des candidats à partir du ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.candidates.collect { candidates ->
                adapter.updateCandidates(candidates)
            }
        }

        // Gérer le clic sur le bouton flottant pour ajouter un nouveau candidat
        binding.fabAddCandidate.setOnClickListener {
            // TODO: Ajouter la logique pour naviguer vers l'écran d'ajout d'un candidat
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}