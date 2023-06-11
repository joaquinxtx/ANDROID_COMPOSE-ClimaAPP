package com.joaquindev.climaapp.presentation.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.draw.clip

@Composable
fun LoaderItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
) {
    if (isLoading) {
        Box(Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.align(Center),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding()
                        .width(93.dp)
                        .height(95.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect(),

                    )
                Box(
                    modifier = Modifier
                        .padding()
                        .width(93.dp)
                        .height(95.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect(),

                    )
                Box(
                    modifier = Modifier
                        .padding()
                        .width(93.dp)
                        .height(95.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect(),

                    )
                Box(
                    modifier = Modifier
                        .padding()
                        .width(93.dp)
                        .height(95.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect(),

                    )
            }
        }
    } else {
        contentAfterLoading()
    }
}




