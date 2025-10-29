fun main() {
    val matrix = Array(5) { IntArray(5) }

    println("Введите матрицу 5x5 (5 строк по 5 чисел через пробел):")

    // Простой ввод матрицы
    for (i in 0 until 5) {
        print("Строка ${i + 1}: ")
        val numbers = readLine()!!.trim().split(" ").map { it.toInt() }
        for (j in 0 until 5) {
            matrix[i][j] = numbers[j]
        }
    }

    // Вывод матрицы
    println("\nВведенная матрица:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }
    println()

    // Проверка симметричности
    var isSymmetric = true

    for (i in 0..4) {
        for (j in (i + 1)..4) {
            print("matrix[$i][$j] = ${matrix[i][j]} == matrix[$j][$i] = ${matrix[j][i]} -> ")
            if (matrix[i][j] == matrix[j][i]) {
                println("✓")
            } else {
                println("✗")
                isSymmetric = false
            }
        }
    }

    println("\nРезультат: матрица ${if (isSymmetric) "симметрична" else "не симметрична"}")
}