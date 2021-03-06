package com.example.kotlinflow.mapoperator

import com.example.kotlinflow.flowingRiver
import com.example.kotlinflow.pollutionByWeThePeople
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val job = launch {
        flowingRiver()
            .map { pollutionByWeThePeople() }
            .collect { value -> println("Drop of salty water $value") }
    }
    delay(3000)
    job.cancel()
}