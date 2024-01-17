package com.amronas.habithero.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amronas.habithero.data.FrequencyUnit
import com.amronas.habithero.data.Skill
import com.amronas.habithero.ui.themes.darkTheme.DarkTheme

@Composable
fun CreateSkillScreen(onAddSkill: (Skill) -> Unit, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }
    var frequencyUnit by remember { mutableStateOf(FrequencyUnit.DAY) }

    Scaffold(topBar = { TopBar(navController) }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Find a short name for your skill")
            Spacer(modifier = Modifier.padding(top = 7.dp))
            name = nameInputField(name)
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Text(text = "How often do you want to practice this skill?")
            Spacer(modifier = Modifier.padding(top = 7.dp))
            frequency = frequencyValueInputField(frequency)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "...times each...")
            Spacer(modifier = Modifier.padding(top = 7.dp))
            frequencyUnit = frequencyUnitInputField(frequencyUnit)

            Spacer(modifier = Modifier.padding(top = 16.dp))
            AddButton(name, frequency, frequencyUnit, onAddSkill, navController)
        }
    }
}

@Composable
private fun nameInputField(name: String): String {
    var name1 = name
    OutlinedTextField(
        value = name1,
        singleLine = true,
        onValueChange = { name1 = it },
        label = { Text("Name") },
        modifier = Modifier.fillMaxWidth()
    )
    return name1
}

@Composable
private fun frequencyValueInputField(frequency: String): String {
    var frequency1 = frequency
    OutlinedTextField(
        value = frequency1,
        singleLine = true,
        onValueChange = { frequency1 = it },
        label = { Text("Frequency") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
    return frequency1
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun frequencyUnitInputField(frequencyUnit: FrequencyUnit): FrequencyUnit {
    var frequencyUnit1 = frequencyUnit
    SingleChoiceSegmentedButtonRow {
        FrequencyUnit.entries.forEach { unit ->
            SegmentedButton(
                selected = frequencyUnit1 == FrequencyUnit.WEEK,
                onClick = { frequencyUnit1 = unit },
                shape = SegmentedButtonDefaults.itemShape(
                    index = FrequencyUnit.entries.indexOf(unit),
                    count = FrequencyUnit.entries.size
                )
            )
            {
                Text(text = unit.name)
            }
        }
    }
    return frequencyUnit1
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(navController: NavController) {
    TopAppBar(
        title = { Text("Add New Skill") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back"
                )
            }
        }
    )
}

@Composable
private fun AddButton(
    name: String,
    frequency: String,
    frequencyUnit: FrequencyUnit,
    onAddSkill: (Skill) -> Unit,
    navController: NavController
) {
    Button(
        modifier = Modifier.fillMaxWidth(0.5f),
        shape = MaterialTheme.shapes.large,
        elevation = ButtonDefaults.buttonElevation(),
        onClick = {
            val newSkill = Skill(
                name = name,
                frequencyValue = frequency.toIntOrNull() ?: 0,
                frequencyUnit = frequencyUnit
            )
            onAddSkill(newSkill)
            navController.popBackStack()
        }
    ) {
        Text("Add")
    }
}


@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CreateSkillScreenPreview() {
    DarkTheme {
        CreateSkillScreen(
            onAddSkill = {},
            navController = NavController(LocalContext.current)
        )
    }
}