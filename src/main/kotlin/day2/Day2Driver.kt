package day2

import common.TextInputPuzzleDriver

class Day2Driver: TextInputPuzzleDriver<Int, Int>() {
    override fun part1(input: String): Int {
        return input.lines()
            .filter { it.length == 3 }.sumOf {
            playMove(it)
        }
    }

    override fun part2(input: String): Int {
        return input.lines().filter { it.length == 3 }.sumOf {
            playForResult(it)
        }
    }
}