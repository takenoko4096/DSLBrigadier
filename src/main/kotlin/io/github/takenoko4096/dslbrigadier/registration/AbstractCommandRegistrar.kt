package io.github.takenoko4096.dslbrigadier.registration

import io.github.takenoko4096.dslbrigadier.BrigadierDSL
import io.github.takenoko4096.dslbrigadier.DSLCommand
import io.github.takenoko4096.dslbrigadier.node.ConfigurableCommandNode

@BrigadierDSL
abstract class AbstractCommandRegistrar<R, S> internal constructor(protected val registrar: R) {
    abstract infix fun String.command(builder: ConfigurableCommandNode<S>.() -> Unit)

    abstract operator fun DSLCommand<S>.unaryPlus()
}