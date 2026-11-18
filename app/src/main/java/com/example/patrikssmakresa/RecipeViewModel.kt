package com.example.patrikssmakresa

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableStateFlow(
        listOf(
            RecipeItem(
                title = "Boeuf Bourguignon",
                category = "Kött",
                notes = "Långkokt högrev i en mustig rödvinssås med sidfläsk, svamp, morötter och lök, serverad potatispuré toppad med rostad panko, citronzest och persilja",
                        imageResId = R.drawable.boeuf_bourguignon
            ),
            RecipeItem(
                title = "Chicken Tikka Masala-spett",
                category = "Fågel",
                notes = "Marinera kyckling i yoghurt och kryddor över natten. Servera med krämig tomatsås och nygräddat naan.",
                imageResId = R.drawable.tikamasala
            ),
            RecipeItem(
                title = "Ramen",
                category = "Övrigt",
                notes = "En smakrik buljong, tuggiga nudlar och den mest fantastiska ”sticky mince” (karamelliserad färs) som toppning",
                imageResId = R.drawable.ramen
            ),
            RecipeItem(
                title = "Pure Altitude Chardonnay 2025",
                category = "Vin",
                notes = "En krispig, elegant och otroligt härlig chardonnay",
                imageResId = R.drawable.vinpurealtitude
            ),
            RecipeItem(
                title = "Hummerpasta",
                category = "Fisk",
                notes = "En silkeslen hummersås reducerad på skaldjursskal, morot, selleri, konjak och grädde, toppad med smörslungat hummerkött och gräslök. Ackompanjeras av rostat vitlöksbröd och ett passande vitt vin.",
                imageResId = R.drawable.hummerpasta
            )
        )
    )
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

    fun editRecipe(id: String, newTitle: String, newCategory: String, newNotes: String) {
        _recipes.update { currentList ->
            currentList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(
                        title = newTitle,
                        category = newCategory,
                        notes = newNotes
                    )
                } else {
                    recipe
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



