package com.example.labn5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labn5.ui.theme.Labn5Theme
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labn5Theme {

                ScaffoldExample()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Preview
// [START android_compose_components_scaffold]
@Composable
fun ScaffoldExample() {
    var presses by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("App de Recetas")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 11.sp,
                    text = "José Rivera 24376",
                )
            }
        },
        /*floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }*/
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                        """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.
                    
                    It also contains some basic inner content, such as this text.
                    
                    You have pressed the floating action button $presses times.
                """.trimIndent(),
                )
                Spacer(modifier = Modifier.height(30.dp))
                // [START android_compose_state_text_4]
                // ✅ TextField Material3 correcto
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Escribe algo") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = false,
                    maxLines = 4
                )
                Spacer(modifier = Modifier.height(20.dp))
                FilledTonalButton(onClick = {  }) {
                    Text("Agregar")

                }
                Spacer(modifier = Modifier.height(15.dp))

                LoadingImageFromInternetCoil()
            }
        }
    }

}
// [END android_compose_components_scaffold]



@Preview
@Composable
fun LoadingImageFromInternetCoil() {
    // [START android_compose_images_load_internet_coil]
    AsyncImage(
        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2-uw93cbkJRVx_FSFJqd5ibeS9Ts_0EHJqg&s",
        contentDescription = "Translated description of what the image contains"
    )
    // [END android_compose_images_load_internet_coil]
}