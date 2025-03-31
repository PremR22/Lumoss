package com.example.lumos.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter

@Composable
fun VerifyEmailScreen(
    navController: NavController,
    onVerify: (String) -> Unit,
    onResendCode: () -> Unit
) {
    var otpCode by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Verify Your Email",
                fontFamily = Intan,
                fontSize = 22.sp,
                color = Black
            )

            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = otpCode,
                onValueChange = {
                    otpCode = it
                    isError = it.length != 6
                },
                label = { Text(
                    "Enter your Verification Code",
                    fontFamily = Inter,
                    fontSize = 16.sp,
                    modifier = Modifier
                ) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                isError = isError,
                modifier = Modifier.fillMaxWidth()
            )

            if (isError) {
                Text("Enter a valid 6-digit code",
                    fontFamily = Inter,
                    fontSize = 16.sp,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            LumosSubmitButton(
                onClick = {
                    if (otpCode.length == 6) {
                        onVerify(otpCode)  // Call verification function
                        navController.navigate(Routes.selectRole)
                    } else {
                        isError = true
                    }
                },
                text = "Verify",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Are you facing any problems with receiving the code?",
                fontFamily = Inter,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            TextButton(onClick = onResendCode) {
                Text(
                    text = "Resend Code",
                    style = TextStyle(
                        fontFamily = Inter),
                    color = Black,
                    textDecoration = TextDecoration.Underline,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVerifyEmailScreen() {
    val fakeNavController = rememberNavController()
    VerifyEmailScreen(
        navController = fakeNavController,
        onVerify = {},
        onResendCode = {}
    )
}
