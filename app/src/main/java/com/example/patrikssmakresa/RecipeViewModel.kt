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
                notes = """
Långkokt högrev i en mustig rödvinssås med sidfläsk, svamp, morötter och lök, serverad med potatispuré toppad med rostad panko, citronzest och persilja.

Ingredienser (4 port):
• 800 g högrev, skuren i bitar
• 150 g sidfläsk, tärnat
• 250 g svamp
• 10–12 st syltlökar
• 2 st gula lökar, hackade
• 2 st morötter, skivade
• 2 st vitlöksklyftor, finhackade
• 1 flaska fylligt rött vin
• 4 dl köttbuljong
• 1 msk tomatpuré
• 1 tsk torkad timjan och 1 lagerblad
• Smör/olja till stekning, salt och peppar
• 1 dl panko
• Finrivet skal från 1 ekologisk citron
• 1 dl finhackad färsk persilja
• Flingsalt

Gör så här:
1. Stek panko gyllene och krispig. Blanda med citronzest, persilja och flingsalt.
2. Stek sidfläsket knaprigt i en gjutjärnsgryta. Ta upp.
3. Stek svamp och syltlök snabbt. Ta upp och spara.
4. Bryn lök, morot och vitlök. Bryn köttet separat och lägg i grytan.
5. Tillsätt tomatpuré, vin, buljong, timjan, lagerblad och sidfläsk.
6. Låt sjuda under lock i 2–3 timmar tills köttet är mört.
7. Lägg i svamp och syltlök de sista 15 minuterna.
8. Smaka av med salt och peppar. Servera med potatispuré och toppa med panko.

""".trimIndent(),
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

    fun setRating(id: String, rating: Int) {
        _recipes.update { currentList ->
            currentList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(rating = rating.coerceIn(0, 5))
                } else {
                    recipe
                }
            }
        }
    }

    fun editRecipe(
        id: String,
        newTitle: String,
        newCategory: String,
        newNotes: String,
        newRating: Int
    ) {
        _recipes.update { currentList ->
            currentList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(
                        title = newTitle,
                        category = newCategory,
                        notes = newNotes,
                        rating = newRating.coerceIn(0, 5)
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



