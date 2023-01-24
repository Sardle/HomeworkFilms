package com.example.homeworkfilms.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfilms.FilmAdapter
import com.example.homeworkfilms.R
import com.example.homeworkfilms.model.models.UiItem
import com.example.homeworkfilms.presenter.FilmPresenter
import com.example.homeworkfilms.presenter.FilmPresenterImpl

class MainActivity : AppCompatActivity(), FilmsView {

    private var presenter: FilmPresenter = FilmPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getFilms()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else supportFragmentManager.popBackStack()
    }

    override fun showFilms(server: List<UiItem>) {
        val recycler = findViewById<RecyclerView>(R.id.rvFilmList)

        val itemClick: (String, String) -> Unit = { title, desc ->
            findViewById<FrameLayout>(R.id.frame).visibility = VISIBLE

            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, DescriptionFragment.newInstance(title, desc))
                .addToBackStack("DescriptionFragment")
                .commit()
        }

        val adapter = FilmAdapter(server, itemClick)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}