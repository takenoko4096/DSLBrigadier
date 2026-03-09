package io.github.takenoko4096.dslbrigadier

import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands

class CommandRegistrar internal constructor(commands: Commands) : AbstractCommandRegistrar<Commands, CommandSourceStack>(commands) {
    override infix fun String.command(builder: UnbuiltDSLCommand<CommandSourceStack>.() -> Unit) {
        val command = UnbuiltDSLCommand.createCommand(this, builder)
        registrar.register(
            command.literalArgumentBuilder.build(),
            command.description,
            command.aliases
        )
    }

    override operator fun DSLCommand<CommandSourceStack>.unaryPlus() {
        registrar.register(
            literalArgumentBuilder.build(),
            description,
            aliases
        )
    }
}
