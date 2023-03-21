import java.util.Scanner

object UserInputReader {
    fun readCmdIdx(): Int? {
        println("Введите номер команды:")
        val idx = Scanner(System.`in`).nextLine().toIntOrNull()
        if (idx == null) {
            println("Необходимо ввести порядковый номер команды. Повторите попытку.\n")
        }
        return idx
    }

    fun readLine(): String {
        return Scanner(System.`in`).nextLine()
    }
}