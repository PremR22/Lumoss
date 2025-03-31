package com.example.lumos.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.RoleOptionCard
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.OffWhite

@Composable
fun SelectRoleScreen(
    navController: NavController
) {
    var selectedRole by remember { mutableStateOf<String?>(null) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(OffWhite)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select your Role",
                fontFamily = Intan,
                fontSize = 22.sp,
                color = Black
            )

            Spacer(modifier = Modifier.height(32.dp))
            RoleOptionCard(
                role = "Teacher",
                selectedRole = selectedRole,
                onSelect = { selectedRole = "Teacher" }
            )

            Spacer(modifier = Modifier.height(16.dp))
            RoleOptionCard(
                role = "Student",
                selectedRole = selectedRole,
                onSelect = { selectedRole = "Student" }
            )

            Spacer(modifier = Modifier.height(32.dp))
            LumosSubmitButton(
                onClick = { selectedRole?.let {
                    if (selectedRole == "Student"){ navController.navigate(Routes.selectClass) }
                    else {navController.navigate(Routes.st_dashboard) }
                } },
                text = "Continue",
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectRoleScreen() {
        SelectRoleScreen(navController = rememberNavController())
}
