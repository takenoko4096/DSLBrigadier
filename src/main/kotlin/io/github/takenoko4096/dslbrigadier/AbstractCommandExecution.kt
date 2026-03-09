package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.context.CommandContext
import kotlin.reflect.KClass

@BrigadierDSL
abstract class AbstractCommandExecution<S>(val context: CommandContext<S>) {
    operator fun <T : Any> String.get(clazz: KClass<T>): T {
        return context.getArgument(this, clazz.java)
    }
}
