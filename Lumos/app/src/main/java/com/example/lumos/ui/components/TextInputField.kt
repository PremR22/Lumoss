package com.example.lumos.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.OffWhite

@Composable
fun LumosTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        shape = RoundedCornerShape(12.dp), // Rounded corners
        colors = TextFieldDefaults.colors(
            focusedContainerColor = OffWhite, // Background when focused
            unfocusedContainerColor = OffWhite, // Background when unfocused
            focusedIndicatorColor = Color.Black, // Border color when focused
            unfocusedIndicatorColor = Black, // Border color when not focused
            cursorColor = Color.Black // Cursor color
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {
    LumosTextField(
        value = "",
        onValueChange = {},
        label = { Text("Password", style = MaterialTheme.typography.bodyLarge) },
        modifier = Modifier,
        visualTransformation = VisualTransformation.None)
}