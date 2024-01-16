package com.amronas.habithero.data

import androidx.lifecycle.LiveData

interface DatabaseInterface {
    fun getAllSkills(): LiveData<List<Skill>>
}
