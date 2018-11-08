package IntroToKotlin.KotlinPart

import java.io.File

// PUEDE HABER FUNCIONES FUERA DE CLASES
fun readLocationInfo() : Map<Int, Location> {
    val locations = mutableMapOf<Int, Location>()

    File("locations_big_kotlin.txt").reader().forEachLine {
        val tokens = it.split("`")

        val location = Location(tokens[0].toInt(), tokens[1])
        locations[location.locationId] = location
    }

    File("directions_big_kotlin.txt").reader().forEachLine {
        val tokens = it.split("`")

        // ? ES UNA FORMA DE PROTECCION CONTRA NULLS
        locations[tokens[0].toInt()]?.addExit(tokens[1], tokens[2].toInt())
    }

    return locations
}