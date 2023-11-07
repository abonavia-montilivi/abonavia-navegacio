package cat.institutmontilivi.abonavia_navegacio.ui.pantalles

import androidx.compose.foundation.Image
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.abonavia_navegacio.R
import kotlin.random.Random

//@Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaMoneda(onPopUpClick: () ->Unit) {
    Scaffold(
        topBar =
        {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { "Cara o Creu" },
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
    )
    {
        Mondeda(paddingValues = it)
    }
}

@Composable
fun Mondeda(paddingValues: PaddingValues){
    Box(){
        var random = Random.nextInt(0,2)
        if (random==0)
            Image(painter = painterResource(id = R.drawable.cara), contentDescription ="Cara",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            )
        else
            Image(painter = painterResource(id = R.drawable.creu), contentDescription ="Creu",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            )

    }
}
