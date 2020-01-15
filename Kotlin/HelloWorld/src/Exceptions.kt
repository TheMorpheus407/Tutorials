class BeispielException(message: String): Exception(message)
class NetworkException(message: String): Exception(message)


fun myWrongFunction(): Int {
	if(42==43){
		throw NetworkException("Ups. Network down?")
	}
	throw BeispielException("Here is something very much broken.")
	return 42
}

fun main(args: Array<String>) {
	try{
		println(myWrongFunction())
	}
	catch(e: BeispielException){
		println("No need to worry, just an example")
	}
	catch(e: NetworkException){
		println("Hey, user. Please check your network connection.")
	}
	
	try{
		val x = 42/1
		println(x)
		val array = arrayOf(1,2,3,4)
		println(array[3])
	}
	catch(e: ArithmeticException){
		println(e)
	}
	catch(e: ArrayIndexOutOfBoundsException){
		println(e)
	}
	finally{
		println("finally")
	}
	
	val alter: Int? = try{
		readLine()!!.toInt()
	}
	catch(e: NumberFormatException){
		null
	}
	println(alter)
}