package com.example.lumos.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.R

val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_semibold, FontWeight.SemiBold)
)

val Intan = FontFamily(
    Font(R.font.intan, FontWeight.Normal),
)

// Set of Material typography styles to start with
val LumosTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Intan,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    )
)

@Composable
fun TypographyPreviewScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        MaterialTheme.typography.run {
            Text("Title Large", style = titleLarge)
            Text("Body Large", style = bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypographyScreen() {
    TypographyPreviewScreen()
}