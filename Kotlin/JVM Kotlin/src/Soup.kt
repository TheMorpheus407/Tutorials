interface Cuttable{
    fun cut()
}
open class Mushroom: Cuttable{
    override fun cut(){
        println("You just cut a mushroom.")
    }
}
class Champignon: Mushroom(){
    override fun cut(){
        println("You just cut a champignon.")
    }
}
class Onion: Cuttable{
    override fun cut(){
        println("You just cut an onion.")
    }
}


class Soup<T: Cuttable>(ingredient: T){
    var prepared: Boolean = false
    var ingredient: MutableList<T> = mutableListOf(ingredient)

    fun prepare(){
        ingredient[0].cut()
        prepared = true
    }

    fun eat(){
        if(prepared) {
            println("Yummi")
        }
    }
    fun add(ing: T){
        ingredient.add(ing)
    }
}
fun add(soup: Soup<Cuttable>, cuttable: Cuttable) = soup.ingredient.add(cuttable)

fun main(soup: Soup<Mushroom>){
    var soup: Soup<Mushroom> = Soup(Champignon())
    //add(soup, Onion())
    soup.prepare()
    soup.eat()
}