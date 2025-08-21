# Lab 4.2 - App de Recetas

## Video Explicativo:
https://www.youtube.com/watch?v=95ELE0VyRfw&feature=youtu.be 

## Descripción del Proyecto
Esta aplicación móvil desarrollada en Android con Jetpack Compose permite a los usuarios crear y gestionar una lista de recetas de manera sencilla e intuitiva.

## Funcionalidades Principales

### ✅ Agregar Recetas
- Campo de texto para el nombre de la receta
- Campo de texto para la URL de la imagen
- Botón "Agregar" para incluir la receta en la lista
- Validación automática (campos no pueden estar vacíos)

### ✅ Visualizar Recetas
- Lista dinámica que muestra todas las recetas agregadas
- Cada elemento incluye:
    - Imagen de la receta (cargada desde URL)
    - Nombre de la receta
    - Botón para eliminar

### ✅ Eliminar Recetas
- Botón "Eliminar" en cada elemento de la lista
- Eliminación inmediata de la receta seleccionada

## Interfaz de Usuario

### Componentes Utilizados
- **TopAppBar**: Barra superior con título "App de Recetas" y logo UVG
- **BottomAppBar**: Barra inferior con información del desarrollador
- **Scaffold**: Estructura principal de la aplicación
- **LazyColumn**: Lista eficiente para mostrar las recetas
- **TextField**: Campos de entrada para nombre y URL
- **AsyncImage**: Carga de imágenes desde URLs usando Coil

### Diseño
- Material Design 3 con colores del tema primario
- Layout responsivo y moderno
- Espaciado consistente entre elementos
- Imágenes de 60dp para vista previa y 40dp para el logo

## Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework de UI moderno
- **Material Design 3**: Sistema de diseño
- **Coil**: Biblioteca para carga de imágenes
- **State Management**: Uso de `remember` y `mutableStateListOf`

## Estructura del Código

### Clases y Funciones Principales
- `MainActivity`: Actividad principal de la aplicación
- `ScaffoldExample`: Composable principal con la estructura UI
- `LaLista`: Data class para representar una receta
- `agregarReceta()`: Función para añadir nuevas recetas
- `eliminarReceta()`: Función para remover recetas existentes
- `ListaDeRecetas`: Composable para renderizar la lista completa
- `RecetaItem`: Composable para cada elemento individual

## URLs de Ejemplo para Pruebas
```
Hamburguesa:
https://i.revistapym.com.co/old/2016/10/las-comidas-rapidas-1.png?w=1200

Burrito:
https://oem.com.mx/elsoldezamora/img/14002218/1726669911/BASE_LANDSCAPE/480/image.webp

Shawarma:
https://i.guim.co.uk/img/media/698fd183dc12485059346ec795d4b1325d5b25bc/275_1424_2872_2872/master/2872.jpg?width=465&dpr=1&s=none&crop=none
```

## Cómo Ejecutar la Aplicación

### Prerrequisitos
- Android Studio con soporte para Jetpack Compose
- SDK de Android (nivel mínimo recomendado: API 21)
- Conexión a Internet para cargar imágenes

### Pasos para Ejecutar
1. Clonar o descargar el proyecto
2. Abrir el proyecto en Android Studio
3. Sincronizar las dependencias de Gradle
4. Ejecutar en emulador o dispositivo físico
5. ¡Comenzar a agregar tus recetas favoritas!

## Desarrollador
**José Rivera - Carnet: 24376**

---
*Proyecto desarrollado como parte del Lab 4.2 - Programación de Plataformas Móviles*
