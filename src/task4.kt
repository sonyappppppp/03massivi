fun main() {
    println("=== ПЕРЕСЕЧЕНИЕ МАССИВОВ ===")


    print("Введите первый массив (через пробел): ")
    val array1 = readLine()!!.split(" ").map { it.toInt() }

    print("Введите второй массив (через пробел): ")
    val array2 = readLine()!!.split(" ").map { it.toInt() }


    val intersection = findIntersection(array1.toIntArray(), array2.toIntArray())


    println("\nПервый массив: ${array1.joinToString()}")
    println("Второй массив: ${array2.joinToString()}")
    println("Пересечение: ${intersection.joinToString()}")
}

fun findIntersection(arr1: IntArray, arr2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val list2 = arr2.toMutableList()

    for (num in arr1) {
        // Если элемент есть во втором массиве, добавляем его в результат и удаляем из второго
        if (list2.contains(num)) {
            result.add(num)
            list2.remove(num)
        }
    }

    return result.toIntArray()
}