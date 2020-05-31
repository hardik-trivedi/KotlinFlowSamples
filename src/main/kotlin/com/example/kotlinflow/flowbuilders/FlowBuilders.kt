package com.example.kotlinflow.flowbuilders

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val programmingLanguages = listOf("COBOL", "C", "C++", "Java", "C#", "Kotlin", "Swift")

    // Lambda style function
    flow {
        emit(programmingLanguages)
    }

    programmingLanguages
        .asFlow() // Extension function over Iterable<T>
        .collect { println(it) }

    flowOf(programmingLanguages) // Creates Flow for any type T
        .collect { println(it) }
}