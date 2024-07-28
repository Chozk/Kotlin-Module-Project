import data.Archive

class MenuArchiveCreate(private val archives: MutableList<Archive>) {
    private val menuManager = MenuManager()

    init {
        menuManager.menuAddItem("Создать архив") { archiveCreate() }
    }

    fun show() {
        menuManager.menuShow("Создание нового архива")
    }

    private fun archiveCreate() {
        val name = menuManager.readLine("Введите название архива: ")
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Название архива не может быть пустым.")
        }
    }
}
