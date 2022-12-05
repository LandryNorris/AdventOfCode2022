package day5

import common.TextInputPuzzleDriver

class Day5Driver: TextInputPuzzleDriver<String, String>() {
    override fun part1(input: String): String {
        val stacks = parseStacks(input)
        val movedStacks = parseSteps(input, stacks) { mutableStacks, from, to, n ->
            repeat(n) {
                mutableStacks.moveBox(from, to)
            }
        }
        val topOfEach = movedStacks.topOfEach
        return topOfEach.joinToString("") { it.name.toString() }
    }

    override fun part2(input: String): String {
        val stacks = parseStacks(input)
        val movedStacks = parseSteps(input, stacks) { mutableStacks, from, to, n ->
            mutableStacks.moveBoxes(from, to, n)
        }
        val topOfEach = movedStacks.topOfEach
        return topOfEach.joinToString("") { it.name.toString() }
    }

    private fun parseSteps(input: String, stacks: List<Stack>,
                           action: (MutableList<Stack>, Int, Int, Int) -> Unit): List<Stack> {
        val mutableStacks = stacks.toMutableList()

        input.lines().dropWhile { it.isNotEmpty() }.forEach { line ->
            val ints = line.split(' ')
                .mapNotNull { it.toIntOrNull() }

            if(ints.size == 3) {
                val n = ints[0]
                val from = ints[1]-1
                val to = ints[2]-1

                action(mutableStacks, from, to, n)
            }
        }

        return mutableStacks
    }

    private val List<Stack>.topOfEach get() = mapNotNull {
        it.top
    }
}