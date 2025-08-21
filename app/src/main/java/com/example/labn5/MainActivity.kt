package com.example.labn5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.labn5.ui.theme.Labn5Theme

data class LaLista(val nombre: String, val url: String)

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
@Composable
fun ScaffoldExample() {
    // Estado de la lista
    val itemList = remember { mutableStateListOf<LaLista>() }

    // Estados para los inputs
    var nombre by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("App de Recetas")
                        AsyncImage(
                            model = "https://altiplano.uvg.edu.gt/nosotros/img/png/Logo%20UVG-%20Colores.png",
                            contentDescription = "Logo UVG",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 11.sp,
                    text = "José Rivera 24376",
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Inputs
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("URL de la imagen") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            // Botón agregar
            FilledTonalButton(
                onClick = {
                    agregarReceta(itemList, nombre, url)
                    nombre = ""
                    url = ""
                }
            ) {
                Text("Agregar")
            }

            Spacer(Modifier.height(16.dp))

            // Mostrar lista
            ListaDeRecetas(itemList) { receta ->
                eliminarReceta(itemList, receta)
            }
        }
    }
}

/* ---------- FUNCIONES AUXILIARES ---------- */

// Agregar receta
fun agregarReceta(lista: MutableList<LaLista>, nombre: String, url: String) {
    if (nombre.isNotBlank() && url.isNotBlank()) {
        lista.add(LaLista(nombre, url))
    }
}

// Eliminar receta
fun eliminarReceta(lista: MutableList<LaLista>, receta: LaLista) {
    lista.remove(receta)
}

// Mostrar lista completa
@Composable
fun ListaDeRecetas(itemList: List<LaLista>, onEliminar: (LaLista) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(itemList) { item ->
            RecetaItem(item, onEliminar)
        }
    }
}

// Renderizar un item
@Composable
fun RecetaItem(item: LaLista, onEliminar: (LaLista) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = item.url,
            contentDescription = item.nombre,
            modifier = Modifier.size(60.dp)
        )
        Text(
            text = item.nombre,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )
        FilledTonalButton(onClick = { onEliminar(item) }) {
            Text("Eliminar")
        }
    }
}

//Hamburguesa
// https://i.revistapym.com.co/old/2016/10/las-comidas-rapidas-1.png?w=1200
//Burrito
//https://oem.com.mx/elsoldezamora/img/14002218/1726669911/BASE_LANDSCAPE/480/image.webp
//Shwarma
//https://i.guim.co.uk/img/media/698fd183dc12485059346ec795d4b1325d5b25bc/275_1424_2872_2872/master/2872.jpg?width=465&dpr=1&s=none&crop=none
