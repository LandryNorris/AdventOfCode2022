package day4

import common.TextInputPuzzleDriver

class Day4Driver: TextInputPuzzleDriver<Int, Int>() {
    override fun part1(input: String): Int {
        val elfPairs = input.lines().mapNotNull {
            parseElfPair(it)
        }
        return elfPairs.count {
            it.hasRangeFullyContained()
        }
    }

    override fun part2(input: String): Int {
        val elfPairs = input.lines().mapNotNull {
            parseElfPair(it)
        }
        return elfPairs.count {
            it.hasIntersection()
        }
    }
}