package day3

data class Rucksack(val compartment1: List<Item>,
                    val compartment2: List<Item>)

data class Item(val name: Char)

fun parseRucksack(input: String): Rucksack? {
    if(input.isBlank()) return null
    val length = input.length

    val compartment1 = input.substring(0, length/2).map {
        Item(it)
    }
    val compartment2 = input.substring(length/2).map {
        Item(it)
    }

    return Rucksack(compartment1, compartment2)
}

val List<Rucksack>.badge get() = this.fold(first().allItems) { acc, value ->
    acc.intersect(value.allItems.toSet()).toList()
}.firstOrNull()

val Rucksack.allItems get() = compartment1 + compartment2

val Rucksack.commonItems get() = compartment1.intersect(compartment2.toSet())

val Item.priority: Int get() = when (name) {
    in 'a' .. 'z' -> {
        name - 'a' + 1
    }
    in 'A' .. 'Z' -> {
        name - 'A' + 1 + 26
    }
    else -> error("$name is not a valid item name")
}
