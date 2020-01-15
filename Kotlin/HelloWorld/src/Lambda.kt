fun addMe(a: Int, b: Int) = a+b

fun main(args: Array<String>) {
	val addMeTwice = {a: Int, b: Int -> a+b}
	val result = addMeTwice(42, 1337)
	println(addMe(42,1337) == result)
}