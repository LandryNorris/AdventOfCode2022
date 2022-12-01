package common

import java.io.File

abstract class TextInputPuzzleDriver<R1, R2>: PuzzleDriver<String, R1, R2> {
    fun runPart1(path: String): R1 {
        val content = File(path).readText()
        return part1(content)
    }

    fun runPart2(path: String): R2 {
        val content = File(path).readText()
        return part2(content)
    }
}