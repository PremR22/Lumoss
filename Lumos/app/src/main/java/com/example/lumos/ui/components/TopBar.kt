package com.example.lumos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.OffWhite


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onNotificationClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = OffWhite,
            titleContentColor = Black,
        ),
        title = { Text(
            title,
            style = TextStyle(fontFamily = Intan, fontSize = 22.sp),
            modifier = Modifier
                .padding(top = 5.dp)
        )},

        actions = {
            IconButton(onClick = onNotificationClick) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopBar(
        title = "Lumos",
        onNotificationClick = {}
    )
}