import data.Archive

class MenuArchive : Menu<Archive>(mutableListOf()) {
    private val archives = items

    override fun menuDisplay() {
        println("\nАрхивы:")
        if (archives.isEmpty()) {
            println("Нет архивов.\n")
        } else {
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        }
        println("0. Создать архив")
        println("выход. Выйти")
    }

    override fun handlePick(pick: String) {
        when (pick) {
            "0" -> MenuArchiveCreate(archives).show()
            "выход" -> return
            else -> {
                val index = pick.toIntOrNull()
                if (index != null && index in 1..archives.size) {
                    MenuNote(archives[index - 1]).show()
                } else {
                    println("Некорректный выбор.")
                }
            }
        }
    }
}