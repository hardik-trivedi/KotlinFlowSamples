package com.example.kotlinflow.buffer

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis
//TODO Remove slide number
fun main() = runBlocking {
    val timeTaken = measureTimeMillis {
        downloadVideo()
            .collect {
                println("Downloading video $it%")
                delay(1000)
            }
    }
    println("====== Total time to execute is $timeTaken ======")

    val timeTakenWithBuffer = measureTimeMillis {
        downloadVideo()
            .buffer()
            .collect {
                println("Downloading video $it%")
                delay(1000)
            }
    }

    println("====== Total time to execute is $timeTakenWithBuffer ======")
}


fun downloadVideo(): Flow<Int> = flow {
    emit(20)
    delay(1000)
    emit(50)
    delay(1000)
    emit(80)
    delay(1000)
    emit(100)
    delay(1000)
}