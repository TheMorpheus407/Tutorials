class Wabe {
	val items = mutableListOf<Item>()
	val npcs = mutableListOf<IngameCharacter>(Ork())
	
	constructor() {
		if((0..100).random() > -1){
			items.add(Heiltrank())
		}
	}
	
	fun interact(){
		while(npcs.size > 0){
			println("Dir steht ein Ork mit " + npcs[0].hp + "HP gegenüber.")
			println("Was möchtest du tun? Kämpfen/Wegrennen")
			if(readLine() == "Kämpfen"){
				fight(Spieler.getInstance(), npcs[0])
				npcs.remove(npcs[0])
				if((0..100).random() > 90){
					items.add(SchwertDesZerstoerers())
				}
			}
			else{
				return
			}
		}
		if(items.size == 0){
			return
		}
		println("Möchtest du looten? J/N")
		if(readLine() == "J"){
			for (i in items) {
				println("Du findest " + i)
				Spieler.getInstance().pickUp(i)
			}
		}
	}
}