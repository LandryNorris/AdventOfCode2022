package day1

data class Elf(val carrying: List<Food> = listOf())

data class Food(val calories: Int)

operator fun Elf.plus(food: Food) = Elf(carrying + food)

fun Elf.totalCalories() = carrying.sumOf { it.calories }
