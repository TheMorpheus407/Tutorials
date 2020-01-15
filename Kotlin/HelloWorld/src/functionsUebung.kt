fun abs(x: Int) = if(x < 0) x*-1 else x

fun absStd(x: Int): Int {
	if(x < 0){
		return x*-1
	}
	else{
		return x
	}
}

fun sumOfArray(a: Array<Int>): Int {
	var sum: Int = 0
	for(i in a){
		sum = sum + i
	}
	return sum
}

fun fakultaetNew(n: Int): Double{
	var result: Double = 1.0
	for(i in 1..n){
		result = result * i
	}
	return result
}

fun power(base: Double, exp: Int): Double {
	var result: Double = 1.0
	for(i in 1..exp){
		result = base * result
	}
	return result
}

fun sin(x: Double): Double {
	var result: Double = 0.0
	for(n in 0..100){
		result = result + (power(-1.0, n)*power(x, 2*n+1))/fakultaetNew(2*n+1)
	}
	return result
}

fun replace(s: String, toReplace: Char, replaceWith: Char): String {
	var result: CharArray = s.toCharArray()
	for(i in 0..s.length-1){
		if(s[i] == toReplace){
			result[i] = replaceWith
		}
	}
	return String(result)
}

fun main(args: Array<String>) {
	//In einem String, " ", "asddfg" = IneinemString
	println(replace("In einem String", 'S', ';'))
}







