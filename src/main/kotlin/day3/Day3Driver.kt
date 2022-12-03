package day3

import common.TextInputPuzzleDriver

class Day3Driver: TextInputPuzzleDriver<Int, Int>() {
    override fun part1(input: String): Int {
        val rucksacks = input.lines().mapNotNull {
            parseRucksack(it)
        }

        return rucksacks.sumOf { rucksack ->
            rucksack.commonItems.sumOf { item ->
                item.priority
            }
        }
    }

    override fun part2(input: String): Int {
        return input.lines().mapNotNull {
            parseRucksack(it)
        }.chunked(3).sumOf {
            it.badge?.priority ?: 0
        }
    }
}