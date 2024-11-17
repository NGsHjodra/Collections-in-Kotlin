package kekw.ngs.collectionsandothers

fun pairsTriples() {
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}\n")
    println(equipment2.first.second)
}

fun pairsTriples2() {
    val equipment = "fish net" to "catching fish"
    val (tool, use) = equipment
    println("$tool is used for $use")

    val numbers = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
}

fun lists() {
    val list = listOf(1, 5, 3, 4)
    println(list.sum())

    val list2 = listOf("a", "bbb", "cc")
//    println(list2.sum()) // error!!!
    println(list2.sumOf { it.length })

    for (s in list2.listIterator()) {
        println("$s ")
    }
}

fun hashMaps() {
    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )
    println(scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    println(scientific.getOrElse("swordtail") {"sorry, I don't know"})
}

object Constants {
    const val CONSTANT2 = "object constant"
}

fun organizeConstants() {
    val foo = Constants.CONSTANT2
    println(foo)
}

fun String.hasSpaces() = indexOf(" ") != -1

fun testHasSpacesExtensions() {
    val str = "arstoien "
    val statementA = if (str.hasSpaces()) "that string has spaces" else "that string has no space"
    println(statementA)
}

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun testPlantExtensions() {
    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
    println(aquariumPlant.isGreen)

    val plantB: AquariumPlant? = null
    plantB.pull()
}

fun main() {
    pairsTriples()
    pairsTriples2()

    println()

    lists()
    hashMaps()

    println()

    organizeConstants()

    testHasSpacesExtensions()
    testPlantExtensions()
}