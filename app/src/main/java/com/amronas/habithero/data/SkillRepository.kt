package com.amronas.habithero.data

import androidx.lifecycle.LiveData

class SkillRepository(private val skillDao: SkillDao) {
    val allSkills: LiveData<List<Skill>> = skillDao.getAllSkills()

    suspend fun insert(skill: Skill) {
        skillDao.insertSkill(skill)
    }
}
