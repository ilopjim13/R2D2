fun main() {
    val posiciones = mutableListOf<Int>()
    do {
        val entrada:Int
        val seguir:String
        try {
            print("Introduce las posiciones que se va a mover: ")
            entrada = readln().toInt()
            posiciones.add(entrada)
        } catch (e: Exception) {
            println("**ERROR** número introducido inválido.")
        }
        print("¿Quieres añadir más direcciones (n para terminar)?")
        seguir = readln().lowercase()
    } while (seguir != "n")

    var posicion: List<Int> = mover(posiciones)
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
}

/**
 *
 * @param lista List<Int> Lista de movimientos que debe realizar el robot.
 * @return List<Int>
 */
fun mover( movimientos: List<Int>): List<Int> {
    var posx = 0
    var posy = 0
    var direccion = 0
    for (i in movimientos) {
        when (direccion) {
            0 -> posy += i
            1 -> posx -= i
            2 -> posy -= i
            3 -> posx += i
        }
        if (direccion > 3) direccion = 0 else direccion++
    }
    if (direccion == 4) direccion -= 1
    return listOf(posx, posy, direccion)
}

fun orientacionRobot(direccion: Any) = when (direccion) {
        0 -> "POSITIVEY"
        1 -> "NEGATIVEX"
        2 -> "NEGATIVEY"
        3 -> "POSITIVEX"
         else -> ""
    }
