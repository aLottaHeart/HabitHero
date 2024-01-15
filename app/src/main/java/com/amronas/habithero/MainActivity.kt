package com.amronas.habithero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amronas.habithero.ui.components.AddButton
import com.amronas.habithero.ui.components.NavBar
import com.amronas.habithero.ui.themes.heroTheme.HabitHeroTheme
import com.amronas.habithero.ui.themes.theme.StandardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitHeroTheme {
                BasicAppScreen()
            }
        }
    }
}

@Composable
fun BasicAppScreen() {
    StandardTheme {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
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

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    StandardTheme {
        BasicAppScreen()
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