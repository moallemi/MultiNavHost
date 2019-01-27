package me.moallemi.multinavhost.navigation

import java.io.Serializable
import java.util.ArrayList

class TabHistory : Serializable {

    private val stack: ArrayList<Int> = ArrayList()

    private val isEmpty: Boolean
        get() = stack.size == 0

    val size: Int
        get() = stack.size

    fun push(entry: Int) {
        stack.add(entry)
    }

    fun popPrevious(): Int {
        var entry = -1

        if (!isEmpty) {
            entry = stack[stack.size - 2]
            stack.removeAt(stack.size - 2)
        }
        return entry
    }

    fun clear() {
        stack.clear()
    }
}