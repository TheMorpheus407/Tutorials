fun funWithLists(){
	var basicList = listOf(1,2,3,4) + 9 
	basicList += listOf(5,6,7,8) +listOf(2,2,2)
	basicList += 9
	println(basicList)
	basicList -= 9
	basicList -= listOf(2,6,4)
	
	println(basicList)
	println(basicList.size)
	println(basicList.getOrElse(6){"Element not found"})
	println(basicList[2])
	
	
	var reversedList = basicList.reversed()
	println(reversedList)
	var partitionedList = basicList.partition { it > 1 }
	println(partitionedList)
	
	var sliced = basicList.slice(1..3)
	println(sliced)
	var insertedList = basicList.slice(0..1) + 9 + basicList.slice(2..basicList.size-1)
	println(insertedList)
	
	var chunked = basicList.chunked(2)
	println("Chunked: " + chunked)
	
	var takeList = basicList.take(42)
	println(takeList)
	var dropList = basicList.drop(42)
	println(dropList)
	
	println(insertInList(42, basicList, 3))
	
	
	println(basicList.sorted())
	println(basicList.sortedByDescending { it })
	println(basicList.sortedWith(Comparator<Int> { a,b ->
		when{
			a == 4 -> 1
			b == 4 -> -1
			else -> b - a
		}
	}))
	
	println(basicList.map { doSomethingForMap(it)})
	
	
	var zweiteBasicList = listOf(6,7,8,9,10,11,12)
	val pair: Pair<Int, String> = Pair(42,"Glaskanone") //Tupel
	val zipped = basicList.zip(zweiteBasicList)
	println(zipped.unzip())
	
	println(basicList.reduceRight {
		value, accu -> accu - value
	})
	println(basicList.foldRight("hello world"){
		value, accu -> accu + value
	})
	
	println(basicList.foldIndexed(42){
		index, accu, value -> accu + value
	})
	
	println(basicList.count())
	println(basicList.average())
	println(basicList.max())
	println(basicList.min())
	println(basicList.sum())
	
	println(basicList.filter { it -> it > 3 || it < 2 })
	
	println(basicList.findLast { it < 4 || it == 10 && it > 7})
	println(basicList.indexOf(3))
	println(basicList.indexOfLast { it == 3 })
	
	
	println(basicList.distinct())
	println(basicList.intersect(listOf(3,3,4,1)))
	println(basicList.union(listOf(3,9,9,8,7,4)))
	var intermediateList = basicList + listOf(3,9,9,8,7,4)
	println(intermediateList.distinct())
	
	
	println(basicList.any {it < 10})
	println(basicList.all {it < 10})
	println(basicList.none {it == null})
	
	
	println(3 in basicList)
	println(basicList.containsAll(listOf(4,1,4,4)))
	println(containsTimes(basicList, 4, 3))
}

fun insertInList(element: Int, list: List<Int>, index: Int): List<Int>{
	//[0,1,2,3,4,5]
	return list.take(index) + element + list.drop(index)
}

fun doSomethingForMap(a: Int): List<Int> {
	return listOf(1,a,a*a,a*a*a,a*a*a*a)
}

fun containsTimes(list: List<Int>, x: Int, y: Int): Boolean {
	return list.filter { it == x }.size == y
}
fun sets(){
	var basicArray = arrayOf(1,2,3,4)
	var charArray = charArrayOf('h','i')
	var hiString = String(charArray)
	var basicList = listOf(4,1,3,3,4,10)

	
	var basicSet = setOf(4,1,2,3,4,1)
	var hashSet = hashSetOf(4,1,2,3,4,1)
	var linkedSet = linkedSetOf(4,1,2,3,4,1)
	println(basicSet)
	println(hashSet + 5)
	println(linkedSet)
	println(hashSet.toList() +1)
	println(basicList.toHashSet())
}

fun main(args: Array<String>) {
	val myPair: Pair<String, Int> = Pair("hello", 0)
	var myMap: Map<String, Int> = linkedMapOf(myPair, "world" to 42)
	val myPair2: Pair<String, Int> = Pair("!", 2)
	myMap = myMap + myPair2 + mapOf("hans" to 3, "peter" to 4)
	myMap = myMap - listOf("hello", "!")
	
	myMap = myMap.mapKeys{pair -> pair.key + " mmmmmm"}
	myMap = myMap.mapValues{pair -> pair.value + 42}
	
	var mutableMap: MutableMap<String, Int> = mutableMapOf("hello" to 1, "world" to 42)
	var myMap2 = myMap + myPair2
	println(myMap2)
	println(myMap)
	mutableMap.plusAssign(myPair2)
	println(mutableMap.toString())
	
	val myNullableList: List<Int?> = listOf(1,2,3,null,4,5,6,null)
	println(myNullableList.filterNotNull().toString())
	
	
	println("--------------------------------")
	println(myMap.toString())
	println("--------------------------------")
	println(myMap["world"])
	for(e in myMap){
		println(e)
	}
	
}





