package cat.institutmontilivi.abonavia_navegacio.ui.navegacio

import androidx.navigation.NavType

sealed class ElementDeNavegacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List<ArgumentDeNavegacio> = emptyList(),
    val rutaSencera: String = run{ //un run devuelve la última lina que calcula,
        // rutaBase/{arg1}/{arg2}/.../{argN}
        val clausArguments = argumentsDeNavegacio.map {
            "{${it.clau}}"
        }
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString(separator = "/")
    }
){
    object Principal: ElementDeNavegacio("principal")
    object Moneda: ElementDeNavegacio("moneda")
    object NumAleatori: ElementDeNavegacio("numAleatori",
        listOf(ArgumentDeNavegacio.Inici,ArgumentDeNavegacio.Final)
    ){
        fun creaRutaDeNavegacio (inici: Int, final:Int) = rutaBase+"/${inici.toString()}/${final.toString()}"
    }
    object Pregunta: ElementDeNavegacio("pregunta")
    object Resposta: ElementDeNavegacio("resposta", listOf(ArgumentDeNavegacio.Text)){
        fun creaRutaDeNavegacio (element: String) = rutaBase+"/${element}"
    }

}


enum class ArgumentDeNavegacio(
    val clau: String,
    val tipus: NavType<*>
){
    Text (clau = "pregunta", tipus = NavType.StringType),
    Inici (clau = "inici", tipus = NavType.IntType),
    Final (clau = "final", tipus = NavType.IntType)
}