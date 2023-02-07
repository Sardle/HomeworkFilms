package com.example.homeworkfilms.ui.description

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homeworkfilms.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private val viewModel by viewModels<DescriptionViewModel>()
    private val args: DescriptionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = args.name
        val description = args.description
        val id = args.id
        view.findViewById<TextView>(R.id.title_fr).text = name
        view.findViewById<TextView>(R.id.desc).text = description
        val button = view.findViewById<Button>(R.id.btn)

        var check = viewModel.checkFilm(id)
        if (check) {
            button.setBackgroundColor(view.context.getColor(R.color.purple_200))
            button.text = resources.getText(R.string.remove_film_to_favorite)
        } else {
            button.setBackgroundColor(view.context.getColor(R.color.black))
            button.text = resources.getText(R.string.add_film_to_favorite)
        }
        button.setOnClickListener {
            if (!check) {
                viewModel.addFavouriteFilm(id)
                button.setBackgroundColor(view.context.getColor(R.color.purple_200))
                button.text = resources.getText(R.string.remove_film_to_favorite)
                check = true
            } else {
                viewModel.removeFilm(id)
                button.setBackgroundColor(view.context.getColor(R.color.black))
                button.text = resources.getText(R.string.add_film_to_favorite)
                check = false
            }
        }
    }
}