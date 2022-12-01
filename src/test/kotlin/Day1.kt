import day1.Day1Driver
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1 {
    @Test
    fun runDay1() {
        runTextPuzzle(Day1Driver(), "input/day1/input.txt",
            70698, 206643)
    }
}