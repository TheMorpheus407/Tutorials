import kotlin.math.round

fun main(){
    val mylocalfun = {a: Double, b: Double ->
        println("hallo welt")
        val res = round(a-b).toInt()
        res
    }
    higherOrderFunc(mylocalfun, 42)
}

//()->((Int, Int)->Int)
fun myfunc():((Int, Int)->Int) {
    return {a: Int, b: Int -> a+b}
}

fun higherOrderFunc(func: (a: Double, b: Double)-> Int, a: Int) {
    val res: Int = func(1.5,2.5)
    println(res)
    println(a)
}
