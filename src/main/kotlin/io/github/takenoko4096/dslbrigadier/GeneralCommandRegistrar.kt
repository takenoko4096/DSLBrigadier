package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.CommandDispatcher

class GeneralCommandRegistrar<S>(dispatcher: CommandDispatcher<S>) : AbstractCommandRegistrar<CommandDispatcher<S>, S>(dispatcher) {
    override infix fun String.command(builder: UnbuiltDSLCommand<S>.() -> Unit) {
        registrar.register(UnbuiltDSLCommand.createCommand(this, builder).literalArgumentBuilder)
    }

    override operator fun DSLCommand<S>.unaryPlus() {
        registrar.register(literalArgumentBuilder)
    }
}
