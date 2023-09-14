import java.io.File

val inputFileProd = "/Users/alexashworth/Desktop/AdventOfCode/AdventOfCodeKotlin/src/main/kotlin/input.txt"
val inputFileTest = "/Users/alexashworth/Desktop/AdventOfCode/AdventOfCodeKotlin/src/main/kotlin/testInput.txt"

fun main(args: Array<String>) {
    println(getSumOfNHighestCalories(3, inputFileProd))
}

fun getSumOfNHighestCalories(numberOfElves: Int, inputFileName: String ): Int {
    return getHighestCalorieSumsByElfList(numberOfElves, inputFileName).sum()
}

fun getHighestCalorieSumsByElfList(numberOfElves: Int, inputFileName: String ): List<Int> {
    val parsedInputList = getParsedInputList(inputFileName)
    val talliedCalorieList = getCalorieSumsByElfList(parsedInputList)

    return talliedCalorieList.sortedDescending().subList(0, numberOfElves)
}

fun getCalorieSumsByElfList(inputList: ArrayList<Int>): ArrayList<Int> {
    val calorieSumsByElfList: ArrayList<Int> = ArrayList<Int>()
    var currentSum = 0

    inputList.forEachIndexed { index, calories ->
        if(calories.equals(0) && currentSum > 0 ) {
            calorieSumsByElfList.add(currentSum)
            currentSum = 0
        } else {
            currentSum += calories

            // corner case: last element
            if(index.equals(inputList.lastIndex)) calorieSumsByElfList.add(currentSum)
        }
    }

    return calorieSumsByElfList
}

fun getParsedInputList(inputFileName: String): ArrayList<Int> {
    val inputArray: ArrayList<Int> = ArrayList<Int>()

    try {
        val file = File(inputFileName)
        if (file.exists()) {
            val lines = file.readLines()
            for (line in lines) {
                try {
                    if(line.trim().isBlank()) {
                        inputArray.add(0)
                    } else {
                        val intValue = line.trim().toInt()
                        inputArray.add(intValue)
                    }

                } catch (e: NumberFormatException) {
                    println("Error: Invalid integer format: $line will not be saved")
                }
            }
        } else {
            println("File not found: $inputFileName")
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }

    return inputArray
}

fun printList(list: List<Int>) {
    list.forEach {
        println(it)
    }
}









