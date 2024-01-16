package com.amronas.habithero.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.components.AddButton
import com.amronas.habithero.ui.components.NavBar
import com.amronas.habithero.ui.components.SkillsList
import com.amronas.habithero.ui.themes.heroTheme.HabitHeroTheme
import com.amronas.habithero.ui.themes.theme.StandardTheme

@Composable
fun HomeScreen(skills: List<Skill>, onAddButtonClick: () -> Unit) {
    StandardTheme {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    SkillsList(skills)
                    Spacer(modifier = Modifier.weight(1f))
                    AddButton(
                        modifier = Modifier.align(Alignment.End).padding(16.dp),
                        onClick = { onAddButtonClick() })
                    NavBar()
                }
            }
        }
    }
}


@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainPreview() {
    HabitHeroTheme {
        HomeScreen(skills = TestDataProvider.getExampleSkills(), onAddButtonClick = { })
    }
}