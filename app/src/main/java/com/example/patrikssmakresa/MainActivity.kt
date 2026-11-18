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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Button

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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var titleInput by remember { mutableStateOf("") }
    val categories = listOf("Pizza", "Varmrätt", "Vin", "Övrigt")
    var selectedCategory by remember { mutableStateOf("Pizza") }

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titleInput,
            onValueChange = { titleInput = it },
            label = { Text("Rätt eller vintips...") },
            modifier = modifier.padding(16.dp)
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
                    titleInput = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lägg till på smakresan")
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