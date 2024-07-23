import data.Note

class MenuNoteView(private val note: Note) : Menu<Note>(mutableListOf(note)) {
    override fun menuDisplay() {
        println("\nПросмотр заметки")
        println("Название: ${note.title}")
        println("Содержание: ${note.content}")
        println("выход. Назад")
    }

    override fun handlePick(pick: String) {
        when (pick) {
            "выход" -> return
            else -> println("Некорректный выбор.")
        }
    }
}