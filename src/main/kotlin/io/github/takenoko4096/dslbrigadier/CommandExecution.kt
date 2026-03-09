package io.github.takenoko4096.dslbrigadier

import com.mojang.brigadier.context.CommandContext

@BrigadierDSL
class CommandExecution<S>(context: CommandContext<S>) : AbstractCommandExecution<S>(context) {
    var returns: Int = 1
}
