package com.amronas.habithero.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Skill(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val frequencyValue: Int,
    val frequencyUnit: FrequencyUnit
)

enum class FrequencyUnit { DAY, WEEK, MONTH }