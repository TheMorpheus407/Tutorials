fun main(args: Array<String>) {
	//32 Bit Int, Long 64 Bit
	var i: Long = 1
	while(i < i*2){
		i = i*2
	}
	var counter: Long = i
	while(counter >= 1){
		while(i < i+counter){
			i = i+counter
		}
		counter = counter / 2
	}
	println(i)
	println(i+1)
	
	
	
	
	
	
	
	
	
	
	
	
	
	if(false){
		println("Möchtest du das Programm beenden? y/n")
		val userInput = readLine()
		if(userInput == "y"){
			println("K, thx, bye")
		}
		else{
			println("Gib ne Zahl ein!")
			val zahl = Integer.valueOf(readLine())
			println(zahl+2)
		}
	}
	
	if(false){
		//2,3,4,5,6,4,3,2
		//1,1,1,1,1,1,1,1
		//0,0,0,0,0,0,0,0
		//0,0,0,0,0,0,0,0
		//0,0,0,0,0,0,0,0
		//0,0,0,0,0,0,0,0
		//1,1,1,1,1,1,1,1
		//2,3,4,5,6,4,3,2
		var zeile1 = arrayOf(2,3,4,5,6,4,3,2)
		var zeile2 = arrayOf(1,1,1,1,1,1,1,1)
		var zeile3 = arrayOf(0,0,0,0,0,0,0,0)
		var zeile4 = arrayOf(0,0,0,0,0,0,0,0)
		var zeile5 = arrayOf(0,0,0,0,0,0,0,0)
		var zeile6 = arrayOf(0,0,0,0,0,0,0,0)
		var zeile7 = arrayOf(1,1,1,1,1,1,1,1)
		var zeile8 = arrayOf(2,3,4,5,6,4,3,2)
		var spielfeld = arrayOf(zeile1,zeile2,zeile3,zeile4,zeile5,zeile6,zeile7,zeile8)
		spielfeld[1][3] = 0
		spielfeld[3][3] = 1
		
		for(zeile in spielfeld){
			for(feld in zeile){
				print(feld)
				print(",")
			}
			print("\n")
		}
	
	}
	
	
	
	
	
	
	
	
	
	if(false){
		//Fakultät: 5! = 5*4*3*2 0! = 1
		var n: Int = 12
		var i: Int = 1
		var fakultaet: Int = 1
		while(i <= n){
			fakultaet = fakultaet*i
			i = i+1
		}
		println(fakultaet)
	}
	if(false){
		var meinArray = arrayOf(2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54,2572,57,245,2542,542,54,2,542,54,254,25,2786,986,3,5432,54354,354,63,456,54,645,6,46,452,45,654,6,574646,875634,6,456,54,64,6456,54,6,546,54)
		var max: Int = 0
		for(value in meinArray){
			if(value > max){
				max = value
			}
		}
		println(max)
		
		
		
		var x:Int = 10
		while(x > 0){
			x = x - 1
		}
		//x = 0!
		do{
			println(x)
			x = x + 1
		}while(x < 0)
		println(x)
	}
	
	if(false){
		var meinArray: String = "hello world!"
		var verschluesselt = arrayOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
		for(buchstabe: Char in meinArray){
			print(buchstabe+3)
		}
		print("\n")
		for(index in meinArray.indices){
			verschluesselt[index] = meinArray[index] + 3
		}
		val encrypted: String = String(verschluesselt.toCharArray())
		println(encrypted[4])
	}
	
	
	if(!true){
		var a: Int = 1337
		var b: Int = 1337
		var max: Int
		if(a > b){
			max = a
		}
		else{
			max = b
		}
		
		val wahrheit1: Boolean = a == b
		val wahrheit2: Boolean = 42 < 5
		val wahrheit3: Boolean = wahrheit1 || wahrheit2
		var wahrheitswert: Boolean = wahrheit3 && ("hallo"[0] == 'h')
		if(wahrheitswert){
			println(wahrheitswert)
		}
	}
	
	
	
	
	if(42 > 5){
	}
	else{
		var myArray = arrayOf(42,1337,20,"Danke fürs Zugucken :)")
		myArray = Array(2){i -> i} //[0,1]
		println(myArray[1])
		
		var character: Char = 'a'
		character = '\u0A09'
		print(character)
		println("Hello World!")
		
		var helloworldstring: String = "Hello World!!!!11elf!"
		println(helloworldstring[10])
		
		var width: Int = 1920
		//Byte: 8 Bit, Short: 16 Bit, Int: 32 Bit, Long: 64 Bit
		val height: Int = 1080
		val pi: Double = 3.14 //Float: 32 Bit, Double: 64 Bit
		println(width*height)
		width = 3840
		println(width*height)
		val experiment: Double = 1257577.0
		println(experiment)
	}
}
