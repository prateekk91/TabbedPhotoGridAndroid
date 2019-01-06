package com.kotlin.workshop.tabbedphotogrid

import java.io.Serializable
import kotlin.random.Random

sealed class PhotoSource(val name: String, val type: String) : Serializable {

    private var height = 0
    private var width = 0
    private var url = ""
    private var counter = 0

    fun getNext() : Photo {
        counter++
        height = Random.nextInt(3, 6 ) * 50
        width = Random.nextInt(3, 6 ) * 50
        url = "https://loremflickr.com/$width/$height/$type?random=$counter"
        return Photo(height, width, url)
    }

    class Dogs : PhotoSource(name = "Dogs", type = "dog")

    class Cats : PhotoSource(name = "Cats", type = "cat")

    class Ducks : PhotoSource(name = "Ducks", type = "duck")

    class Rabbits : PhotoSource(name = "Rabbits", type = "rabbit")
}