import kotlin.math.*

class Circle(radius: Double) {	
	init {
		println("hallo Kreis")
		println(radius) //ACHTUNG! Nicht this.radius, sondern der Radius aus dem primären Konstruktor
		println(area()) //Berechnet 0.0, weil this.radius zu diesem Zeitpunkt noch nicht existiert
		println("------------")
	}
	
	constructor(radius: Double, printMe: String): this(radius){
		println(printMe)
	}
	constructor(radius: Double, printMe: Int, printMeTwice: String): this(radius){
		println(printMe)
		println(printMeTwice)
	}
	
	public var radius: Double = radius
		get() = field
		set(value) {
			if(value >= 0.0){
				field = value
			}
		}
	init { //Es sind so viele Init-Blöcke möglich, wie ihr wollt
		println("hallo Kreis")
		println(radius)
		println(area())
		
	}
	public var isValidCircle: Boolean = radius >= 0.0
		get() = radius >= 0.0

	fun area(): Double = radius * radius * PI
}

fun main(args: Array<String>) {
	var c: Circle = Circle(50.0, 42, "printMeTwice")
	c.radius = -42.0
	println(c.radius)
	println(c.area())
}