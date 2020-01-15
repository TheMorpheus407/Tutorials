open class Lebewesen {
	var art: String = "Säuger"
	
	private fun aufFurchtbareArtUndWeiseSterben(){
		println("*Röchel*... Tot")
	}
	
	protected fun dieNicely(){
		println("Lebewesen ist friedlich eingeschlafen")
		aufFurchtbareArtUndWeiseSterben()
	}
}

class Maus(name: String, v: Double = 1.0) : Lebewesen() {
	private var name: String = name
	var v: Double = v
	//public, private, protected
	public fun laufrad(dauer: Int): Double {
		return this.v*dauer
	}
	
	public fun die(){
		this.dieNicely()
	}
	
	fun print() {
		println("Name: " + this.name)
		println("Geschwindigkeit: " + this.v + "m/s")
	}
}

fun main(args: Array<String>) {
	var fridolin: Maus = Maus(name = "Fridolin", v = 2.0)
	fridolin.die()
	
	var minnie: Maus = Maus("Minnie")
	fridolin.print()
	fridolin.v = 3.0
	fridolin.print()
	println(fridolin.laufrad(60))
	minnie.print()
	minnie.art = "Maus"
	println(minnie.art)
	
	var lebewesen: Lebewesen = Lebewesen()
	println(lebewesen.art)
}