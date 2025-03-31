package com.example.lumos.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.CardColors
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun NoticeBoardItem(title: String, postedOn: LocalDate, content: String?) {
    val backgroundColor = remember { CardColors.random() }
    val formattedDate = postedOn.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
            .border(1.dp, Black, RoundedCornerShape(12.dp)),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = TextStyle(fontFamily = Intan, fontSize = 22.sp),
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Posted on: $formattedDate",
                style = TextStyle(fontFamily = Inter, fontSize = 11.sp),
                color = Black)


            Spacer(modifier = Modifier.height(8.dp))
            content?.let {
                if (it.startsWith("http") || it.startsWith("content://") || it.startsWith("file://")) {
                    AsyncImage(
                        model = it,  // Works for both URLs & local images
                        contentDescription = "Notice Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                    )
                } else {
                    Text(text = it,
                        style = TextStyle(fontFamily = Inter, fontSize = 14.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotice(){
    NoticeBoardItem(
        title = "Submit your letters",
        postedOn = LocalDate.now(),
        content = "Hello This is my test to check if it works or not"
    )
}

