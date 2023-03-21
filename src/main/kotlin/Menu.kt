abstract class Menu(
    private val title: String,
    private val createCmdName: String
) {
    abstract val exit: () -> Unit

    protected abstract fun create()
    protected abstract fun showImpl()
    protected abstract fun executeImpl(index: Int)

    fun execute(cmdIdx: Int) {
        when (cmdIdx) {
            0 -> exit()
            1 -> create()
            else -> executeImpl(cmdIdx - 2)
        }
    }

    fun show() {
        println(title)
        println("0. Выход")
        println("1. $createCmdName")
        showImpl()
    }

    protected fun printWrongCmdIdxMsg() {
        println("Введен некорректный номер команды. Повторите попытку.\n")
    }
}