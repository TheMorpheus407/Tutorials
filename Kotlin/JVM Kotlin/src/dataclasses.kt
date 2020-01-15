data class User(val name: String, val age: Int)

fun main() {
    val ich: User = User("Cedric Mössner", 27)
    val jemandAnders = User("Cedric Mössner", 27)
    println(ich == jemandAnders)
    val (name, alter) = ich
    println(name)
}