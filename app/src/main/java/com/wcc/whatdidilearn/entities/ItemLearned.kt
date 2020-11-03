package com.wcc.whatdidilearn.entities

import androidx.room.Entity

@Entity(tableName= "learned_Item")
data class ItemLearned(
    @ColumnInfo(name = "item_title")
    val title: String,

    @ColumnInfo(name = "item_description")
    val description: String,

    @ColumnInfo(name = "item_understanding_level")
    val understandingLevel: UnderstandingLevel,

    @PrimaryKey(autogenerate = true)
    @ColumnInfo(name = "item_id")
    val id:Int = 0,
)