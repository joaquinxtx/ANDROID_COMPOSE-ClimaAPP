package com.joaquindev.climaapp.presentation.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ButtonNewLocation(
    onClickClimate: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Button(
        onClick = {
            onClickClimate()
            keyboardController?.hide()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Search city", color = Color.White, fontSize = 17.sp)
    }
}