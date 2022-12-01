import common.PuzzleDriver
import common.TextInputPuzzleDriver
import java.io.File
import kotlin.test.assertEquals

fun <R1, R2> runTextPuzzle(driver: TextInputPuzzleDriver<R1, R2>,
                           path1: String, path2: String,
                           answer1: R1, answer2: R2) {
    assertEquals(answer1, driver.runPart1(path1), "Part 1 incorrect")
    assertEquals(answer2, driver.runPart2(path2), "Part 2 incorrect")
}

fun <R1, R2> runTextPuzzle(driver: TextInputPuzzleDriver<R1, R2>,
                           path: String,
                           answer1: R1, answer2: R2) {
    runTextPuzzle(driver, path, path, answer1, answer2)
}
