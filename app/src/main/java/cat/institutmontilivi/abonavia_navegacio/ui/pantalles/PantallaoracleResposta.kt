package cat.institutmontilivi.abonavia_navegacio.ui.pantalles

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.abonavia_navegacio.R
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlin.random.Random

@Preview
@Composable
fun Resposta(
    modifier: Modifier = Modifier,
    pregunta: String ="Text de la pregunta",
    //onClick () -> Unit = {}
//    resposta: String
){
    var random = Random.nextInt(0,3)
    //var pregunta="Text de la pregunta"
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            //.padding(paddingValues)
            .background((MaterialTheme.colorScheme.inverseSurface)
            )

    ) {
        Text(text = pregunta,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.fillMaxWidth().padding(top=100.dp))
        if (random==0){
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()

            Image(
                painter = rememberAsyncImagePainter(R.drawable.yes, imageLoader),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        else if (random==1){
            Image(painter = painterResource(id = R.drawable.no), contentDescription ="NO",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            )
        }
        else{
            Image(painter = painterResource(id = R.drawable.perhaps), contentDescription ="Perhaps",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            )
        }
    }
}