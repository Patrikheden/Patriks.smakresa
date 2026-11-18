package com.example.patrikssmakresa

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow<List<RecipeItem>>(emptyList())
    val recipes: StateFlow<List<RecipeItem>> = _recipes.asStateFlow()

    fun addRecipe(title: String, category: String) {
        val trimmed = title.trim()
        if (trimmed.isEmpty()) return

        _recipes.update { currentList ->
            currentList + RecipeItem(title = trimmed, category = category)
        }
    }

    fun toggleCooked(id: String) {
        _recipes.update { currentList ->
            currentList.map { item ->
                if (item.id == id) {
                    item.copy(isCooked = !item.isCooked)
                } else {
                    item
                }
            }
        }
    }

    fun editRecipe(id: String, newTitle: String, newCategory: String) {
        val trimmed = newTitle.trim()
        if (trimmed.isEmpty()) return

        _recipes.update { currentList ->
            currentList.map { item ->
                if (item.id == id) {
                    item.copy(title = trimmed, category = newCategory)
                } else {
                    item
                }
            }
        }
    }

    fun deleteRecipe(id: String) {
        _recipes.update { currentList ->
            currentList.filterNot { it.id == id }
        }
    }
}



