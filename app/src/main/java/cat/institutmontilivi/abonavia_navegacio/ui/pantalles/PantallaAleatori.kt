package cat.institutmontilivi.abonavia_navegacio.ui.pantalles

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAleatori(onPopUpClick: () -> Unit, numInici: Int, numFinal:Int)
{
    Scaffold (
        topBar =
        {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { "Número aleatori" },
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
        Numero(it, inici = numInici, final = numFinal)
    }
}




@Composable
fun Numero( paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.displayLarge,
    backColor: Color = MaterialTheme.colorScheme.tertiary,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    onClick: ()->Unit = {},
    inici:Int, final:Int
){

    Log.d("Numero", "inici: $inici, final: $final")
    var text = Random.nextInt(inici,final+1)
    Box(modifier = modifier
        .fillMaxSize()
        .border(width = 4.dp, color = textColor)
        .padding(4.dp)
        .background(backColor)
        .clickable ( onClick= onClick )
    ){
        Text(
            text=text.toString(),
            modifier = Modifier.align(Alignment.Center),
            style=textStyle,
            color = textColor
        )
    }
}