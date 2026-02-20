# DSLBrigadier

[brigadier](https://github.com/Mojang/brigadier) のラッパー (Kotlin) DSL

## Usage

### コマンドの登録: `CommandDispatcher<S>::registration()`

```kotlin
import com.mojang.brigadier.CommandDispatcher
import io.github.takenoko4096.dslbrigadier.registration

class CommandSourceStack {
    fun isOp(): Boolean = true
}

val dispatcher = CommandDispatcher<CommandSourceStack>()

fun main() {
    // コマンドノードツリーを組み立ててそのまま登録
    dispatcher.registration {
        // コマンド名は calculate
        "calculate" command {
            // コマンドの実行に必要な条件を記述
            requires { isOp() }

            // サブコマンド add
            "add" {
                // integer() = IntegerArgumentType.integer()
                "x"(integer()) {
                    "y"(integer()) {
                        executes {
                            // String[Class<T>] = CommandContext::getArgument(String, Class<T>)
                            // returnsに最後に代入された値が戻り値になる (Kotlinのラムダ内returnってラベル付けなきゃいけないの読み辛くない？)
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
        }
    }

    // 5
    println(dispatcher.execute("calculate add 2 3", CommandSourceStack()))
}
```

### リテラルノードツリーを `registration` の外部で定義する: `command()`

```kotlin
import com.mojang.brigadier.CommandDispatcher
import io.github.takenoko4096.dslbrigadier.registration
import io.github.takenoko4096.dslbrigadier.command

class CommandSourceStack {
    fun isOp(): Boolean
}

val dispatcher = CommandDispatcher<CommandSourceStack>()

// コマンドノードツリーを外部で定義
val greetCommand = command<CommandSourceStack>("greet") {
    "to" {
        "name"(word()) {
            executes {
                println("hello to ${"name"[String::class]}!")
                // ちなみに returns の指定なしは 1 になる
            }
        }
    }

    "from" {
        "place"(string()) {
            executes {
                println("hello from ${"place"[String::class]}!")
            }
        }
    }
    
    executes {
        println("hello, world!")
    }
}

fun main() {
    dispatcher.registration {
        // コマンドの登録
        +greetCommand
    }

    // hello to Brigadier!
    dispatcher.execute("greet to brigadier", CommandSourceStack())
}
```
