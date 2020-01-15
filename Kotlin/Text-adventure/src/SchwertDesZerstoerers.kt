class SchwertDesZerstoerers : Waffe {
	override fun use(character: IngameCharacter) {
		character.dmg *= 2
	}
}