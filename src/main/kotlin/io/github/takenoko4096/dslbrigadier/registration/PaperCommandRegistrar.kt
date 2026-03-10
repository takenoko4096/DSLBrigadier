package io.github.takenoko4096.dslbrigadier.registration

import io.github.takenoko4096.dslbrigadier.registration.AbstractCommandRegistrar
import io.github.takenoko4096.dslbrigadier.DSLCommand
import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.command.brigadier.Commands

class PaperCommandRegistrar internal constructor(commands: Commands) : AbstractCommandRegistrar<Commands, CommandSourceStack>(commands) {
    override infix fun String.command(builder: ConfigurableCommandNode<CommandSourceStack>.() -> Unit) {
        val command = ConfigurableCommandNode.createCommand(this, builder)
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