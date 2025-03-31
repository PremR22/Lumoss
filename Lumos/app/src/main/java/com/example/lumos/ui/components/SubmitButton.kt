package com.example.lumos.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Pink

@Composable
fun LumosSubmitButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp), // Rounded corners
        border = BorderStroke(1.dp, Color.Black), // Border with 2dp thickness
        colors = ButtonDefaults.buttonColors(
            containerColor = Pink, // Background color
            contentColor = Black // Text color
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(text, style = TextStyle(fontFamily = Intan, fontSize = 22.sp), modifier = Modifier.padding(top = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomButton() {
    LumosSubmitButton(
        text = "Login",
        onClick = {}
    )
}