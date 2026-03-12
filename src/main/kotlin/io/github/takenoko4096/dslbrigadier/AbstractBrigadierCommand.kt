package io.github.takenoko4096.dslbrigadier

import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class AbstractBrigadierCommand(name: String) : ConfigurableCommandNode<CommandSourceStack>(name) {
    protected abstract fun command()

    internal fun create(): DSLCommand<CommandSourceStack> {
        return createCommand(name) {
            command()
        }
    }
}
