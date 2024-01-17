package com.amronas.habithero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amronas.habithero.data.LocalDatabase
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.SkillRepository
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.components.NavBar
import com.amronas.habithero.ui.screens.CreateSkillScreen
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
            val skills by skillViewModel.allSkills.observeAsState(initial = emptyList())

            AppContent(
                skills = skills,
                onAddSkill = { skillViewModel.insert(it) }
            )
        }
    }
}

@Composable
fun AppContent(
    skills: List<Skill>,
    onAddSkill: (Skill) -> Unit
) {
    val navController = rememberNavController()

    DarkTheme {
        Scaffold(
            bottomBar = { BottomAppBar { NavBar() } }
        ) { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = "homeScreen"
            ) {
                composable("homeScreen") {
                    HomeScreen(skills = skills, navController = navController)
                }
                composable("addSkillScreen") {
                    CreateSkillScreen(onAddSkill = onAddSkill, navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    AppContent(
        skills = TestDataProvider.getExampleSkills(),
        onAddSkill = { }
    )
}