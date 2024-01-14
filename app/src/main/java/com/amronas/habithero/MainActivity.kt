package com.amronas.habithero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amronas.habithero.ui.heroTheme.HabitHeroTheme
import com.amronas.habithero.ui.theme.StandardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitHeroTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column {
                        Greeting("Android", Modifier.align(Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.weight(1f))
                        AddButton(modifier = Modifier
                            .align(Alignment.End)
                            .padding(16.dp))
                        NavBar()
                    }
                }
            }
        }
    }
}

enum class Destinations(val route: String, val icon: ImageVector, val title: String) {
    Home("home", Icons.Default.Home, "Home"),
    Dashboard("dashboard", Icons.Default.DateRange, "Dashboard"),
    Achievements("achievements", Icons.Default.Star, "Achievements");
}

@Composable
fun NavBar() {
    var selectedDestination by remember { mutableStateOf(Destinations.Home) }

    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        Destinations.entries.forEach { destination ->
            NavigationBarItem(
                selected = selectedDestination == destination,
                onClick = { selectedDestination = destination },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.title
                    )
                },
                label = { Text(text = destination.title) }
            )
        }
    }
}

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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(24.dp),
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    StandardTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column {
                Greeting("Android", Modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.weight(1f))
                AddButton(modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp))
                NavBar()
            }
        }
    }
}
