fun fight(spieler: IngameCharacter, npc: IngameCharacter){
	val starter = (0..1).random()
	while(!spieler.isDead() and !npc.isDead()){
		if(starter == 0){
			npc.receiveDamage(spieler.dealDamage())
			spieler.receiveDamage(npc.dealDamage())
		}
		else{
			spieler.receiveDamage(npc.dealDamage())
			npc.receiveDamage(spieler.dealDamage())
		}
	}
	if(spieler.isDead()){
		println("You died. Try again.")
		System.exit(1)
	}
}