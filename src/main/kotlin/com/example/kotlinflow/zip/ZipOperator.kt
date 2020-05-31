package com.example.kotlinflow.zip

import com.example.kotlinflow.getIngredients
import com.example.kotlinflow.getUnitValues
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val job = launch {
        getUnitValues()
            .zip(getIngredients()) { unit, ingredient ->
                "$unit $ingredient"
            }
            .collect { println(it) }
    }
    job.join()
}
