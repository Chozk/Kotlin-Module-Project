import data.Archive

class MenuArchiveCreate(private val archives: MutableList<Archive>) : Menu<Archive>(archives) {

    override fun show() {
        menuDisplay()
        val name = readLine("Введите название архива: ")
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Название архива не может быть пустым.")
        }
    }

    override fun menuDisplay() {
        println("\nСоздание нового архива")
    }

    override fun handlePick(pick: String) {

    }
}