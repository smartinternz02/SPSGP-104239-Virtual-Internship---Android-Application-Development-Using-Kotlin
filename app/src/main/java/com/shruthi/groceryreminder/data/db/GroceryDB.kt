package com.shruthi.groceryreminder.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shruthi.groceryreminder.model.GroceryModel
import com.shruthi.groceryreminder.util.Constants

@Database(
    entities = [GroceryModel::class],
    version = 1,
    exportSchema = false
)
abstract class GroceryDB: RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    companion object{
        @Volatile
        private var INSTANCE: GroceryDB? = null

        fun getDatabase(context: Context): GroceryDB{
            val temInstance = INSTANCE
            if (temInstance!=null) {
                return temInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GroceryDB::class.java,
                    Constants.GROCERY_NAME
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}