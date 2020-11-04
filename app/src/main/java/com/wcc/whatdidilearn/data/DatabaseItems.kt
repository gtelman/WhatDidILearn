package com.wcc.whatdidilearn.data

import android.content.Context
import androidx.room.*
import com.wcc.whatdidilearn.entities.ItemLearned
import com.wcc.whatdidilearn.entities.UnderstandingLevel

@Database(entities = [ItemLearned::class], version = 1, exportSchema = false )
@TypeConverters(Converters::class)

abstract class DatabaseItems: RoomDatabase() {
    abstract fun learnedItemDao(): ItemLearnedDao

    companion object {
        // Singleton para evitar que multiplas instancias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        private var INSTANCE: DatabaseItems? = null

        fun getDatabase(context: Context): DatabaseItems {
            // se INSTANCE não é nulo, então retorna ela mesma,
            // se INSTANCE é nula, então cria uma instancia do banco
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseItems::class.java,
                    "learned_item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

        fun getAll(): List<ItemLearned> {

            val itemOne = ItemLearned(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código",
                UnderstandingLevel.HIGH
            )

            val itemTwo = ItemLearned(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
                UnderstandingLevel.MEDIUM
            )

            val itemThree = ItemLearned(
                "Git",
                "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
                UnderstandingLevel.HIGH
            )

            val itemFour = ItemLearned(
                "GroupView",
                "É uma com.example.whatdidilearn.view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
                UnderstandingLevel.LOW
            )

            val itemFive = ItemLearned(
                "View Binding",
                "View Binding é um recurso que facilita a programação de códigos que interagem com views.",
                UnderstandingLevel.LOW
            )

            return listOf(itemOne, itemTwo, itemThree, itemFour, itemFive)
        }
    }
}