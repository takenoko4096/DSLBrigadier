package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class AbstractBrigadierCommand(name: String) : ConfigurableCommandNode<CommandSourceStack>(name) {
    private var built: Boolean = false

    protected abstract fun command()

    internal fun create(): DSLCommand<CommandSourceStack> {
        if (!built) {
            command()
        }

        return DSLCommand(
            this.argumentBuilder as LiteralArgumentBuilder<CommandSourceStack>,
            name,
            description,
            aliases
        )
    }
}
