class Heiltrank : Consumable {
	override fun use(character: IngameCharacter) {
		character.hp += 50
		if(character.hp > character.maxhp){
			character.hp = character.maxhp
		}
	}
}