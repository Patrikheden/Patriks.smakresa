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
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.CircleShape


data class RecipeItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val category: String,
    val notes: String = "",
    val imageResId: Int? = null,
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
                    val uriHandler = LocalUriHandler.current
                        TopAppBar(
                            title = {
                                Column {
                                    Text(text = "Patriks.Smakresa")
                                    Text(
                                        text = "Mina recept & vintips",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                        uriHandler.openUri("https://www.instagram.com/patriks.smakresa/")
                                    }
                                ) {
                                    InstagramIcon()
                                        }
                                    }
                                )
                            }
                ){ innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: RecipeViewModel = viewModel()) {
    var titleInput by remember { mutableStateOf("") }
    val categories = listOf("Kött", "Fisk", "Fågel", "Vin", "Vego", "Övr" )
    var selectedCategory by remember { mutableStateOf("Kött") }
    val recipes by viewModel.recipes.collectAsState()
    var editingRecipe by remember { mutableStateOf<RecipeItem?>(null) }
    var editTitleInput by remember { mutableStateOf("") }
    var editCategoryInput by remember { mutableStateOf("Kött") }
    var editNotesInput by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = titleInput,
            onValueChange = { titleInput = it },
            label = { Text("Rätt eller vintips...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            categories.forEach { category ->
                val isSelected = selectedCategory == category
                val (bgColor, textColor) = when (category) {
                    "Kött" -> androidx.compose.ui.graphics.Color(0xFF7D8E74) to androidx.compose.ui.graphics.Color.White
                    "Vin" -> androidx.compose.ui.graphics.Color(0xFF5D1A2B) to androidx.compose.ui.graphics.Color.White
                    "Fisk" -> androidx.compose.ui.graphics.Color(0xFFD9C59A) to androidx.compose.ui.graphics.Color(0xFF3E352A)
                    "Fågel" -> androidx.compose.ui.graphics.Color(0xFF7A5C38) to androidx.compose.ui.graphics.Color.White
                    "Vego" -> androidx.compose.ui.graphics.Color(0xFFD6CFC7) to androidx.compose.ui.graphics.Color(0xFF3E352A)
                    else -> androidx.compose.ui.graphics.Color(0xFFE5DEC9) to androidx.compose.ui.graphics.Color(0xFF3E352A)
                }

                androidx.compose.material3.Surface(
                    onClick = { selectedCategory = category },
                    shape = CircleShape,
                    color = bgColor,
                    border = if (isSelected) {
                        androidx.compose.foundation.BorderStroke(2.5.dp, androidx.compose.ui.graphics.Color(0xFF2B2623))
                    } else null
                ) {
                    Text(
                        text = category,
                        color = textColor,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
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

        if (recipes.isEmpty()) {
            Text(
                text = "Listan är tom. Skriv in en rätt eller ett vintips ovan för att komma igång!",
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(recipes, key = { it.id }) { recipe ->
                    var isExpanded by remember { mutableStateOf(false) }

                    Card(
                        onClick = { if (recipe.notes.isNotBlank()) isExpanded = !isExpanded },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = recipe.isCooked,
                                onCheckedChange = { viewModel.toggleCooked(recipe.id) }
                            )

                            recipe.imageResId?.let { resId ->
                                        Image(
                                            painter = painterResource(id = resId),
                                            contentDescription = recipe.title,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(64.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = recipe.title,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                CategoryBadge(category = recipe.category)

                                if (isExpanded && recipe.notes.isNotBlank()) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(

                                        text = recipe.notes,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            if (recipe.notes.isNotBlank()) {
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = if (isExpanded) "Fäll ihop" else "Visa notering",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            IconButton(onClick = {
                                editingRecipe = recipe
                                editTitleInput = recipe.title
                                editCategoryInput = recipe.category
                                editNotesInput = recipe.notes
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Redigera"
                                )
                            }
                            IconButton(onClick = { viewModel.deleteRecipe(recipe.id) }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Ta bort"
                                )
                            }
                        }
                    }
                }
            }
        }

        editingRecipe?.let { recipeToEdit ->
            AlertDialog(
                onDismissRequest = { editingRecipe = null },
                title = { Text("Redigera rad") },
                text = {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = editTitleInput,
                            onValueChange = { editTitleInput = it },
                            label = { Text("Nytt namn") }
                        )
                        OutlinedTextField(
                            value = editNotesInput,
                            onValueChange = { editNotesInput = it },
                            label = { Text("Smaknoter / vintips") },
                            minLines = 2
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            categories.forEach { category ->
                                FilterChip(
                                    selected = editCategoryInput == category,
                                    onClick = { editCategoryInput = category },
                                    label = { Text(category) }
                                )
                            }
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            viewModel.editRecipe(recipeToEdit.id, editTitleInput, editCategoryInput, editNotesInput)
                            editingRecipe = null
                        },
                        enabled = editTitleInput.isNotBlank()
                    ) {
                        Text("Spara")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { editingRecipe = null }) {
                        Text("Avbryt")
                    }
                }
            )
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

@Composable
fun InstagramIcon() {
    val iconColor = androidx.compose.material3.LocalContentColor.current
    Canvas(modifier = Modifier.size(22.dp)) {
        val strokeWidth = size.minDimension * 0.1f
        drawRoundRect(
            color = iconColor,
            style = Stroke(width = strokeWidth),
            cornerRadius = CornerRadius(size.minDimension * 0.28f)
        )
        drawCircle(
            color = iconColor,
            radius = size.minDimension * 0.23f,
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = iconColor,
            radius = size.minDimension * 0.06f,
            center = Offset(size.width * 0.75f, size.height * 0.25f)
        )
    }
}

@Composable
fun CategoryBadge(category: String) {
    val (bgColor, textColor) = when (category) {
        "Kött" -> androidx.compose.ui.graphics.Color(0xFF7D8E74) to androidx.compose.ui.graphics.Color.White
        "Vin" -> androidx.compose.ui.graphics.Color(0xFF5D1A2B) to androidx.compose.ui.graphics.Color.White
        "Fisk" -> androidx.compose.ui.graphics.Color(0xFFD9C59A) to androidx.compose.ui.graphics.Color(0xFF3E352A)
        "Fågel" -> androidx.compose.ui.graphics.Color(0xFF7A5C38) to androidx.compose.ui.graphics.Color.White
        "Vego" -> androidx.compose.ui.graphics.Color(0xFFD6CFC7) to androidx.compose.ui.graphics.Color(0xFF3E352A)
        else -> androidx.compose.ui.graphics.Color(0xFFE5DEC9) to androidx.compose.ui.graphics.Color(0xFF3E352A)
    }
    androidx.compose.material3.Surface(
        color = bgColor,
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = category,
            color = textColor,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}