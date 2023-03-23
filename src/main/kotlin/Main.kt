enum class State {
    ARCHIVE_MENU,
    NOTE_MENU
}

fun runMenu(menu: Menu) {
    menu.show()
    val cmdIdx = UserInputReader.readCmdIdx() ?: return
    menu.execute(cmdIdx)
}

fun main() {
    var state: State = State.ARCHIVE_MENU
    var needExit = false
    val exit: () -> Unit = { needExit = true }

    val noteMenuToArchiveMenu: () -> Unit = { state = State.ARCHIVE_MENU }
    val noteMenu = NoteMenu(noteMenuToArchiveMenu)

    val archiveMenu = ArchiveMenu(exit)
    val archiveMenuToNoteMenu: () -> Unit = {
        state = State.NOTE_MENU
        noteMenu.currentArchive = archiveMenu.getCurrentArchive()
    }
    archiveMenu.openArchive = archiveMenuToNoteMenu

    while (!needExit) {
        when(state) {
            State.ARCHIVE_MENU -> runMenu(archiveMenu)
            State.NOTE_MENU -> runMenu(noteMenu)
        }
    }
}
