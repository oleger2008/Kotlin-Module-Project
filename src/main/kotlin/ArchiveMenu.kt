class ArchiveMenu(
    override val exit: () -> Unit
) : Menu("Выбор архива:", "Создать новый архив") {
    private var curArchiveIdx: Int = 0
    var openArchive: () -> Unit = {}

    override fun create() {
        println("Введите имя нового архива:")
        val name = UserInputReader.readLine()
        Storage.addArchive(name)
    }

    override fun showImpl() {
        var index = 2
        for (archive in Storage.getAllArchives()) {
            println("$index. ${archive.name}")
            ++index
        }
    }

    override fun executeImpl(index: Int) {
        if (!InRange(index + 1, 1, Storage.size())) {
            printWrongCmdIdxMsg()
            return
        }
        curArchiveIdx = index
        openArchive()
    }

    fun getCurrentArchive(): Archive {
        return Storage.getArchive(curArchiveIdx)
    }
}