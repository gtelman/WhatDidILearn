package com.wcc.whatdidilearn.data
import androidx.room.TypeConverter
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.entities.UnderstandingLevel
import java.util.logging.Level

class Converters {
    @TypeConverter
    fun levelToInt(understandingLevel: UnderstandingLevel): Int{
        return understandingLevel.color
    }

    @TypeConverter
    fun intToLevel(color: Int): UnderstandingLevel {
        return when(color){
            R.color.purple_200 -> UnderstandingLevel.LOW
            R.color.purple_500 -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}