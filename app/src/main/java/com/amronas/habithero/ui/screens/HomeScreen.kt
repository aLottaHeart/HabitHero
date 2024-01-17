package com.amronas.habithero.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.components.AddButton
import com.amronas.habithero.ui.components.SkillList
import com.amronas.habithero.ui.themes.darkTheme.DarkTheme

@Composable
fun HomeScreen(skills: List<Skill>, navController: NavController) {
    Surface {
        Scaffold(
            topBar = { TopBar() },
            floatingActionButton = { AddButton(onClick = { navController.navigate("addSkillScreen") }) }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
            ) {
                SkillList(skills)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar() {
    TopAppBar(
        title = { Text("Your skills") },
    )
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    DarkTheme {
        HomeScreen(skills = TestDataProvider.getExampleSkills(), navController = NavController(LocalContext.current))
    }
}