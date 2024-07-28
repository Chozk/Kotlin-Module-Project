import data.Archive

class MenuArchive : Menu() {
    private val archives = mutableListOf<Archive>()

    override fun menuDisplay() {
        println("\nАрхивы:")
        if (archives.isEmpty()) {
            println("Архивов нет.")
        }
        val archiveNames = archives.map { it.name }
        displayList(archiveNames, "Создать архив")
    }

    override fun handlePick(pick: String): Boolean {
        var continueLoop = true
        handleNumericPick(pick, archives.size + 1) { index ->
            when (index) {
                0 -> continueLoop = false // Установить флаг для выхода
                in 1..archives.size -> MenuNote(archives[index - 1]).show()
                archives.size + 1 -> MenuArchiveCreate(archives).show()
            }
        }
        return continueLoop
    }
}