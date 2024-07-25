import data.Archive

class MenuArchive : Menu() {
    private val archives = mutableListOf<Archive>()
    private val menuManager = MenuManager()

    init {
        menuManager.menuAddItem("Создать архив") { MenuArchiveCreate(archives).show() }
    }

    override fun show() {
        while (true) {
            menuDisplay()
            val pick = getUserPick()
            if (pick == "0") break
            handlePick(pick)
        }
    }

    override fun menuDisplay() {
        println("\nАрхивы:")
        if (archives.isEmpty()) {
            println("Нет архивов.\n")
        } else {
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}\n") }
        }
        println("${archives.size + 1}. Создать архив")
        println("0. Выход")
    }

    override fun handlePick(pick: String) {
        val index = pick.toIntOrNull()
        if (index != null) {
            when {
                index == 0 -> return
                index in 1..archives.size -> MenuNote(archives[index - 1]).show()
                index == archives.size + 1 -> MenuArchiveCreate(archives).show()
                else -> println("Некорректный ввод. Введите цифру меню.")
            }
        } else {
            println("Некорректный ввод. Введите цифру меню.")
        }
    }
}
