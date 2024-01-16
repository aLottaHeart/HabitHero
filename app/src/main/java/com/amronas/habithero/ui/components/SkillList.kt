package com.amronas.habithero.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amronas.habithero.data.Skill

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
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = skill.name, style = MaterialTheme.typography.bodySmall)
            Spacer(Modifier.weight(1f))
            Text(text = skill.frequencyValue.toString(), style = MaterialTheme.typography.bodySmall)
            Spacer(Modifier.weight(1f))
            Text(text = skill.frequencyUnit.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}
