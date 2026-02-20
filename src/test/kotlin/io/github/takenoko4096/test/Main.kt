package io.github.takenoko4096.test

import io.github.takenoko4096.dslbrigadier.DSLCommandDispatcher

class CommandSourceStack

object Commands : DSLCommandDispatcher<CommandSourceStack>()

fun main() {
    println("Hello, world!")

    Commands {
        "calc" command {
            requires {
                true
            }

            "add" {
                "x"(integer()) {
                    "y"(integer()) {
                        executes {
                            returns = "x"[Int::class] + "y"[Int::class]
                        }
                    }
                }
            }

            "subtract" {
                "x"(integer()) {
                    "y"(integer()) {
                        executes {
                            returns = "x"[Int::class] - "y"[Int::class]
                        }
                    }
                }
            }

            executes {
                returns = 0
            }
        }
    }

    println(Commands.execute("calc subtract 7 2", CommandSourceStack()))
}
