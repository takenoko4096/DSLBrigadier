package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher
import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode
import io.github.takenoko4096.dslbrigadier.registration.GeneralCommandRegistrar
import io.github.takenoko4096.dslbrigadier.registration.PaperCommandRegistrar
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands

fun <S> CommandDispatcher<S>.registration(callback: GeneralCommandRegistrar<S>.() -> Unit) {
    GeneralCommandRegistrar(this).callback()
}

fun <S> command(name: String, builder: ConfigurableCommandNode<S>.() -> Unit): DSLCommand<S> {
    return ConfigurableCommandNode.createCommand(name, builder)
}

fun Commands.registration(callback: PaperCommandRegistrar.() -> Unit) {
    PaperCommandRegistrar(this).callback()
}

fun minecraftCommand(name: String, builder: ConfigurableCommandNode<CommandSourceStack>.() -> Unit): DSLCommand<CommandSourceStack> {
    return command(name, builder)
}
