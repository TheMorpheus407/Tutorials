class User{
	var name: String = "Anonymous"
}

fun create(newName: String) = User().apply{this.name = newName}

fun main(args: Array<String>) {
	
	var rechte = "morpheus"
	var outtaRun = run{
		val rechte = "root"
		println(rechte)
		2
	}
	var myString: String? = "hello world"
	
	with(myString){
		println(this)
		println(this?.length)
	}

		
	myString?.run{
		println(this.length)
		this.reversed()
	}.run{
		println(this)
	}
	myString?.let{
		println(it)
		it.reversed()
	}.let{
		println(it)
	}
	myString = myString?.also{
		println(it)
		myString = it.reversed()
	}.also{
		println(it)
	}
	var a = 5
	var b = 42
	a = b.also{b = a}
	println(a)
	println(b)
	
	println(outtaRun)
	println(rechte)
	
	
	
}