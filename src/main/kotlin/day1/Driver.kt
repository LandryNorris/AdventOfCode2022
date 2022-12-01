package day1

import common.TextInputPuzzleDriver

class Driver: TextInputPuzzleDriver<Int, Int>() {
    private fun parse(input: String): List<Elf> {
        val calories = input
            .lines()
            .map(String::toIntOrNull)

        val result = arrayListOf<Elf>()

        var currentElf = Elf()
        calories.forEach {
            if(it == null) {
                result.add(currentElf)
                currentElf = Elf()
            } else {
                currentElf += Food(it)
            }
        }

        return result
    }

    private fun findElfWithMostCalories(elves: List<Elf>) = elves.maxBy(Elf::totalCalories)

    private fun topElves(count: Int, elves: List<Elf>) =
        elves.sortedByDescending(Elf::totalCalories).take(count)

    private fun top3ElvesTotalCalories(elves: List<Elf>) =
        topElves(3, elves).sumOf(Elf::totalCalories)

    override fun part1(input: String): Int {
        val elves = parse(input)
        return findElfWithMostCalories(elves).totalCalories()
    }

    override fun part2(input: String): Int {
        val elves = parse(input)
        return top3ElvesTotalCalories(elves)
    }
}