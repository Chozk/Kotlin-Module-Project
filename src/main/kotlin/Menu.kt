// Абстрактный класс Menu, чтобы все меню следовали единому интерфейсу
abstract class Menu {
    abstract fun menuDisplay()
    abstract fun handlePick(pick: String): Boolean

    // Отображение списка с возможностью выбора
    fun displayList(items: List<String>, createOption: String) {
        items.forEachIndexed { index, item -> println("${index + 1}. $item") }
        println("${items.size + 1}. $createOption")
        println("0. Выход")
    }

    // Обработка ввода пользователя и выполнение соответствующего действия
    fun handleNumericPick(pick: String, maxOption: Int, action: (Int) -> Unit): Boolean {
        val index = pick.toIntOrNull()
        if (index != null && index in 0..maxOption) {
            action(index)
            return true
        } else {
            println("Некорректный ввод. Введите цифру меню.")
        }
        return false
    }

    fun show() {
        var continueLoop = true
        while (continueLoop) {
            menuDisplay()
            print("Выберите опцию: ")
            val input = readLine() ?: break
            continueLoop = handlePick(input)
        }
    }

}