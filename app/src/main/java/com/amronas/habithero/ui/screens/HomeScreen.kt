package com.amronas.habithero.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.components.AddButton
import com.amronas.habithero.ui.components.NavBar
import com.amronas.habithero.ui.components.SkillsList
import com.amronas.habithero.ui.themes.heroTheme.HabitHeroTheme
import com.amronas.habithero.ui.themes.theme.StandardTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(skills: List<Skill>, onAddButtonClick: () -> Unit) {
    StandardTheme {
        Surface {
            Scaffold(
                topBar = { TopAppBar(title = { Text("Top app bar") }) },
                bottomBar = { BottomAppBar { NavBar() } },
                floatingActionButton = { AddButton(onClick = { onAddButtonClick() }) }
            ) { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding),
                ) {
                    SkillsList(skills)
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    HabitHeroTheme {
        HomeScreen(skills = TestDataProvider.getExampleSkills(), onAddButtonClick = { })
    }
}