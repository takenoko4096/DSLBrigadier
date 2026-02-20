package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher

fun <S> CommandDispatcher<S>.registration(callback: CommandRegistrar<S>.() -> Unit) {
    CommandRegistrar(this).callback()
}

fun <S> command(name: String, builder: DSLCommandNode<S>.() -> Unit): DSLCommand<S> {
    return DSLCommand(DSLCommandNode.root(name, builder))
}
