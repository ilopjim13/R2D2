
class Robot(private val nombre:String) {
    private var posX: Int = 0
    private var posY: Int = 0
    private var dir: Int = 0

    /**
     * Realiza los movimientos del robot en la dirección en la que está
     * @param movs IntArray Lista de movimientos que debe realizar el robot.
     */
    fun mover(movs: IntArray){
        for (i in movs) {
            when (this.dir) {
                0 -> this.posY += i
                1 -> this.posX -= i
                2 -> this.posY -= i
                3 -> this.posX += i
            }
            if (this.dir == 3) this.dir = 0 else this.dir++
        }

    }

    /**
     * Imprime por pantalla la posición del robot después de los movimientos (x, y) dirección
     */
    fun mostrarPosicion()  {
        println("${this.nombre} está en (${this.posX}, ${this.posY}) ${obtenerDireccion()}")
    }

    /**
     * Retorna la dirección del robot positivo o negativo en el eje X o Y.
     * @return String la direccion del robot
     */
    fun obtenerDireccion() = when (this.dir) {
            0 -> "PositiveY"
            1 -> "NegativeX"
            2 -> "NegativeY"
            3 -> "PositiveX"
            else -> ""
        }
}

enum class direccion(desc:String) {
    ARRIBA("PositiveY"), ABAJO("NegativeX"), IZQUIERDA("NegativeY"), DERECHA("PositiveX")
}


fun main() {
    val movimientos = arrayOf(
        intArrayOf(1, -5, 0, -9),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(),
        intArrayOf(3, 5)
    )

    val r2d2 = Robot("R2D2")

    movimientos.forEach {
        r2d2.mover(it)
        r2d2.mostrarPosicion()
    }

}