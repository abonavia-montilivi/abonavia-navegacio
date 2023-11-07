package cat.institutmontilivi.abonavia_navegacio.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPregunta(onRespostaClick: (String)->Unit, onPopUpClick: () ->Unit)
{
    Scaffold (
        topBar =
        {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { "Menú principal" },
                navigationIcon = {
                    IconButton(onClick = { onPopUpClick }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla principal"
                        )
                    }
                }
            )
        }
    ){
        Pregunta(it, onRespostaClick)
    }
}



//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pregunta(paddingValues: PaddingValues, onRespostaClick: (String)->Unit){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            //.padding(paddingValues)
            .background(
                (MaterialTheme.colorScheme.inverseSurface)
            )

    ) {
        var pregunta  by remember { mutableStateOf("Escriu aquí la teva pregunta") }
//        Text(text = pregunta,
//            textAlign = TextAlign.Center,
//            style = MaterialTheme.typography.headlineLarge,
//            color = MaterialTheme.colorScheme.onSecondary,
//            modifier = Modifier.fillMaxWidth())
        TextField(value = pregunta, onValueChange = {nouText -> pregunta=nouText},
            modifier = Modifier.fillMaxWidth().padding(20.dp))

        Button(

            onClick = {

                onRespostaClick(pregunta) },
            enabled = pregunta!="",
            modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp)) {
            Text(text = "Pregunta")
        }
    }
}
