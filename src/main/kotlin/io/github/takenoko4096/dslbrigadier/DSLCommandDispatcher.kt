package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher

class DSLCommandDispatcher<S> {
    private val dispatcher = CommandDispatcher<S>()

    fun build(name: String, builder: DSLCommandNode<S>.() -> Unit): DSLCommand<S> {
        return DSLCommand(DSLCommandNode.root(name, builder))
    }

    operator fun DSLCommand<S>.unaryPlus() {
        dispatcher.register(literalArgumentBuilder)
    }

    infix fun String.command(builder: DSLCommandNode<S>.() -> Unit) {
        dispatcher.register(DSLCommandNode.root(this, builder))
    }

    fun registration(callback: DSLCommandDispatcher<S>.() -> Unit) {
        callback()
    }

    fun execute(command: String, s: S): Int {
        return dispatcher.execute(command, s)
    }
}
