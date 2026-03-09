package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.builder.LiteralArgumentBuilder

class UnbuiltDSLCommand<S>(val name: String) : DSLCommandNode<S>(LiteralArgumentBuilder.literal<S>(name)) {
    var description: String = ""

    var aliases: MutableSet<String> = mutableSetOf()

    companion object {
        internal fun <S> createCommand(name: String, builder: UnbuiltDSLCommand<S>.() -> Unit): DSLCommand<S> {
            val node = UnbuiltDSLCommand<S>(name)
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
