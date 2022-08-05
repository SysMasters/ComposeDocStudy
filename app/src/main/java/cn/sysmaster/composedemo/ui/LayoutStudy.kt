package cn.sysmaster.composedemo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LayoutStudy() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("LayoutStudy")
        }, actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        })
    }) {
        BodyContent(Modifier.padding(it))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text("Hi there!")
        Text("Thanks for going through the LayoutStudy.")
    }
}