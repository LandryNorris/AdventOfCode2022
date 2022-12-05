import day5.*
import kotlin.test.Test
import kotlin.test.assertEquals

class Day5 {
    @Test
    fun testDay5() {
        runTextPuzzle(Day5Driver(), "input/day5/input.txt",
            "CWMTGHBDW", "SSCGWJCRB")
    }

    @Test
    fun testMoveBoxes() {
        val stacks = listOf(
            Stack(listOf(
                'M', 'A', 'D', 'E', 'C'
            ).map { Box(it) }),
            Stack(listOf(
                'A', 'E'
            ).map { Box(it) }),
            Stack(listOf(
                'A', 'B', 'C'
            ).map { Box(it) }),
            Stack(listOf(
                'E', 'W', 'V'
            ).map { Box(it) }),
        )

        val mutableStacks = stacks.toMutableList()

        mutableStacks.moveBox(3, 2)

        assertEquals('W', mutableStacks[3].top?.name)
        assertEquals('V', mutableStacks[2].top?.name)
    }

    @Test
    fun testMoveSeveralItems() {
        val stacks = mutableListOf(
            Stack(listOf('A', 'B', 'C', 'D').map { Box(it) }),
            Stack(listOf('E', 'F').map { Box(it) }),
        )

        repeat(4) {
            stacks.moveBox(0, 1)
        }

        assertEquals(null, stacks[0].top?.name)
        assertEquals('A', stacks[1].top?.name)
    }

    @Test
    fun testMoveSeveralItemsWithCrateMover9001() {
        val stacks = mutableListOf(
            Stack(listOf('A', 'B', 'C', 'D').map { Box(it) }),
            Stack(listOf('E', 'F').map { Box(it) }),
        )

        stacks.moveBoxes(0, 1, 4)

        assertEquals(null, stacks[0].top?.name)
        assertEquals('A', stacks[1].top?.name)
    }
}