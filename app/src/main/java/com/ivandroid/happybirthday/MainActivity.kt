package com.ivandroid.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivandroid.happybirthday.ui.theme.HappyBirthdayTheme

// Define la actividad principal de la aplicación
class MainActivity : ComponentActivity() {
    // Método onCreate, se llama al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita la visualización de borde a borde
        enableEdgeToEdge()

        // Establece el contenido de la actividad usando Jetpack Compose
        setContent {
            // Aplica el tema personalizado a la interfaz
            HappyBirthdayTheme {
                // Crea una superficie que ocupa el total del tamaño de la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a la función composable GreetingImage para mostrar la tarjeta de felicitación
                    GreetingImage(
                        // Obtiene los textos desde los recursos de la aplicación
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

// Función composable para mostrar el texto de felicitación
@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String, from: String) {
    // Crea una columna para organizar el texto verticalmente
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        // Muestra el mensaje de cumpleaños con estilo
        Text(
            text = message,
            fontSize = 100.sp, // Tamaño de la fuente
            lineHeight = 116.sp, // Altura de línea
            textAlign = TextAlign.Center // Alineación del texto
        )
        // Muestra el texto de la firma con estilo
        Text(
            text = from,
            fontSize = 36.sp, // Tamaño de la fuente
            modifier = Modifier
                .padding(16.dp) // Margen alrededor del texto
                .align(alignment = Alignment.CenterHorizontally) // Alineación del texto al centro
        )
    }
}

// Función composable para mostrar la imagen de felicitación
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Obtiene el recurso de imagen
    val image = painterResource(id = R.drawable.androidparty)

    // Crea un contenedor de caja para superponer la imagen y el texto
    Box(modifier) {
        // Muestra la imagen
        Image(
            painter = image,
            contentDescription = null, // No se necesita descripción para la imagen
            contentScale = ContentScale.Crop, // Escala la imagen para llenar el área
            alpha = 0.5F // Ajusta la opacidad de la imagen
        )
        // Llama a GreetingText para mostrar el texto sobre la imagen
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el tamaño disponible
                .padding(8.dp) // Margen alrededor del texto
        )
    }
}

// Función para previsualizar el diseño en el editor de Android Studio
@Preview(
    showBackground = true, // Muestra un fondo en la vista previa
    showSystemUi = false, // No muestra la UI del sistema
    name = "IvanDroid" // Nombre de la vista previa
)
@Composable
fun BirthdayCardPreview() {
    // Aplica el tema personalizado
    HappyBirthdayTheme {
        /* Esta línea de código fue comentada y reemplazada por GreetingImage
        GreetingText(
            message = "Happy Birthday Fer!",
            from = "From Iván"
        )*/

        // Llama a GreetingImage para mostrar la tarjeta de felicitación en la vista previa
        GreetingImage(
            message = stringResource(id = R.string.happy_birthday_text),
            from = stringResource(id = R.string.signature_text)
        )
    }
}
