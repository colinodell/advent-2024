package com.colinodell.advent2024

import java.io.File
import java.net.URI

internal object Inputs {
    fun inputAsText(fileName: String): String = File(fileName.toURI()).readText().trimEnd('\n')

    fun inputAsListOfString(fileName: String): List<String> = File(fileName.toURI()).readLines()

    private fun String.toURI(): URI =
        Inputs.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")
}
