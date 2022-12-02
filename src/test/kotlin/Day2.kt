import day2.Day2Driver
import day2.Move
import day2.Result
import day2.compareTo
import kotlin.test.Test
import kotlin.test.assertEquals

class Day2 {
    @Test
    fun runDay2() {
        runTextPuzzle(
            Day2Driver(), "input/day2/input.txt",
            10310, 14859)
    }

    @Test
    fun testRockPaperScissors() {
        assertEquals(Result.Loss, Move.Rock.compareTo(Move.Paper))
        assertEquals(Result.Win, Move.Paper.compareTo(Move.Rock))
        assertEquals(Result.Win, Move.Rock.compareTo(Move.Scissors))
        assertEquals(Result.Win, Move.Scissors.compareTo(Move.Paper))
        assertEquals(Result.Tie, Move.Scissors.compareTo(Move.Scissors))
    }
}