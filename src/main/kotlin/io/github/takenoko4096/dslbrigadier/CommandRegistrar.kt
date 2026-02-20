package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher

@BrigadierDSL
class CommandRegistrar<S> internal constructor(private val dispatcher: CommandDispatcher<S>) {
    infix fun String.command(builder: DSLCommandNode<S>.() -> Unit) {
        dispatcher.register(DSLCommandNode.root(this, builder))
    }

    operator fun DSLCommand<S>.unaryPlus() {
        dispatcher.register(literalArgumentBuilder)
    }
}
