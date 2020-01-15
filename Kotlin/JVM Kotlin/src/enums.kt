enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    WHITE(0xFFFFFF),
    BLACK(0x000000)
}

enum class IntOperatoren {
    PLUS{
        override fun use(a: Int, b: Int) = a + b
    },
    MINUS{
        override fun use(a: Int, b: Int) = a - b
    };
    abstract fun use(a: Int, b: Int): Int
}

fun main() {
    val color = Color.RED
    println(color)
    println(color.rgb)

    val op = IntOperatoren.MINUS
    println(op.use(42, 1337))
}