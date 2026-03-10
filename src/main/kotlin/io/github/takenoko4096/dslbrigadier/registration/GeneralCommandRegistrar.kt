package io.github.takenoko4096.dslbrigadier.registration

import com.mojang.brigadier.CommandDispatcher
import io.github.takenoko4096.dslbrigadier.registration.AbstractCommandRegistrar
import io.github.takenoko4096.dslbrigadier.DSLCommand
import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode

class GeneralCommandRegistrar<S>(dispatcher: CommandDispatcher<S>) : AbstractCommandRegistrar<CommandDispatcher<S>, S>(dispatcher) {
    override infix fun String.command(builder: ConfigurableCommandNode<S>.() -> Unit) {
        registrar.register(ConfigurableCommandNode.createCommand(this, builder).literalArgumentBuilder)
    }

    override operator fun DSLCommand<S>.unaryPlus() {
        registrar.register(literalArgumentBuilder)
    }
}
