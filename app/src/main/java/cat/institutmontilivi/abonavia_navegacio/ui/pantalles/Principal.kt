package cat.institutmontilivi.abonavia_navegacio.ui.pantalles

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(onNavegaAMoneda: ()->Unit,
                      onNavegaANumAleatori: (Int, Int) -> Unit,
                      onNavegaAOracle: ()->Unit,)
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
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla principal"
                        )
                    }
                }
            )
        }
    ){
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp)

        ){
            var inici by remember { mutableStateOf(0) }
            var final by remember { mutableStateOf(10) }
            Button(onClick = {
                onNavegaAMoneda()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Cara o Creu",
                    style = MaterialTheme.typography.headlineLarge)
            }
            Row(

                modifier = Modifier.fillMaxWidth()
                    .padding(top = 20.dp)
            ){
                BasicTextField(
                    value = inici.toString(),
                    onValueChange = {
                        inici = it.toInt()
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1F).padding(5.dp)
                )
                        Log.d("Inici", "inicivalor: $inici")
                BasicTextField(
                    value = final.toString(),
                    onValueChange = {
                        final = it.toInt()
                        Log.d("Final", "finalvalor: $final")
                    },

                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1F).padding(5.dp),
                )
            }
            Button(
                onClick = {
                    if (final > inici+1) {
                        onNavegaANumAleatori(inici, final)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                enabled = final > inici + 1 // Enable the button conditionally
            ) {
                Text(text = "Número Aleatori", style = MaterialTheme.typography.headlineLarge)
            }
            Button(onClick = {
                onNavegaAOracle()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = "Oracle",
                    style = MaterialTheme.typography.headlineLarge)
            }
        }
    }
}

