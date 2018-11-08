package IntroToKotlin.KotlinPart

// NO SEMICOLONS!!
fun main(args: Array<String>) {
    // VAL -> CONSTANTES
    // VAR -> VARIABLES
    val locations = readLocationInfo()
    var loc = 64

    while (true) {
        // ?: IF THIS IS NULL THEN ASSIGN X
        val location = locations[loc] ?: Location(0, "Sorry, something went wrong, Terminating the game")

        println(location.description)

        if (location.locationId == 0) {
            break
        }

        print("Available exits are ")
        // FOE EACH DE UN MAP
        location.exits.keys.forEach {
            // TIENE TEMPLATES COMO JS!!!
            print("$it, ")
        }

        // PROTEGEMOS CONTRA NULL con ?.
        // SI NULL ES Z ?:
        val direction = readLine()?.toUpperCase() ?: "Z"
        if (location.exits.containsKey(direction))
            // !! ABSOLUTELY SURE THIS IS NOT NULL
            loc = location.exits[direction]!!
        else
            println("You can't go in that direction")
    }
}