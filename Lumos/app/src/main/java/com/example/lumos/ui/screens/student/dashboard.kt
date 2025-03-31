package com.example.lumos.ui.screens.student

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.OffWhite


@Composable
fun Dashboard(navController: NavController?) {
    Scaffold(
        topBar = { TopBar(title = "Lumos", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        },
        containerColor = OffWhite
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(OffWhite)

        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ("LUMOS"),
                    style = TextStyle(fontFamily = Intan, fontSize = 22.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 128.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = ("Your Best College Companion"),
                    style = TextStyle(fontFamily = Inter, fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                    ,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                LumosSubmitButton (
                    onClick = { navController?.navigate(Routes.signup) },
                    text = "Get Started",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Previewdashboard() {
    val fakeNavController = rememberNavController()
    Dashboard(navController = fakeNavController)
}