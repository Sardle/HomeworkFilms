package com.example.homeworkfilms.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.homeworkfilms.R

class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title_fr).text = arguments?.getString(KEY_TITLE)
        view.findViewById<TextView>(R.id.desc).text = arguments?.getString(KEY_DESC)
    }

    companion object {
        private val KEY_TITLE = "TITLE_KEY"
        private val KEY_DESC = "DESC_KEY"

        fun newInstance(title: String, desc: String): DescriptionFragment {
            val fragment = DescriptionFragment()
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_DESC, desc)
            fragment.arguments = args
            return fragment
        }
    }
}