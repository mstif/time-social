package ru.netology


fun main() {
    val countSec = 5;
    println("был(а) в сети ${agoToText(countSec)}")
    println("был(а) в сети ${agoToText(61)}")
    println("был(а) в сети ${agoToText(120)}")
    println("был(а) в сети ${agoToText(60 * 60 * 5)}")
    println("был(а) в сети ${agoToText(60 * 60 * 24 + 1)}")
    println("был(а) в сети ${agoToText(60 * 60 * 24 * 2 + 1)}")
    println("был(а) в сети ${agoToText(60 * 60 * 24 * 3 + 1)}")
    
}

fun agoToText(countSec: Int): String {
    return when (countSec) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> {
            "${periodToString(countSec / 60, TimeUnit.Minutes)} назад"
        }
        in 60 * 60 + 1..24 * 60 * 60 -> {
            "${periodToString(countSec / (60 * 60), TimeUnit.Hours)} назад"
        }
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> {
            "сегодня"
        }
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> {
            "вчера"
        }
        else -> "давно"
    }
}

enum class TimeUnit {
    Minutes,
    Hours
}


fun periodToString(countUnits: Int, unit: TimeUnit): String {
    val lastDigit: Int = countUnits % 10
    return "$countUnits " + when (unit) {
        TimeUnit.Minutes -> when (lastDigit) {
            0, 5, 6, 7, 8, 9 -> "минут"
            1 -> "минута"
            2, 3, 4 -> "минуты"
            else -> ""
        }
        TimeUnit.Hours -> when (lastDigit) {
            0, 5, 6, 7, 8, 9 -> "часов"
            1 -> "час"
            2, 3, 4 -> "часа"
            else -> ""
        }

    }
}






