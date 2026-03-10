package io.github.takenoko4096.dslbrigadier.execution

import com.mojang.brigadier.context.CommandContext
import io.github.takenoko4096.dslbrigadier.execution.AbstractCommandExecution
import io.github.takenoko4096.dslbrigadier.BrigadierDSL

@BrigadierDSL
class PaperCommandExecution<S>(context: CommandContext<S>) : AbstractCommandExecution<S>(context) {
    var returns: Int = 1
}