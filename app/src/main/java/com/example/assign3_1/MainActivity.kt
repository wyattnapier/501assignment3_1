package com.example.assign3_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assign3_1.ui.theme.Assign3_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign3_1Theme {
                Scaffold( modifier = Modifier.fillMaxWidth() ) { innerPadding ->
                    WeightModifiedRowScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WeightModifiedRowScreen(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
    ) {
        WeightModifiedColumn(
            backgroundColor = Color.Red,
            textInput = "Red - 25%",
            modifier = Modifier.weight(25f)
        )
        WeightModifiedColumnWithChildren(
            modifier = Modifier.weight(75f)
        )

    }
}

@Composable
fun RowScope.WeightModifiedColumn(backgroundColor: Color, textInput: String, modifier: Modifier = Modifier) {
    // modifier includes the weight
    Box(modifier = modifier
        .fillMaxHeight()
        .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = textInput,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RowScope.WeightModifiedColumnWithChildren(modifier: Modifier = Modifier) {
    // modifier includes the weight
    Row(modifier = modifier
        .fillMaxHeight()
        .border(color = Color.Black, width = 2.dp),
    ) {
        WeightModifiedColumn(
            backgroundColor = Color.LightGray,
            textInput = "2f",
            modifier = Modifier.weight(2f)
        )
        WeightModifiedColumn(
            backgroundColor = Color.DarkGray,
            textInput = "3f",
            modifier = Modifier.weight(3f)
        )
        WeightModifiedColumn(
            backgroundColor = Color.Blue,
            textInput = "5f",
            modifier = Modifier.weight(5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeightModifiedRowScreenPreview() {
    Assign3_1Theme {
        WeightModifiedRowScreen(Modifier.fillMaxWidth().height(200.dp))
    }
}