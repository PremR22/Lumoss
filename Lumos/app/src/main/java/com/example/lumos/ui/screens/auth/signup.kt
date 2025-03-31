package com.example.lumos.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.LumosTextField
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.OffWhite
import androidx.compose.ui.text.style.TextDecoration
import com.example.lumos.Routes


@Composable
fun Signup(navController: NavController?) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = "Sign Up",
                style = TextStyle(fontFamily = Intan, fontSize = 22.sp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))
            LumosTextField(
                value = name,
                onValueChange = { newValue -> name = newValue },
                label = { Text("Name")},
                modifier = Modifier,
                visualTransformation = VisualTransformation.None
            )

            Spacer(modifier = Modifier.height(12.dp))
            LumosTextField(
                value = email,
                onValueChange = { newValue -> email = newValue },
                label = { Text("Email")},
                modifier = Modifier,
                visualTransformation = VisualTransformation.None
            )

            Spacer(modifier = Modifier.height(12.dp))
            LumosTextField(
                value = password,
                onValueChange = { newValue -> password = newValue },
                label = { Text("Password")},
                modifier = Modifier,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(24.dp))
            LumosSubmitButton(
                onClick = { navController?.navigate(Routes.verifyEmail) },
                text = "Sign Up",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "OR",
                style = TextStyle(fontFamily = Inter, fontSize = 16.sp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            //Google Sign In Button
            Button(
                onClick = {
                //startForResult.launch(googleSignInClient?.signInIntent)
                },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = OffWhite,
                    contentColor = Black
                ),
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            ) {

                Text(text = "Sign in with Google", style = TextStyle(fontFamily = Intan, fontSize = 22.sp), modifier = Modifier.padding(top = 4.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))
            TextButton(onClick = { navController?.navigate(Routes.login) }) {
                Text(
                    text = "Already have an account? Log In",
                    style = TextStyle(fontFamily = Inter), color = Black, textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignup() {
    Signup(navController = null)
}