package com.amronas.habithero.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.amronas.habithero.R

@Composable
fun AddButton(modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        onClick = { /*..*/ },
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.action_add),
        )
    }
}