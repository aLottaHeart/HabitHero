package com.amronas.habithero.data

object TestDataProvider {
    fun getExampleSkills(): List<Skill> {
        return listOf(
            Skill(name = "Reading", frequencyValue = 1, frequencyUnit = FrequencyUnit.DAY),
            Skill(id = 2, name = "Exercise", frequencyValue = 3, frequencyUnit = FrequencyUnit.WEEK),
        )
    }
}