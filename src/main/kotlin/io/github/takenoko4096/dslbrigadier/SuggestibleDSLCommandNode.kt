package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.builder.RequiredArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.Suggestions
import com.mojang.brigadier.suggestion.SuggestionsBuilder
import java.util.concurrent.CompletableFuture

@BrigadierDSL
class SuggestibleDSLCommandNode<S, T>(override val argumentBuilder: RequiredArgumentBuilder<S, T>) : DSLCommandNode<S>(argumentBuilder) {
    private var suggested = false

    fun suggests(callback: DSLSuggestionProvider<S>.() -> CompletableFuture<Suggestions>) {
        if (suggested) throw IllegalArgumentException("block 'suggests' is duplicating; do not use suggests more than once in same block")
        suggested = true
        argumentBuilder.suggests { context, builder ->
            DSLSuggestionProvider(context, builder).callback()
        }
    }

    class DSLSuggestionProvider<S> internal constructor(
        val context: CommandContext<S>,
        val builder: SuggestionsBuilder
    ) {
        fun suggestWithUserInputFilter(vararg values: String) {
            values
                .filter { it.lowercase().startsWith(builder.remainingLowerCase) }
                .forEach(builder::suggest)
        }
    }
}
