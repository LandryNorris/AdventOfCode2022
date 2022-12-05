package day5

data class Stack(val boxes: List<Box> = listOf())

data class Box(val name: Char)

operator fun Stack.plus(box: Box) = copy(boxes = boxes + listOf(box))

fun Stack.removeTop(n: Int = 1) = copy(boxes = boxes.dropLast(n))

val Stack.top get() = boxes.lastOrNull()

fun Stack.top(n: Int) = boxes.drop(boxes.size-n)

fun MutableList<Stack>.moveBox(from: Int, to: Int) {
    val topOfFrom = get(from).top
    if(topOfFrom != null) set(to, get(to) + topOfFrom)
    set(from, get(from).removeTop(1))
}

fun MutableList<Stack>.moveBoxes(from: Int, to: Int, n: Int) {
    val top = get(from).top(n)
    for(box in top) {
        set(to, get(to) + box)
    }
    set(from, get(from).removeTop(n))
}

fun parseStacks(input: String): List<Stack> {
    val boxes = Array(10) { Stack() }
    val lines = input.lines().takeWhile {
        it.isNotBlank()
    }

    lines.reversed().forEach { line ->
        (1 until 4*10 step 4).mapNotNull { line.getOrNull(it) }
            .forEachIndexed { index, c ->
            if(c != ' ' && c.isLetter()) {
                boxes[index] = boxes[index] + Box(c)
            }
        }
    }

    return boxes.asList()
}
