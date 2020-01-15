fun <T>asList(vararg ts: T): List<T>{
    val res = mutableListOf<T>()
    for(t in ts){
        res.add(t)
    }
    return res
}

fun main() {
    print(asList(42,1,1337,42,"57"))
}