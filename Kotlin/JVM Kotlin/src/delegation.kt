interface Inter {
    fun display()
}
class FooBar(val x: Int): Inter{
    override fun display() {
        println(x)
    }
}
class FooBar2(val x: String): Inter{
    override fun display() {
        println("Hallo Welt")
        println(x)
    }
}
class Delegato(f: Inter): Inter by f

fun main() {
    val inst = FooBar(42)
    val inst2 = FooBar2("Danke fürs Zuschauen!")
    Delegato(inst2).display()
    Delegato(inst).display()
}