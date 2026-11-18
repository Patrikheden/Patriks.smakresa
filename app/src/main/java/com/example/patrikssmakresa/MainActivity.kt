package com.example.patrikssmakresa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patrikssmakresa.ui.theme.PatrikssmakresaTheme
import java.util.UUID
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState

data class RecipeItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val category: String,
    val isCooked: Boolean = false
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PatrikssmakresaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                            topBar = {
                        TopAppBar(title = { Text("Patriks Smakresa") })
                    }
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: RecipeViewModel = viewModel()) {
    var titleInput by remember { mutableStateOf("") }
    val categories = listOf("Pizza", "Varmrätt", "Vin", "Övrigt")
    var selectedCategory by remember { mutableStateOf("Pizza") }
    val recipes by viewModel.recipes.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titleInput,
            onValueChange = { titleInput = it },
            label = { Text("Rätt eller vintips...") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = { Text(category) }
                )
            }
        }
        Button(
            onClick = {
                if (titleInput.isNotBlank()) {
                    viewModel.addRecipe(titleInput, selectedCategory)
                    titleInput = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lägg till på smakresan")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val cookedCount = recipes.count { it.isCooked }
        Text(text = "Avklarade: $cookedCount av ${recipes.size}")

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recipes) { recipe ->
                Text(text = "${recipe.title} (${recipe.category})")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PatrikssmakresaTheme {
        Greeting("Android")
    }
}