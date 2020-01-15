class MyClass{
    var x: Int = 42
    fun foo(a: Int): Int {
        fun bar(b: Int): Int {
            return 42
        }
        return a+bar(0)
    }
    infix fun add(a: MyClass): MyClass{
        var ret = MyClass()
        ret.x = a.x + this.x
        return ret
    }
}

fun main() {

    fun bar(): Int{
        return 42
    }
    var obj = MyClass()
    obj.x = 1337
    println((obj add MyClass()).x)
}