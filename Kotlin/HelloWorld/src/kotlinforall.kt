fun wirdVonInnenAufgerufen(){
	print(" ")
}

fun moduloUebung(reihe: Int, until: Int, from: Int) {
	//println(5%3) // 5/3 = 1, 5%3=2
	for(i in from..until){
		var vielfachesVon: Boolean = i%reihe == 0
		if(vielfachesVon){
			wirdVonInnenAufgerufen()
			println(i)
		}
	}
}

fun add(a: Int, b: Int): Int {
	var x: Int = a + b
	return x
}

fun main(args: Array<String>) {
	var x: Int = add(1, 1)
	x = add(x, 4)
	println(x)
	/*
	val meineReihe: Int = 6
	moduloUebung(meineReihe, -10, 60) //Leere Ausgabe, da Parameter in falscher Reihenfolge!
	println("---------------------")
	moduloUebung(11, 463, 200)
	println("---------------------")
	moduloUebung(5, 12, -15)
	println("---------------------")
	*/
	
	
	
	
	
	
	
	
	
	
	if(false){
		var x: Int = 5
		when(x){
			0,1,2,3,4,5 -> println("x is between 0 and 5")
			in 6..42 -> println("das ist die Antwort")
			else -> {
				println("x is unknown babam")
				println("buuuh")
			}
		}
		var y = when(x){
			in 0..42 -> 42
			else -> 50
		}
		println(y)
		when{
			x > 5 -> println("greater than 5")
			x < 5 -> println("less than 5")
			else -> println("equals 5")
		}
		
		var meinArrrr = arrayOf(42,42,42,424,24,42,42,42,4,24,24,24,2,4,24,4)
		//for(zahl in meinArrrr){
		//	println(zahl)
		//}
		meinArrrr.forEach {
			//println(it)
		}
		for((i, zahl) in meinArrrr.withIndex()){
			println("index = $i")
			println("zahl = $zahl")
		}
		
		for(i in 42 downTo 19 step 3){
			println(i)
		}
		for(i in 0..20){
			println(i)
		}
		
		var meinString111: String = "hello darkness"
		
		x = 5
		anton@while(x > 0){
			josef@for(char: Char in meinString111){
				print(char)
				if(char == ' '){
					break@anton
				}
			}
			x = x - 1
		}
		
		var meinInt: Int = 42
		println("meinInt = $meinInt und das ist auch gut so")
		
		var meineVar: Int = 75
		var meineVar2: Char = meineVar.toChar()
		
		println(meineVar2)
		println(meineVar2.toDouble())
			
		var a: Int = 42
		var b: Int = 1337
		a = b.also { b = a }
		print(a)
		
		
		var meinString: String? = null
		var length: Int = meinString?.length ?:0
		//println(length)
		var length2: Int? = meinString?.length
		length2?.let{
			println(length2)
			println("yey, length2 ist sicher nicht null")
		}
		var meinBool: Boolean? = null //null, false, true
		if(meinBool == false){
			println(meinBool)
		}
		else{
			println("false oder null")
		}
	}
	
	
	if(false){
		var a = 42
		var b = 1337
		var max = if(a > b) a else b
		max = if(a > b){
			println("max is a")
			a
		}
		else{
			println("max is b")
			b
		}
		println(max)
	}
	
	
	
	
	
	
	
	
	
	if(false){
		var meinString: String? = null
		println(meinString?.length)
		
		@kotlin.ExperimentalUnsignedTypes
		var meineZahl: UInt = 0U+42U //2^64-1
		print(meineZahl)
	}
}