class Spielfeld {
	private var waben = Array(100){i -> Array(100){i -> Wabe()}}
	private var playerX: Int = 0
	private var playerY: Int = 0
	
	fun spawnPlayer(x: Int, y: Int){
		playerX = x
		playerY = y
	}
	
	fun movePlayer(diffX: Int, diffY: Int){
		playerX += diffX
		playerY += diffY
		playerX = playerX%100
		playerY = playerY%100
		if(playerX < 0){
			playerX += 100
		}
		if(playerY < 0){
			playerY += 100
		}
	}
	
	fun interact(){
		waben[playerX][playerY].interact()
	}
}
/*
 0,0 ...... 99,0
 ...          ...
 0,99......99,99*/