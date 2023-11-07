package cat.institutmontilivi.abonavia_navegacio.ui.navegacio

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cat.institutmontilivi.abonavia_navegacio.ui.pantalles.PantallaAleatori
import cat.institutmontilivi.abonavia_navegacio.ui.pantalles.PantallaMoneda
import cat.institutmontilivi.abonavia_navegacio.ui.pantalles.PantallaPregunta
import cat.institutmontilivi.abonavia_navegacio.ui.pantalles.PantallaPrincipal
import cat.institutmontilivi.abonavia_navegacio.ui.pantalles.Resposta

@Preview
@Composable
fun navegacio(){
    val controladorDeNavegacio = rememberNavController()
    NavHost(navController = controladorDeNavegacio, startDestination = ElementDeNavegacio.Principal.rutaBase){
        composable(ElementDeNavegacio.Principal.rutaSencera){
            PantallaPrincipal(
                onNavegaAMoneda = {controladorDeNavegacio.navigate(ElementDeNavegacio.Moneda.rutaSencera)},
                //onNavegaANumAleatori = {controladorDeNavegacio.navigate(ElementDeNavegacio.NumAleatori.rutaSencera)},
                onNavegaANumAleatori = {inici, final ->
                Log.d("PantallaPrincipal", "Navigating to NumAleatori with inici=$inici, final=$final")
                    controladorDeNavegacio.navigate(ElementDeNavegacio.NumAleatori.creaRutaDeNavegacio(inici, final))
                                       },
                onNavegaAOracle = {controladorDeNavegacio.navigate(ElementDeNavegacio.Pregunta.rutaSencera)}
            )
        }
        composable(ElementDeNavegacio.Moneda.rutaSencera){
            PantallaMoneda (
                onPopUpClick = {controladorDeNavegacio.navigateUp()}
            )

        }
        composable(ElementDeNavegacio.NumAleatori.rutaSencera
            ,
            arguments = listOf(
                navArgument(ArgumentDeNavegacio.Inici.clau){type=ArgumentDeNavegacio.Inici.tipus},
                navArgument(ArgumentDeNavegacio.Final.clau){type=ArgumentDeNavegacio.Final.tipus})
            ){
            val inici = it.arguments?.getInt(ElementDeNavegacio.NumAleatori.argumentsDeNavegacio[0].clau)
            requireNotNull(inici, {"El text no pot ser null"})
            val final = it.arguments?.getInt(ElementDeNavegacio.NumAleatori.argumentsDeNavegacio[1].clau)
            requireNotNull(final, {"El text no pot ser null"})
            Log.d("NumAleatori", "Received inici=$inici, final=$final")
            PantallaAleatori(onPopUpClick = {controladorDeNavegacio.navigateUp()},numInici = inici, numFinal = final)//text!! = Cotlin te aseguro que text no es null

        }
        composable(ElementDeNavegacio.Pregunta.rutaSencera){
            PantallaPregunta(
                onRespostaClick = {
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Resposta.creaRutaDeNavegacio(it))
                    {
                        popUpTo(ElementDeNavegacio.Principal.rutaSencera)
                    }
                },
                onPopUpClick = {controladorDeNavegacio.navigateUp()}
            )
        }
        composable(ElementDeNavegacio.Resposta.rutaSencera,
            //route=ElementDeNavegacio.Contingut.rutaBase+"/{"+ElementDeNavegacio.Contingut.argumentsDeNavegacio[0].clau+"}",
            arguments = listOf(
                navArgument(ArgumentDeNavegacio.Text.clau) {type= ArgumentDeNavegacio.Text.tipus}
                //navArgument("text"){type = NavType.StringType} original
            )
        ){//una vegada navegat recuperar el element text
            val text = it.arguments?.getString(ElementDeNavegacio.Resposta.argumentsDeNavegacio[0].clau)
            requireNotNull(text, {"El text no pot ser null"})
            Resposta(pregunta = text)//text!! = Cotlin te aseguro que text no es null
        }
    }
}