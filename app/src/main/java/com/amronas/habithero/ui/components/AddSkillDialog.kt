package com.amronas.habithero.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.amronas.habithero.data.FrequencyUnit
import com.amronas.habithero.data.Skill

@Composable
fun AddSkillDialog(
    showDialog: MutableState<Boolean>,
    onAddSkill: (Skill) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("") }
    var frequencyUnit by remember { mutableStateOf(FrequencyUnit.DAY) }
    var showDropdownMenu by remember { mutableStateOf(false) }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Add New Skill") },
            text = {
                Column {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") }
                    )
                    TextField(
                        value = frequency,
                        onValueChange = { frequency = it },
                        label = { Text("Frequency") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Box {
                        TextField(
                            value = frequencyUnit.name,
                            onValueChange = { },
                            label = { Text("Frequency Unit") },
                            readOnly = true,
                            trailingIcon = { Icon(Icons.Filled.ArrowDropDown, "dropdown") },
                            modifier = Modifier.clickable { showDropdownMenu = true }
                        )
                        DropdownMenu(
                            expanded = showDropdownMenu,
                            onDismissRequest = { showDropdownMenu = false }
                        ) {
                            FrequencyUnit.entries.forEach { unit ->
                                DropdownMenuItem(
                                    onClick = { showDropdownMenu = false },
                                    text = { Text(text = unit.name) }
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(onClick = {
                    val newSkill = Skill(
                        name = name,
                        frequencyValue = frequency.toIntOrNull() ?: 0,
                        frequencyUnit = frequencyUnit
                    )
                    onAddSkill(newSkill)
                    showDialog.value = false
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
