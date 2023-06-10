package com.joaquindev.climaapp.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemClimate(tempData: String, iconTemp: Int, title: String, modifier: Modifier) {
    Card(
        onClick = {},
        modifier = modifier.padding(5.dp),
        colors = CardDefaults.cardColors(Color(0xB20F1314), contentColor = Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(). padding(vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = title, modifier = Modifier.padding(bottom = 5.dp))
                Image( painter = painterResource(id = iconTemp), contentDescription = "",modifier = Modifier.size(32.dp))
                Text(text = tempData , modifier = Modifier.padding(top = 5.dp))
            }
        }

    }

}