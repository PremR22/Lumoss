package com.example.lumos.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.CardColors
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter

@Composable
fun AssignmentCard(
    title: String,
    dueDate: String,
    teacherName: String,
    description: String,
    onSubmitClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = CardColors.random())
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Assignment Title
            Text(
                text = title,
                fontFamily = Intan,
                fontSize = 22.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Due Date & Teacher Name Row
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_duedate),
                        contentDescription = "Duedate",
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = dueDate, fontSize = 14.sp, color = Black)
                }
                Spacer(modifier = Modifier.width(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = teacherName, fontSize = 14.sp, color = Black)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontFamily = Inter,
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 3, // Limits to 3 lines
                overflow = TextOverflow.Ellipsis // Adds "..." if too long
            )

            Spacer(modifier = Modifier.height(12.dp))
            SubmitButtonSmall(
                onClick = onSubmitClick,
                text = "Submit",
                modifier = Modifier
            )
        }
    }
}

// Sample Data Model
/*data class Assignment(
    val title: String = "",
    val dueDate: String = "",
    val teacherName: String = "",
    val description: String = ""
)*/

// Preview for AssignmentCard
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewAssignmentCard() {
    AssignmentCard(
        title = "Math Assignment",
        dueDate = "March 30, 2025",
        teacherName = "Prof. Smith",
        description = "Solve all the algebra problems given in chapter 5 and submit before the due date.",
        onSubmitClick = { /* Click Action */ }
    )
}
