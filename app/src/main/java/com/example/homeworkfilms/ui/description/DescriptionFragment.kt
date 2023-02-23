package com.example.homeworkfilms.ui.description

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.homeworkfilms.R
import com.example.homeworkfilms.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private val args: DescriptionFragmentArgs by navArgs()
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DescriptionViewModel by viewModels()
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleFr.text = args.name
        binding.desc.text = args.description

        button = binding.btn
        val check = viewModel.checkFilm(args.id)
        updateButton(check, view)

        button.setOnClickListener {
            val newCheck = !check
            viewModel.apply {
                if (newCheck) {
                    addFavouriteFilm(args.id)
                } else {
                    removeFilm(args.id)
                }
            }
            updateButton(newCheck, view)
        }
    }

    private fun updateButton(check: Boolean, view: View) {
        if (check) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                button.setBackgroundColor(view.context.getColor(R.color.purple_200))
            }
            button.text = resources.getText(R.string.remove_film_to_favorite)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                button.setBackgroundColor(view.context.getColor(R.color.black))
            }
            button.text = resources.getText(R.string.add_film_to_favorite)
        }
    }
}