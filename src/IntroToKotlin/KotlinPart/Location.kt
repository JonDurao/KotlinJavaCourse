package IntroToKotlin.KotlinPart

// DECLARAS LAS CONSTANTES O VARIABLES NECESARIAS EN LA CLASE Y SU TIPO DETRAS DE LOS :
data class Location (val locationId: Int, val description: String){
    val exits = mutableMapOf<String, Int>()

    init {
        exits["Q"] = 0
    }

    fun addExit(direction: String, destinationId: Int) {
        // ACCEDES A UN MAPA COMO UN OBJETO EN JS
        exits[direction] = destinationId
    }
}