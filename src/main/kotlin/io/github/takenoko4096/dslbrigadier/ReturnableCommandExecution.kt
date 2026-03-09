package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.context.CommandContext
import kotlin.reflect.KClass

@BrigadierDSL
class ReturnableCommandExecution<S>(context: CommandContext<S>) : AbstractCommandExecution<S>(context) {

}
