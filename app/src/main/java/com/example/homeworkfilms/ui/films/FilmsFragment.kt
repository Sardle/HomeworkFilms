package com.example.homeworkfilms.ui.films

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private val viewModel by viewModels<FilmsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.rvFilmList)
        val progressBar =  view.findViewById<ProgressBar>(R.id.progress)
        val button = view.findViewById<Button>(R.id.button)

        viewModel.apply {
            loadingLiveData.observe(viewLifecycleOwner) {
                if (it) {
                    recycler.visibility = INVISIBLE
                    button.visibility = INVISIBLE
                    progressBar.visibility = VISIBLE
                } else {
                    progressBar.visibility = GONE
                    recycler.visibility = VISIBLE
                    button.visibility = VISIBLE
                }
            }

            errorLiveData.observe(viewLifecycleOwner) { res ->
                Toast.makeText(requireContext(), getString(res), Toast.LENGTH_SHORT).show()
            }

            getFilms()
            liveData.observe(viewLifecycleOwner) {
                val itemClick: (String, String, Int) -> Unit = { name, description, id ->
                    val action = FilmsFragmentDirections.actionFilmsFragmentToDescriptionFragment(name, description, id)
                    findNavController().navigate(action)
                }
                val adapter = FilmAdapter(it, itemClick)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(this@FilmsFragment.context, LinearLayoutManager.VERTICAL, false)
            }
        }

            button.setOnClickListener {
            val action = FilmsFragmentDirections.actionFilmsFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }
    }
}