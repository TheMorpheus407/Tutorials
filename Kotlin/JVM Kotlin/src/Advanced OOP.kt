class Vektor(x: Int, y: Int){
    var x: Int = x
    var y: Int = y

    operator fun plus(b: Vektor): Vektor {
        return Vektor(x+b.x, y+b.y)
    }
    operator fun minus(b: Vektor): Vektor {
        return Vektor(x-b.x, y-b.y)
    }
    operator fun times(b: Vektor): Vektor {
        return Vektor(x*b.x, y*b.y)
    }
    operator fun div(b: Vektor): Vektor {
        return Vektor(x/b.x, y/b.y)
    }
    operator fun rem(b: Vektor): Vektor {
        return Vektor(x%b.x, y%b.y)
    }
    operator fun rangeTo(b: Vektor): MutableList<Vektor> {
        var liste = mutableListOf<Vektor>()
        for (i in x..b.x) {
            for (j in y..b.y) {
                liste.add(Vektor(i, j))
            }
        }
        return liste
    }
}

class Container<T>{
    var liste: MutableList<T> = mutableListOf()

    fun add(a: T){
        liste.add(a)
    }
}

fun <T>genList(a: T): List<T> {
    return listOf<T>(a)
}

fun main(){
    var liste = genList<Int>(42)
    var myContainer: Container<Int> = Container()
    myContainer.add(42)

    var stringContainer: Container<String> = Container()
    stringContainer.add("Hallo Welt")

    return
    var a: Int = 42

    println(a + 2)

    var vec_a = Vektor(1,1)
    var vec_b = Vektor(42,42)
    var vec_c = vec_a / vec_b
    println(vec_c.x)
    println(vec_c.y)
}