interface Wifi {
	var connected: Boolean
	val cardname: String
	
	abstract fun connect()
	
	fun print(){
		println("Connected?: " + connected)
	}
}

abstract class Computer(speed: Double, ram: Int, graphics: String){
	open val speed: Double = speed
	val ram: Int = ram
	val graphics: String = graphics
	
	open fun print(){
		println("-----------------------")
		println("Speed: " + speed)
		println("Ram: " + ram)
		println("Graphics Card: " + graphics)
	}
	
	abstract fun turnOn()
}

class SmartSensor: Wifi {
	override var connected: Boolean = true
	override val cardname: String = "cheap Wifi 1000"
	
	override fun connect() {
		return
	}
	
	fun beep(){
		println("beep")
	}
}

class Laptop(speed: Double, ram: Int, graphics: String, screen: Double): Computer(speed, ram, graphics), Wifi{
	val screen: Double = screen
	override val speed: Double = super.speed/2
	override val cardname: String = "Wifi"
	override var connected: Boolean = false
	
	override fun connect(){
		connected = true
	}
	
	override fun turnOn(){
		println("Open")
		println("Press Button")
	}
	
	override fun print(){
		super<Computer>.print()
		super<Wifi>.print()
	}
}

class Desktop(speed: Double, ram: Int, graphics: String, lights: Boolean): Computer(speed, ram, graphics){
	val lights: Boolean = lights
	
	override fun print(){
		super.print()
		println("I has lighz: " + lights)
	}
	
	override fun turnOn(){
		println("Connect to power")
		println("Press Button")
	}
}

class Aktenkoffer(){
	lateinit var laptop: Laptop
	
	fun insertLaptop(l: Laptop){
		laptop = l
	}
	
	fun pullOutLaptop(): Laptop?{
		if(this::laptop.isInitialized){
			return laptop
		}
		else{
			return null
		}
	}
}

fun Aktenkoffer.generateLaptop(): Laptop {
	return Laptop(1.1, 2, "Intel HD 2000", 15.6)
}

fun main(args: Array<String>) {
	//Es gibt: Laptops, Desktop-Computer
	//Alle sind Computer
	var mysensor: SmartSensor = SmartSensor()
	var desktop: Desktop = Desktop(4.2, 32, "GTX 1080", true)
	var laptop: Laptop = Laptop(2.1, 8, "Intel HD 3000", 15.6)
	
	var aktenkoffer: Aktenkoffer = Aktenkoffer()
	aktenkoffer.insertLaptop(laptop)
	aktenkoffer.pullOutLaptop()?.print()
	aktenkoffer.generateLaptop().print()
	return
	
	var mycomputers:Array<Computer> = arrayOf(desktop, laptop)
	for(i in mycomputers){
		i.print()
		i.turnOn()
	}
	
	var mywifidevices: Array<Wifi> = arrayOf(laptop, mysensor)
	for(i in mywifidevices){
		i.connect()
	}
	
	var myswitcheroo: Wifi = laptop
	if(myswitcheroo is SmartSensor){
		myswitcheroo.beep()
	}
	var myunsafeLaptop: Laptop? = null
	if(myswitcheroo is Laptop){
		myunsafeLaptop = myswitcheroo as Laptop
	}
	myunsafeLaptop?.turnOn()
	
	var myunsafeSensor: SmartSensor? = myswitcheroo as? SmartSensor
	
}