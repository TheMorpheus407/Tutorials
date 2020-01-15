class Outside(a: Int) {
    private val foo: Int = a
    class Nested {
        fun bar() = 1337
    }
    inner class Inner {
        fun bar() = foo
    }
}

fun main() {
    val out = Outside(42)
    val out2 = Outside(43)
    println(Outside.Nested().bar())
    println(out.Inner().bar())
    println(out2.Inner().bar())
}