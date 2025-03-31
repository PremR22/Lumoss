package com.example.lumos.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lumos.R
import com.example.lumos.Routes
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.theme.Inter


@Composable
fun Welcome(navController: NavController?) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_black),
            contentDescription = "Notifications",
            modifier = Modifier.size(250.dp)
        )
        Text(
            text = ("Bringing Clarity to College Life"),
            style = TextStyle(fontFamily = Inter, fontSize = 40.sp),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = (-1).sp,
            lineHeight = 45.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = ("Stay organized, access notes easily, and never miss a deadline. Lumos is your smartest college companion"),
            style = TextStyle(fontFamily = Inter, fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
            ,
            letterSpacing = (0.8).sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        LumosSubmitButton (
            onClick = { navController?.navigate(Routes.signup) },
            text = "Get Started",
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = ("By pressing 'Get Started' you agree to our Privacy Policy and Terms and Conditions"),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcome() {
    Welcome(navController = null)
}