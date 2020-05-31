package com.example.kotlinflow.oncompletion

import com.example.kotlinflow.flowingRiver
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val damCapacity = 50;
    var waterLevel = 0

    flowingRiver()
        .onStart { println("River flowing") }
        .onEach {
            check(waterLevel <= damCapacity) { "Dam capacity reached" }
            println("Water level ${waterLevel++}")
        }
        .onCompletion { cause ->
            cause?.let { println("The dam is full") } ?: println("River is empty but the dam is not full")
        }
        .catch { e -> println("!!! ALERT !!! : ${e.message}") }
        .collect()
}

fun usingImperativeApproach() = runBlocking {
    val damCapacity = 50;
    var waterLevel = 0

    try {
        flowingRiver()
            .onStart { println("River flowing") }
            .onEach {
                check(waterLevel <= damCapacity) { "Dam capacity reached" }
                println("Water level ${waterLevel++}")
            }
            .collect()
    }
    catch (e: Exception) { println("!!! ALERT !!! : ${e.message}") }
    finally { println("The dam is full") }
}