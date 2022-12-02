package day2

import kotlin.math.abs

fun playMove(input: String): Int {
    val a = input[0].toMove()
    val b = input[2].toMove()

    val result = b.compareTo(a)

    return b.points + result.points
}

fun playForResult(input: String): Int {
    val otherMove = input[0].toMove()
    val expectedResult = input[2].toResult()

    val yourMove = when(expectedResult) {
        Result.Win -> otherMove.winningMove()
        Result.Tie -> otherMove
        Result.Loss -> otherMove.losingMove()
    }

    return yourMove.points + expectedResult.points
}

fun Char.toResult() = when(this) {
    'X' -> Result.Loss
    'Y' -> Result.Tie
    'Z' -> Result.Win
    else -> error("$this is not a valid result")
}

fun Char.toMove() = when(this) {
    'A', 'X' -> Move.Rock
    'B', 'Y' -> Move.Paper
    'C', 'Z' -> Move.Scissors
    else -> error("$this is not a valid move")
}

fun Move.winningMove() = when(this) {
    is Move.Rock -> Move.Paper
    is Move.Paper -> Move.Scissors
    is Move.Scissors -> Move.Rock
}

fun Move.losingMove() = when(this) {
    is Move.Rock -> Move.Scissors
    is Move.Scissors -> Move.Paper
    is Move.Paper -> Move.Rock
}

fun Move.compareTo(other: Move): Result {
    return if(abs(this.points - other.points) == 2) {
        if(this is Move.Rock)
            Result.Win
        else
            Result.Loss
    } else if(this.points > other.points)
        Result.Win
    else if(this.points == other.points)
        Result.Tie
    else
        Result.Loss
}

val Result.points get() = when(this) {
    is Result.Win -> 6
    is Result.Tie -> 3
    is Result.Loss -> 0
}

sealed class Result {
    object Win: Result()
    object Tie: Result()
    object Loss: Result()
}

sealed class Move(val points: Int) {

    object Rock: Move(1)
    object Paper: Move(2)
    object Scissors: Move(3)
}
