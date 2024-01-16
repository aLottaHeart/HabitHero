package com.amronas.habithero.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amronas.habithero.data.Skill
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.screens.HomeScreen
import com.amronas.habithero.ui.themes.heroTheme.HabitHeroTheme

@Composable
fun SkillsList(skills: List<Skill>) {
    LazyColumn {
        items(skills) { skill ->
            SkillItem(skill)
        }
    }
}

@Composable
fun SkillItem(skill: Skill) {
    ListItem(
        headlineContent = { Text(skill.name) },
        supportingContent = { Text(skill.frequencyToString()) },
        trailingContent = { Text("+40", color = Color.Green) },
        leadingContent = {
            Icon(
                Icons.Filled.FavoriteBorder,
                contentDescription = "Localized description",
            )
        }
    )
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListPreview() {
    HabitHeroTheme {
        HomeScreen(skills = TestDataProvider.getExampleSkills(), onAddButtonClick = { })
    }
}