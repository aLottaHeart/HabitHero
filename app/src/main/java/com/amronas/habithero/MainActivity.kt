package com.amronas.habithero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.amronas.habithero.data.LocalDatabase
import com.amronas.habithero.data.SkillRepository
import com.amronas.habithero.ui.components.AddSkillDialog
import com.amronas.habithero.ui.screens.HomeScreen
import com.amronas.habithero.ui.themes.darkTheme.DarkTheme
import com.amronas.habithero.viewmodel.SkillViewModel
import com.amronas.habithero.viewmodel.SkillViewModelFactory

class MainActivity : ComponentActivity() {
    private val skillViewModel: SkillViewModel by viewModels {
        SkillViewModelFactory(SkillRepository(LocalDatabase.getDatabase(this).skillDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DarkTheme {
                val showDialog = remember { mutableStateOf(false) }
                val skills by skillViewModel.allSkills.observeAsState(initial = emptyList())

                AddSkillDialog(
                    showDialog = showDialog,
                    onAddSkill = { skill ->
                        skillViewModel.insert(skill)
                    }
                )

                HomeScreen(
                    skills = skills,
                    onAddButtonClick = { showDialog.value = true }
                )
            }
        }
    }
}