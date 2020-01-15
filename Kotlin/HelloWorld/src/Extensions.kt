open class A

class B: A()

class C {
	fun bar() = "CCC"
}

fun A.bar() = "AAA"

fun B.bar() = "BBB"

fun C.bar() = "foobar"

fun printMe(a: A){
	println(a.bar())
}

fun main(args: Array<String>) {
	var b: B = B()
	println(b.bar())
	
	var a = b
	a.bar()
	
	printMe(b)
	
	println(C().bar())
}