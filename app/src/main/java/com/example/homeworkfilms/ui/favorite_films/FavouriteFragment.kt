package com.example.homeworkfilms.ui.favorite_films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.R
import com.example.homeworkfilms.databinding.FragmentFavoriteBinding
import com.example.homeworkfilms.databinding.FragmentFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FavouriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = binding.recycler
        val text = binding.noMovies
        val progressBar = binding.progressFav

        val itemClick: (String, String, Int) -> Unit = { name, description, id ->
            val action =
                FavouriteFragmentDirections.actionFavoriteFragmentToDescriptionFragment(
                    name,
                    description,
                    id
                )
            findNavController().navigate(action)
        }
        val adapter = FavouriteFilmAdapter(itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(
            this@FavouriteFragment.context,
            LinearLayoutManager.VERTICAL,
            false
        )

        viewModel.apply {
            loadingLiveData.observe(viewLifecycleOwner) {
                if (it) {
                    recycler.visibility = View.INVISIBLE
                    progressBar.visibility = View.VISIBLE
                } else {
                    progressBar.visibility = View.GONE
                    recycler.visibility = View.VISIBLE
                }
            }
            getFavouriteFilm()
            favouriteLiveData.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    text.visibility = View.VISIBLE
                }
                adapter.setItems(it)
            }
        }
    }
}