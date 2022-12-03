import day3.Day3Driver
import day3.Item
import day3.priority
import kotlin.test.Test
import kotlin.test.assertEquals

class Day3 {
    @Test
    fun testDay3() {
        runTextPuzzle(Day3Driver(), "input/day3/input.txt",
            8202, 2864)
    }

    @Test
    fun testPriority() {
        assertEquals(26, Item('z').priority)
        assertEquals(1, Item('a').priority)
        assertEquals(27, Item('A').priority)
        assertEquals(52, Item('Z').priority)
        assertEquals(36, Item('J').priority)
        assertEquals(2, Item('b').priority)
        assertEquals(10, Item('j').priority)
    }
}