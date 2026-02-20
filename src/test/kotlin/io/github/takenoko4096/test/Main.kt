package io.github.takenoko4096.test

import io.github.takenoko4096.dslbrigadier.DSLCommandDispatcher

class CommandSourceStack

val commands = DSLCommandDispatcher<CommandSourceStack>()

fun main() {
    println("Hello, world!")

    val dataCommand = commands.build("data") {
        "modify" {
            "entity" {
                "selector"(string()) {
                    executes {
                        println("data modify entity ${"selector"[String::class]}")
                    }
                }
            }
        }
    }

    commands.registration {
        + dataCommand

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
                            this.context
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

    println(commands.execute("data modify entity self", CommandSourceStack()))
}
