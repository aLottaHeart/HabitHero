package com.amronas.habithero.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSkillScreen(
    onAddSkill: (Skill) -> Unit,
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }
    var frequencyUnit by remember { mutableStateOf(FrequencyUnit.DAY) }
    var showDropdownMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Skill") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                singleLine = true,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = frequency,
                singleLine = true,
                onValueChange = { frequency = it },
                label = { Text("Frequency") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            SingleChoiceSegmentedButtonRow {
                FrequencyUnit.entries.forEach { unit ->
                    SegmentedButton(
                        selected = frequencyUnit == unit,
                        onClick = { frequencyUnit = unit },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = FrequencyUnit.entries.indexOf(unit),
                            count = FrequencyUnit.entries.size
                        ))
                    {
                        Text(text = unit.name)
                    }
                }
            }

            Button(onClick = {
                val newSkill = Skill(
                    name = name,
                    frequencyValue = frequency.toIntOrNull() ?: 0,
                    frequencyUnit = frequencyUnit
                )
                onAddSkill(newSkill)
                navController.popBackStack()
            }) {
                Text("Add")
            }
        }
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