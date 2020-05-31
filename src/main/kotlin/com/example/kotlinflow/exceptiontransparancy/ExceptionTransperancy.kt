package com.example.kotlinflow.exceptiontransparancy

import com.example.kotlinflow.flowingRiver
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/*fun main() = runBlocking {
    val damCapacity = 50; var waterLevel = 0

    flowingRiver()
        .onEach {
            check(waterLevel <= damCapacity) { "Dam capacity reached" }
        }
        .catch { e -> println("!!! ALERT !!! : ${e.message}") }
        .collect {
            println("Water level ${waterLevel++}")
        }
}*/

fun main() = runBlocking {
    val damCapacity = 50; var waterLevel = 0

    flowingRiver()
        .onEach {
            check(waterLevel <= damCapacity) { "Dam capacity reached" }
            println("Water level ${waterLevel++}")
        }
        .catch { e -> println("!!! ALERT !!! : ${e.message}") }
        .collect()
}