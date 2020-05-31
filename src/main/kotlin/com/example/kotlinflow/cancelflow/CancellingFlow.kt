package com.example.kotlinflow.cancelflow

import com.example.kotlinflow.flowingRiver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(3000) {
        flowingRiver().collect { value -> println("Drop of $value") }
    }
}

/*fun main() = runBlocking {
    val job = launch {
        flowingRiver().collect { value -> println("Drop of $value") }
    }
    delay(3000)
    job.cancel()
}*/


