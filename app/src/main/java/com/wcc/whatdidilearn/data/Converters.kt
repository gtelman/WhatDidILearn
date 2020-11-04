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
            R.color.red -> UnderstandingLevel.LOW
            R.color.yellow -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}