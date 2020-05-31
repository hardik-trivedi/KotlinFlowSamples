package com.example.kotlinflow.filteroperator

import com.example.kotlinflow.flowingRiver
import com.example.kotlinflow.pollutionByWeThePeople
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val job = launch {
        flowingRiver()
            .map {
                println("Water is getting polluted")
                pollutionByWeThePeople()
            }
            .filter {
                println("Potential of Hydrogens ${it.pH} PH")
                it.pH >= 7
            }
            .collect { value -> println("Drop of drinkable water $value") }
    }
    delay(10000)
    job.cancel()
}
