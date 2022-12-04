package day4

data class Elf(val assignments: IntRange)

fun parseElfPair(input: String): Pair<Elf, Elf>? {
    val parts = input.split(",")
    val elves = parts.mapNotNull { parseElf(it) }

    if(elves.size < 2) return null
    return elves.first() to elves[1]
}

fun parseElf(input: String): Elf? {
    val parts = input.split("-").mapNotNull { it.toIntOrNull() }
    if(parts.size < 2) return null
    return Elf(parts[0] .. parts[1])
}

fun Pair<Elf, Elf>.hasIntersection() =
    first.assignments.intersect(second.assignments).isNotEmpty()

fun Pair<Elf, Elf>.hasRangeFullyContained(): Boolean {
    val firstContainsSecond = (second.assignments - first.assignments)
        .isEmpty()
    val secondContainsFirst = (first.assignments - second.assignments)
        .isEmpty()

    return firstContainsSecond || secondContainsFirst
}
