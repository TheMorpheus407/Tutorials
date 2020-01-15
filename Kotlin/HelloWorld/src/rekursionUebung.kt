fun fakultaet(n: Int): Int{
	var result: Int = 1
	for(i in 1..n){
		result = result * i
	}
	return result
}

fun fakultaetRekursiv(n: Int): Int{
	if(n <= 1){
		return 1
	}
	return n*fakultaetRekursiv(n-1)
}

fun main(args: Array<String>) {
	//5! = 5*4*3*2*1
	//5! = 5*4!
	//4! = 4*3!
	//3! = 3*2!
	//2! = 2*1!
	//1! = 1
	var x: Int = fakultaet(5)
	var y: Int = fakultaetRekursiv(50)
	println(y)
	println(x)
}