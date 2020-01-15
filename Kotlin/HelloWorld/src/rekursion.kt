fun fibonacci(n: Int): Int {
	if(n == 1){
		return 1
	}
	if(n == 0){
		return 0
	}
	var vorgaenger: Int = fibonacci(n-1)
	var vorvorgaenger: Int = fibonacci(n-2)
	return vorgaenger + vorvorgaenger
}

fun main(args: Array<String>) {
	//Fibonacci: 0,1,1,2,3,5,8,13,21,34
	println(fibonacci(40))
	//fib(5)=fib(4)+fib(3)=3+2=5
	//fib(4)=fib(3)+fib(2)=2+1=3
	//fib(3)=fib(2)+fib(1)=1+1=2
	//fib(2)=fib(1)+fib(0)=1
	//fib(1)=1
	//fib(0)=0
	//fib(2)=fib(1)+fib(0)=1+0=1
	//fib(3)=fib(2)+fib(1)=1+1=2
	//fib(2)=fib(1)+fib(0)=1
	//fib(1)=1
	//fib(0)=0
}