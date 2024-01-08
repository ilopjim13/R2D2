fun main() {
    do {
        println("<ENTER> para terminar")
        print("Introduce las posiciones que se va a mover: ")
        var posiciones = readln()
    } while (posiciones != "")
    var posicion: List<Int> = mover(10, 5, -2)
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
    posicion = mover(0, 0, 0)
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
    posicion = mover()
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
    posicion = mover(-10, -5, 2)
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
    posicion = mover(-10, -5, 2, 4, -8)
    println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
}

/**
 *
 * @param lista List<Int> Lista de movimientos que debe realizar el robot.
 * @return List<Int>
 */
fun mover(vararg movimientos: Int): List<Int> {
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
    return listOf(posx, posy, direccion)
}

fun orientacionRobot(direccion: Any) = when (direccion) {
        0 -> "POSITIVEY"
        1 -> "NEGATIVEX"
        2 -> "NEGATIVEY"
        3 -> "POSITIVEX"
         else -> ""
    }
