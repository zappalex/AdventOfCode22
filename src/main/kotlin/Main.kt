import java.io.File

val inputFileProd = "/Users/alexashworth/Desktop/AdventOfCode/AdventOfCodeKotlin/src/main/kotlin/input.txt"
val inputFileTest = "/Users/alexashworth/Desktop/AdventOfCode/AdventOfCodeKotlin/src/main/kotlin/testInput.txt"

fun main(args: Array<String>) {
    println(getSumOfHighestNCalories(3, inputFileProd))
}

fun getSumOfHighestNCalories(numberOfElves: Int, inputFileName: String ): Int {
    return getListOfHighestIndividualCalories(numberOfElves, inputFileName).sum()
}

fun getListOfHighestIndividualCalories(numberOfElves: Int, inputFileName: String ): List<Int> {
    val parsedInputList = getParsedInputList(inputFileName)
    val talliedCalorieList = getTalliedCalorieList(parsedInputList)

    return talliedCalorieList.sortedDescending().subList(0, numberOfElves)
}

fun getTalliedCalorieList(inputList: ArrayList<Int>): ArrayList<Int> {
    val talliedCalorieList: ArrayList<Int> = ArrayList<Int>()
    var currentTally = 0

    inputList.forEachIndexed { index, calories ->
        if(calories.equals(0) && currentTally > 0 ) {
            talliedCalorieList.add(currentTally)
            currentTally = 0
        } else {
            currentTally += calories

            // corner case: last element
            if(index.equals(inputList.lastIndex)) talliedCalorieList.add(currentTally)
        }
    }

    return talliedCalorieList
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









