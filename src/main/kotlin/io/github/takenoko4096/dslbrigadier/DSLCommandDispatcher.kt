package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher

abstract class DSLCommandDispatcher<S> {
    private val dispatcher = CommandDispatcher<S>()

    infix fun String.command(builder: DSLCommandNode<S>.() -> Unit) {
        val root = DSLCommandNode.newCommand(this, builder)
        dispatcher.register(root)
    }

    operator fun invoke(callback: DSLCommandDispatcher<S>.() -> Unit) {
        callback()
    }

    fun execute(command: String, s: S): Int {
        return dispatcher.execute(command, s)
    }
}
