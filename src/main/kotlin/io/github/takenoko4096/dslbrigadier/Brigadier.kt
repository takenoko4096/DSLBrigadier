package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands

fun <S> CommandDispatcher<S>.registration(callback: GeneralCommandRegistrar<S>.() -> Unit) {
    GeneralCommandRegistrar(this).callback()
}

fun <S> command(name: String, builder: UnbuiltDSLCommand<S>.() -> Unit): DSLCommand<S> {
    return UnbuiltDSLCommand.createCommand(name, builder)
}

fun Commands.registration(callback: CommandRegistrar.() -> Unit) {
    CommandRegistrar(this).callback()
}

fun minecraftPaperCommand(name: String, builder: UnbuiltDSLCommand<CommandSourceStack>.() -> Unit): DSLCommand<CommandSourceStack> {
    return command(name, builder)
}
