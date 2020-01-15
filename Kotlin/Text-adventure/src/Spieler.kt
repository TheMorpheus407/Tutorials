class Spieler : IngameCharacter(100, 5) {
	val inventar = mutableListOf<Item>()
	
	fun pickUp(i: Item){
		inventar.add(i)
	}
	
	fun useItem(i: Int){		
		val itemToUse: Item = inventar[i]
		itemToUse.use(this)
		inventar.remove(itemToUse)
	}
	
	companion object {
		private val instance: Spieler = Spieler()
		public fun getInstance(): Spieler {
			return instance
		}
	}
}