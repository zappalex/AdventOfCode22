import java.io.File

val inputFileNameProd = "/Users/alexashworth/Desktop/AdventOfCodeKotlin/src/main/kotlin/input.txt"
val inputFileNameTest = "/Users/alexashworth/Desktop/AdventOfCodeKotlin/src/main/kotlin/testInput.txt"

fun main(args: Array<String>) {
    getParsedInputFile(inputFileNameTest)
}

fun getParsedInputFile(inputFileName: String): ArrayList<Int> {
    val inputArray: ArrayList<Int> = ArrayList<Int>()

    try {
        val file = File(inputFileName)
        if (file.exists()) {
            val lines = file.readLines()
            // separate out blank lines for next time
            for (line in lines) {
                try {
                    val intValue = line.trim().toInt()
                    println("Adding $intValue to array")
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










