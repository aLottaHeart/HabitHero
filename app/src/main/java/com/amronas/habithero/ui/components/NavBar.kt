package com.amronas.habithero.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.amronas.habithero.data.TestDataProvider
import com.amronas.habithero.ui.screens.HomeScreen
import com.amronas.habithero.ui.themes.heroTheme.HabitHeroTheme

enum class Destinations(val route: String, val icon: ImageVector, val title: String) {
    Home("home", Icons.Default.Home, "Home"),
    Dashboard("dashboard", Icons.Default.DateRange, "Dashboard"),
    Achievements("achievements", Icons.Default.Star, "Achievements");
}

@Composable
fun NavBar(
    modifier: Modifier = Modifier
) {
    var selectedDestination by remember { mutableStateOf(Destinations.Home) }

    NavigationBar(modifier = modifier.fillMaxWidth()) {
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

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    HabitHeroTheme {
        NavBar()
    }
}