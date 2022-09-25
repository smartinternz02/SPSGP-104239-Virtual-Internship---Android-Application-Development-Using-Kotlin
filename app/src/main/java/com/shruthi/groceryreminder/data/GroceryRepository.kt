package com.shruthi.groceryreminder.data

import androidx.lifecycle.LiveData
import com.shruthi.groceryreminder.data.db.GroceryDao
import com.shruthi.groceryreminder.model.GroceryModel

class GroceryRepository(private val groceryDao: GroceryDao) {

    val readAllItems: LiveData<List<GroceryModel>> = groceryDao.readItem()

    suspend fun insert(item: GroceryModel) = groceryDao.insertItem(item)

    suspend fun delete(item: GroceryModel) = groceryDao.deleteItem(item)

    suspend fun deleteAllItems() = groceryDao.deleteAllItems()

}