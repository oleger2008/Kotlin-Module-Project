class NoteMenu(
    override val exit: () -> Unit
): Menu("Выбор заметки:", "Создать новую заметку") {
    var currentArchive: Archive = Archive("")

    override fun create() {
        println("Введите имя новой заметки:")
        val name = UserInputReader.readLine()
        currentArchive.addNote(Note(name))
        println("Введите содержимое заметки:")
        val inner = UserInputReader.readLine()
        currentArchive.notes.last().inner = inner
    }

    override fun showImpl() {
        var index = 2
        for (note in currentArchive.notes) {
            println("$index. ${note.name}")
            ++index
        }
    }

    override fun executeImpl(index: Int) {
        if (!InRange(index + 1, 1, currentArchive.notes.size)) {
            printWrongCmdIdxMsg()
            return
        }
        println("Содержимое заметки:")
        currentArchive.notes[index].show()
        do {
            println("\nВведите цифру '0' для выхода из просмотра заметки.")
            val exitNum = UserInputReader.readCmdIdx()
            if (exitNum == 0) {
                break
            }
        } while (true)
    }
}