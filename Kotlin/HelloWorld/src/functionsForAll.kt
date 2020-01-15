fun proAdd(a: Int, b: Int = 42): Int {
	return a+b
}
fun somethingWithArrays(a: Array<Int>, len: Int = a.size){
	for(i in 0..len-1){
		print(a[i])
	}
}

fun square(x: Int): Int {
	return x*x
}

fun squareOneLine(x: Int) = x*x

fun main(args: Array<String>) {
	println(proAdd(42, 1337))
	somethingWithArrays(arrayOf(2,3,4))
	println("\n" + squareOneLine(5))
}