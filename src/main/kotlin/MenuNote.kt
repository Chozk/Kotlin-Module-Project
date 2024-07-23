import data.Archive
import data.Note

class MenuNote(private val archive: Archive) : Menu<Note>(archive.notes) {
    private val notes = items

    override fun menuDisplay() {
        println("\nЗаметки в архиве '${archive.name}':")
        if (archive.notes.isEmpty()) {
            println("Нет заметок.")
        } else {
            archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
        }
        println("0. Создать заметку")
        println("выход. Назад")
    }

    override fun handlePick(pick: String) {
        when (pick) {
            "0" -> MenuNoteCreate(notes).show()
            "выход" -> return
            else -> {
                val index = pick.toIntOrNull()
                if (index != null && index in 1..archive.notes.size) {
                    MenuNoteView(archive.notes[index - 1]).show()
                } else {
                    println("Некорректный выбор.")
                }
            }
        }
    }

}