package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.builder.LiteralArgumentBuilder

class DSLCommand<S> internal constructor(internal val literalArgumentBuilder: LiteralArgumentBuilder<S>)
