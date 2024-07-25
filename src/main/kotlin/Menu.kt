import java.util.Scanner

abstract class Menu {
    protected val scanner = Scanner(System.`in`)

    open fun show() {
        while (true) {
            menuDisplay()
            val pick = getUserPick()
            if (pick == "0") break
            handlePick(pick)
        }
    }

    protected abstract fun menuDisplay()
    protected abstract fun handlePick(pick: String)

    open fun getUserPick(): String {
        print("Выберите опцию: ")
        return scanner.nextLine().trim()
    }
}
