package com.amronas.habithero.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SkillDao {
    @Query("SELECT * FROM skill")
    fun getAllSkills(): LiveData<List<Skill>>

    @Insert
    suspend fun insertSkill(skill: Skill)
}