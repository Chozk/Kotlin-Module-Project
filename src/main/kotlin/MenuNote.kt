import data.Archive

class MenuNote(private val archive: Archive) : Menu() {

    override fun menuDisplay() {
        println("\nЗаметки в архиве '${archive.name}':")
        if (archive.notes.isEmpty()) {
            println("Нет заметок.")
        }
        displayList(archive.notes.map { it.title }, "Создать заметку")
    }

    override fun handlePick(pick: String): Boolean {
        var continueLoop = true
        handleNumericPick(pick, archive.notes.size + 1) { index ->
            when (index) {
                0 -> continueLoop = false
                in 1..archive.notes.size -> MenuNoteView(archive.notes[index - 1]).show()
                archive.notes.size + 1 -> MenuNoteCreate(archive.notes).show()
            }
        }
        return continueLoop
    }
}