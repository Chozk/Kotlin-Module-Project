import java.util.Scanner

abstract class Menu<T>(val items: MutableList<T>) {
    protected val scanner = Scanner(System.`in`)

    open fun show() {
        while (true) {
            menuDisplay()
            print("Выберите опцию: ")
            val pick = getUserPick()
            if (pick == "выход") break
            handlePick(pick)
        }
    }

    protected abstract fun menuDisplay()
    protected abstract fun handlePick(pick: String)

    private fun getUserPick(): String {
        return scanner.nextLine().trim()
    }

    protected fun readLine(prompt: String): String {
        print(prompt)
        return scanner.nextLine().trim()
    }
}