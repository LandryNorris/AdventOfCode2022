package common

interface PuzzleDriver<T, R1, R2> {
    fun part1(input: T): R1
    fun part2(input: T): R2
}