package io.github.takenoko4096.test

import com.mojang.brigadier.CommandDispatcher
import io.github.takenoko4096.dslbrigadier.command
import io.github.takenoko4096.dslbrigadier.registration

class CommandSourceStack {
    fun isOp(): Boolean = true
}

val dispatcher = CommandDispatcher<CommandSourceStack>()

val greetCommand = command<CommandSourceStack>("greet") {
    "to" {
        "name"(word()) {
            executes {
                println("hello to ${"name"[String::class]}!")
                returns = 1
            }
        }
    }

    "from" {
        "place"(string()) {
            executes {
                println("hello from ${"place"[String::class]}!")
                returns = 1
            }
        }
    }

    executes {
        println("hello, world!")
        returns = 1
    }
}

fun main() {
    println("Hello, world!")

    dispatcher.registration {
        "calculate" command {
            requires { isOp() }

            "add" {
                "x"(integer(1..2)) {
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
                returns = 1
            }
        }

        + greetCommand
    }

    // 5
    println(dispatcher.execute("calculate add 2 3", CommandSourceStack()))

    // hello to Brigadier!
    dispatcher.execute("greet to brigadier", CommandSourceStack())
}
