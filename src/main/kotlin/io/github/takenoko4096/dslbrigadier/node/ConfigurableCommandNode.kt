package io.github.takenoko4096.dslbrigadier.node

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import io.github.takenoko4096.dslbrigadier.DSLCommand
import io.github.takenoko4096.dslbrigadier.node.DSLCommandNode

open class ConfigurableCommandNode<S>(val name: String) : DSLCommandNode<S>(LiteralArgumentBuilder.literal<S>(name)) {
    open var description: String = ""

    open var aliases: Set<String> = setOf()

    companion object {
        internal fun <S> createCommand(name: String, builder: ConfigurableCommandNode<S>.() -> Unit): DSLCommand<S> {
            val node = ConfigurableCommandNode<S>(name)
            node.builder()
            return DSLCommand(
                node.argumentBuilder as LiteralArgumentBuilder<S>,
                node.name,
                node.description,
                node.aliases
            )
        }
    }
}
