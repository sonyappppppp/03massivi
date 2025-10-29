fun main() {
    println("=== ГРУППИРОВКА СЛОВ ПО ОДИНАКОВЫМ БУКВАМ ===")

    println("Введите слова через пробел:")
    print("> ")
    val input = readLine()!!.trim()

    if (input.isEmpty()) {
        println("Ошибка: не введено ни одного слова")
        return
    }

    val words = input.split("\\s+".toRegex())

    // Группируем слова
    val groupedWords = groupWordsBySameLetters(words)

    // Выводим результат
    println("\nРезультат группировки:")
    printGroupedWords(groupedWords)
}

fun groupWordsBySameLetters(words: List<String>): Map<String, List<String>> {
    val groups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        // Создаем ключ - отсортированная версия слова
        val key = word.toCharArray().sorted().joinToString("")

        // Добавляем слово в соответствующую группу
        if (!groups.containsKey(key)) {
            groups[key] = mutableListOf()
        }
        groups[key]?.add(word)
    }

    return groups
}

fun printGroupedWords(groupedWords: Map<String, List<String>>) {
    var groupNumber = 1

    for ((_, wordList) in groupedWords) {
        println("Группа $groupNumber: ${wordList.joinToString(", ")}")
        groupNumber++
    }
}