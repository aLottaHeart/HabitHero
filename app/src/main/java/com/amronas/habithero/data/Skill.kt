package com.amronas.habithero.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Skill(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val frequencyValue: Int,
    val frequencyUnit: FrequencyUnit
) {
    fun frequencyUnitToString(): String {
        return frequencyUnit.frequencyToString(frequencyValue)
    }

    fun frequencyToString(): String {
        return frequencyUnit.frequencyToString(frequencyValue)
    }
}

enum class FrequencyUnit {
    DAY, WEEK, MONTH;

    fun frequencyUnitToString(frequencyValue: Int): String {
        return when (this) {
            DAY -> "day"
            WEEK -> "week"
            MONTH -> "month"
        }
    }

    fun frequencyToString(frequencyValue: Int): String {
        return when (this) {
            DAY -> "${if (frequencyValue > 1) "$frequencyValue times" else "once"} per day"
            WEEK -> "${if (frequencyValue > 1) "$frequencyValue times" else "once"} per week"
            MONTH -> "${if (frequencyValue > 1) "$frequencyValue times" else "once"} per month"
        }
    }
}