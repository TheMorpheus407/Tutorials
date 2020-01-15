import java.io.File

fun main(args: Array<String>) {
	File("data/data.txt").forEachLine(Charsets.UTF_8){
		//println(it)
	}
	val stream = File("data/data.txt").inputStream()
	var bytes = ByteArray(32)
	stream.read(bytes)
	println(bytes.toString(Charsets.UTF_8))
	bytes = ByteArray(32)
	stream.read(bytes)
	println(bytes.toString(Charsets.UTF_8))
	stream.close()
	File("data/meineDaten2.txt").writeText("Hallo Welt.\nWie geht's dir?")
	File("data/meineDaten2.txt").appendText("Hallo Welt.\nWie geht's dir?")

}
