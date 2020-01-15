object Singleton {
    var a: Int = 42

    fun incrementA(){
        a++
    }
}

class Foo{
    var a: Int = 42
    companion object{
        var b: Int = 1337
    }
}

fun main() {
    val obj = Foo()
    obj.a = 43
    Foo.b = 1338
    val obj2 = Foo()
    println(Foo.b)
    println(obj2.a)

    val a = Singleton
    val b = Singleton
    a.incrementA()
    println(a.a)
    println(b.a)
}