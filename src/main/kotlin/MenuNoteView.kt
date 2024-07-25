import data.Note

class MenuNoteView(private val note: Note) : Menu() {

    override fun menuDisplay() {
        println("\nПросмотр заметки")
        println("Название: ${note.title}")
        println("Содержание: ${note.content}")
        println("0. Назад")
    }

    override fun handlePick(pick: String) {
        when (pick) {
            "0" -> return
            else -> println("Некорректный выбор. Введите цифру меню.")
        }
    }
}