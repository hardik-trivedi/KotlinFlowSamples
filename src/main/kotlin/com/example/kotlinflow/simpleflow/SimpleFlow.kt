package com.example.kotlinflow.simpleflow

import com.example.kotlinflow.flowingRiver
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    flowingRiver()
        .collect { value ->
            println("Drop of $value")
        }
}
