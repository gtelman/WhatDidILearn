package com.wcc.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.data.DatabaseItems
import com.wcc.whatdidilearn.entities.ItemLearned

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.items_recycler_view)
        val adapter = LearnedItemsAdapter()

        recyclerView.adapter = adapter

        val learnedItemsList = DatabaseItems().getAll()
        adapter.data = learnedItemsList
    }
}