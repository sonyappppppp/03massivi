fun main() {
    // Ввод размеров массива
    print("Введите количество строк: ")
    val rows = readLine()!!.toInt()

    print("Введите количество столбцов: ")
    val cols = readLine()!!.toInt()

    // Создаем и заполняем массив
    val matrix = Array(rows) { IntArray(cols) }

    println("\nВведите $rows строк по $cols трехзначных чисел (через пробел):")

    for (i in 0 until rows) {
        print("Строка ${i + 1}: ")
        val numbers = readLine()!!.trim().split(" ").map { it.toInt() }
        for (j in 0 until cols) {
            matrix[i][j] = numbers[j]
        }
    }

    // Вывод массива
    println("\nВведенный массив:")
    for (row in matrix) {
        println(row.joinToString("\t"))
    }

    // Подсчет уникальных цифр и вывод результата
    val uniqueDigits = countUniqueDigits(matrix)
    println("\nРезультат: В массиве использовано $uniqueDigits различных цифр")
}

fun countUniqueDigits(matrix: Array<IntArray>): Int {
    val uniqueDigits = mutableSetOf<Char>()

    for (row in matrix) {
        for (number in row) {
            // Для каждого числа добавляем все его цифры в множество
            number.toString().forEach { digit ->
                uniqueDigits.add(digit)
            }
        }
    }

    return uniqueDigits.size
}