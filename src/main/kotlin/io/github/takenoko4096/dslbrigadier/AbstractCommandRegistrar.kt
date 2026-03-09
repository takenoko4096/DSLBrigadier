package io.github.takenoko4096.dslbrigadier

@BrigadierDSL
abstract class AbstractCommandRegistrar<R, S> internal constructor(protected val registrar: R) {
    abstract infix fun String.command(builder: UnbuiltDSLCommand<S>.() -> Unit)

    abstract operator fun DSLCommand<S>.unaryPlus()
}
