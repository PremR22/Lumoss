package com.example.lumos.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.CardColors
import com.example.lumos.ui.theme.Inter

@Composable
fun RoleOptionCard(
    role: String,
    selectedRole: String?,
    onSelect: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() }
            .border(
                width = 1.dp,
                color = if (selectedRole == role) Color.Black else Color.Gray,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selectedRole == role) CardColors.random() else Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(69.dp)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = role,
                fontFamily = Inter,
                fontSize = 18.sp,
                color = if (selectedRole == role) Black else MaterialTheme.colorScheme.onBackground
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewRoleOptionCard() {
        Column {
            RoleOptionCard(role = "Teacher", selectedRole = "Teacher", onSelect = {})
            Spacer(modifier = Modifier.height(16.dp))
            RoleOptionCard(role = "Student", selectedRole = null, onSelect = {})
        }
}

