import day1.Driver
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1 {
    @Test
    fun testElfCalories() {
        val driver = Driver()
        assertEquals(70698, driver.runPart1("input/day1/input.txt"))
    }

    @Test
    fun testTop3Elves() {
        val driver = Driver()
        assertEquals(206643, driver.runPart2("input/day1/input.txt"))
    }
}