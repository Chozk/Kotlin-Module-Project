import java.util.Scanner

class MenuManager {
    private val scanner = Scanner(System.`in`)
    private val menuItems = mutableListOf<Pair<String, () -> Unit>>()

    fun menuAddItem(name: String, action: () -> Unit) {
        menuItems.add(name to action)
    }

    fun menuShow(prompt: String) {
        while (true) {
            println("\n$prompt")
            menuItems.forEachIndexed { index, (name, _) -> println("$index. $name") }
            println("${menuItems.size}. Выход")
            val pick = getUserPick()
            if (pick == menuItems.size.toString()) break
            handlePick(pick)
        }
    }

    private fun getUserPick(): String {
        print("Выберите опцию: ")
        return scanner.nextLine().trim()
    }

    private fun handlePick(pick: String) {
        val index = pick.toIntOrNull()
        if (index != null && index in 0 until menuItems.size) {
            menuItems[index].second.invoke()
        } else {
            println("Некорректный ввод. Введите цифру меню.")
        }
    }

    fun readLine(prompt: String): String {
        print(prompt)
        return scanner.nextLine().trim()
    }
}
