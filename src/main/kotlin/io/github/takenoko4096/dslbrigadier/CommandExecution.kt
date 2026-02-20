package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.context.CommandContext
import kotlin.reflect.KClass

@BrigadierDSL
class CommandExecution<S>(val context: CommandContext<S>) {
    var returns: Int = 1

    operator fun <T : Any> String.get(clazz: KClass<T>): T {
        return context.getArgument(this, clazz.java)
    }
}
