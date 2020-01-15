import java.lang.Exception

fun main(args: Array<String>){
	val spieler = Spieler.getInstance()
	val feld = Spielfeld()
	feld.spawnPlayer(0, 0)
	
	while(true){
		println("Du hast " + spieler.hp + " von " + spieler.maxhp + "HP.")
		if(spieler.isDead()){
			break
		}
		print("Wohin des Weges? N/S/O/W")
		val input = readLine()
		when(input){
			"N" -> {
				feld.movePlayer(0,-1)
			}
			"S" -> {
				feld.movePlayer(0,1)
			}
			"O" -> {
				feld.movePlayer(1,0)
			}
			"W" -> {
				feld.movePlayer(-1,0)
			}
		}
		feld.interact()
		println("Du besitzt folgende Gegenstände:")
		var counter = 0
		for(i in spieler.inventar){
			print(counter)
			print(i)
			print("\n")
			counter += 1
		}
		print("Möchtest du eines der Items nutzen? (Nummer des Items oder N)")
		val itemInput = readLine()
		try{
			val item = itemInput?.toInt()
			spieler.useItem(item!!)
		}
		catch(e: Exception){
			
		}
	}
}