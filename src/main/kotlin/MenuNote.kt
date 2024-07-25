import data.Archive
import data.Note

class MenuNote(private val archive: Archive) : Menu() {
    private val menuManager = MenuManager()

    init {
        menuManager.menuAddItem("Создать заметку") { MenuNoteCreate(archive.notes).show() }
    }

    override fun menuDisplay() {
        println("\nЗаметки в архиве '${archive.name}':")
        if (archive.notes.isEmpty()) {
            println("Нет заметок.")
        } else {
            archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
        }
        println("0. Назад")
    }

    override fun handlePick(pick: String) {
        val index = pick.toIntOrNull()
        if (index != null && index in 1..archive.notes.size) {
            MenuNoteView(archive.notes[index - 1]).show()
        } else if (index == 1) {
            MenuNoteCreate(archive.notes).show()
        } else {
            println("Некорректный ввод. Введите цифру меню.")
        }
    }

}