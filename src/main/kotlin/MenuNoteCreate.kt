import data.Note

class MenuNoteCreate(private val notes: MutableList<Note>) {
    private val menuManager = MenuManager()

    init {
        menuManager.menuAddItem("Создать заметку") { createNote() }
    }

    fun show() {
        menuManager.menuShow("Создание новой заметки")
    }

    private fun createNote() {
        val title = menuManager.readLine("Введите название заметки: ")
        val content = menuManager.readLine("Введите текст заметки: ")
        if (title.isNotEmpty() && content.isNotEmpty()) {
            notes.add(Note(title, content))
            println("Заметка '$title' создана.")
        } else {
            println("Название и текст заметки не могут быть пустыми.")
        }
    }
}