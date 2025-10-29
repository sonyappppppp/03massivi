fun main() {
    // Алфавит и нумерация фиксированы по условию
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val numbers = intArrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

    // Ввод данных от пользователя
    println("=== ШИФРОВАНИЕ СООБЩЕНИЯ ===")

    print("Введите ключевое слово: ")
    val keyword = readLine()!!.trim().uppercase()

    print("Введите сообщение для шифрования: ")
    val message = readLine()!!.trim().uppercase()



    println("\nШифрование сообщения:")
    println("Алфавит: $alphabet")
    println("Ключевое слово: $keyword")
    println("Исходный текст: $message")
    println()

    // Шифруем сообщение
    val encrypted = encryptMessage(message, keyword, alphabet, numbers)
    println("\nЗашифрованный текст: $encrypted")
}

fun encryptMessage(message: String, keyword: String, alphabet: String, numbers: IntArray): String {
    val upperMessage = message.uppercase()
    val upperKeyword = keyword.uppercase()

    // Создаем карту: символ -> номер
    val charToNumber = mutableMapOf<Char, Int>()
    for (i in alphabet.indices) {
        charToNumber[alphabet[i]] = numbers[i]
    }

    // Создаем карту: номер -> символ
    val numberToChar = mutableMapOf<Int, Char>()
    for (i in alphabet.indices) {
        numberToChar[numbers[i]] = alphabet[i]
    }

    val result = StringBuilder()

    println("Процесс шифрования:")
    println("-------------------")

    for (i in upperMessage.indices) {
        val messageChar = upperMessage[i]
        val keywordChar = upperKeyword[i % upperKeyword.length] // Циклически используем ключевое слово

        // Находим номер символа сообщения
        val messageNumber = charToNumber[messageChar] ?: throw IllegalArgumentException("Символ '$messageChar' не найден в алфавите")

        // Находим номер символа ключа (сдвиг)
        val shift = charToNumber[keywordChar] ?: throw IllegalArgumentException("Символ ключа '$keywordChar' не найден в алфавите")

        // Вычисляем новый номер с учетом закольцованности (1-33)
        var newNumber = messageNumber + shift
        if (newNumber > 33) {
            newNumber -= 33
        }

        // Находим соответствующий символ
        val encryptedChar = numberToChar[newNumber] ?: throw IllegalArgumentException("Номер $newNumber не найден")

        result.append(encryptedChar)

        // Вывод шагов для наглядности
        println("${messageChar} (№$messageNumber) + ${keywordChar} (сдвиг $shift) = №$newNumber -> ${encryptedChar}")
    }

    return result.toString()
}


