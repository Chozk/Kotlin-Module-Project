import data.Note

class MenuNoteView(private val note: Note) : Menu() {

    override fun menuDisplay() {
        println("\nПросмотр заметки")
        println("Название: ${note.title}")
        println("Содержание: ${note.content}")
        println("0. Выход")
    }

    override fun handlePick(pick: String): Boolean {
        if (pick == "0") return false
        println("Некорректный ввод. Введите '0' для выхода.")
        return true
    }
}