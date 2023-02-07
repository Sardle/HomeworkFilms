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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private val viewModel by viewModels<FavouriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val text = view.findViewById<TextView>(R.id.no_movies)
        val progressBar =  view.findViewById<ProgressBar>(R.id.progress_fav)

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
                val itemClick: (String, String, Int) -> Unit = { name, description, id ->
                    val action =
                        FavouriteFragmentDirections.actionFavoriteFragmentToDescriptionFragment(
                            name,
                            description,
                            id
                        )
                    findNavController().navigate(action)
                }
                val adapter = FavouriteFilmAdapter(it, itemClick)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(
                    this@FavouriteFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }
}