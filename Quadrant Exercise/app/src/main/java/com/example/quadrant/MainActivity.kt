package com.example.quadrant

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Quadrant4Screen()
                }
            }
        }
    }
}

@Composable
fun Quadrant4Screen() {
    Column (modifier = Modifier.fillMaxSize()) {
        Row (modifier = Modifier.weight(1f)) {
            QuadrantBox(
                title = stringResource(R.string.top_left_title_txt),
                desc = stringResource(R.string.top_left_desc_txt),
                bgColor = colorResource(id = R.color.top_left),
                modifier = Modifier.weight(1f)

            )
            QuadrantBox(
                title = stringResource(R.string.top_right_title_txt),
                desc = stringResource(R.string.top_right_desc_txt),
                bgColor = colorResource(id = R.color.top_right),
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            QuadrantBox(
                title = stringResource(R.string.bot_left_title_txt),
                desc = stringResource(R.string.bot_left_desc_txt),
                bgColor = colorResource(id = R.color.bot_left),
                modifier = Modifier.weight(1f)
            )
            QuadrantBox(
                title = stringResource(R.string.bot_right_title_txt),
                desc = stringResource(R.string.bot_right_desc_txt),
                bgColor = colorResource(id = R.color.bot_right),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantBox(title: String, desc: String, bgColor: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = desc,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Quadrant")
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        Quadrant4Screen()
    }
}