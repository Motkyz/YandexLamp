package com.example.lesson7.data

import android.graphics.Color
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.graphics.toColorInt

object ColorParser {
    private val colorDictionary = mapOf(
        "red" to Color.RED,
        "green" to Color.GREEN,
        "blue" to Color.BLUE,
        "white" to Color.WHITE,
        "black" to Color.BLACK,
        "yellow" to Color.YELLOW,
        "teal" to "#008080".toColorInt(),
        "brown" to "#A52A2A".toColorInt(),
        "coral" to "#FF7F50".toColorInt(),
        "cyan" to "#00FFFF".toColorInt(),
        "gold" to "#FFD700".toColorInt(),
        "indigo" to "#4B0082".toColorInt(),
        "maroon" to "#800000".toColorInt(),
        "mediumpurple" to "#9370DB".toColorInt(),
        "pink" to "#FFC0CB".toColorInt(),
        "peru" to "#CD853F".toColorInt(),
        "seagreen" to "#2E8B57".toColorInt(),
        "slateblue" to "#6A5ACD".toColorInt(),
        "tomato" to "#FF6347".toColorInt(),
        "purple" to "#800080".toColorInt()
    )

    fun parseColor(color: String, brightness: Int = 100): Int {
        var color = colorDictionary.getOrDefault(color, Color.WHITE)
        val alpha = 255 / 100 * brightness
        return Color.argb(
            alpha,
            color.red,
            color.green,
            color.blue
        )
    }
}