package com.amronas.habithero.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.SkillRepository
import kotlinx.coroutines.launch

class SkillViewModel(private val repository: SkillRepository) : ViewModel() {
    val allSkills: LiveData<List<Skill>> = repository.allSkills

    fun insert(skill: Skill) = viewModelScope.launch {
        repository.insert(skill)
    }
}

class SkillViewModelFactory(private val repository: SkillRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SkillViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SkillViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}