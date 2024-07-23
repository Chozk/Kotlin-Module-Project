import data.Archive
import data.Note

class MenuNoteCreate(private val notes: MutableList<Note>) : Menu<Note>(notes) {

    override fun show() {
        menuDisplay()
        val title = readLine("Введите название заметки: ")
        val content = readLine("Введите текст заметки: ")
        if (title.isNotEmpty() && content.isNotEmpty()) {
            notes.add(Note(title, content))
            println("Заметка '$title' создана.")
        } else {
            println("Название и текст заметки не могут быть пустыми.")
        }
    }

    override fun menuDisplay() {
        println("\nСоздание новой заметки")
    }

    override fun handlePick(pick: String) {
    }
}