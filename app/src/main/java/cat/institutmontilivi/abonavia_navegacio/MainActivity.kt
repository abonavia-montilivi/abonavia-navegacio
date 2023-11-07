package cat.institutmontilivi.abonavia_navegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cat.institutmontilivi.abonavia_navegacio.ui.navegacio.navegacio
import cat.institutmontilivi.abonavia_navegacio.ui.theme.AbonavianavegacioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbonavianavegacioTheme {
                // A surface container using the 'background' color from the theme
                TemaApp {
                    navegacio()
                }
            }
        }
    }
}

@Composable
fun TemaApp ( content: @Composable ()->Unit)
{
    AbonavianavegacioTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
