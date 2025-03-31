package com.example.lumos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Graded
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.Late
import com.example.lumos.ui.theme.NotSubmitted
import com.example.lumos.ui.theme.Submitted

data class StudentSubmission(
    val name: String,
    val profileUrl: String? = null, // Optional: URL for profile picture
    val status: SubmissionStatus
)

enum class SubmissionStatus {
    SUBMITTED, LATE, NOT_SUBMITTED, GRADED
}

@Composable
fun StudentSubmissionRow(student: StudentSubmission) {
    Column(
        modifier = Modifier
        .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Icon (Uses URL if available)
            if (student.profileUrl != null) {
                Image(
                    painter = rememberAsyncImagePainter(student.profileUrl),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(50))
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))
            // Student Name
            Text(
                text = student.name,
                fontSize = 16.sp,
                fontFamily = Inter,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))
            // Submission Status Chip
            SubmissionStatusBadge(student.status)
        }
        HorizontalDivider(thickness = 1.dp, color = Color.DarkGray)
    }

}

@Composable
fun SubmissionStatusBadge(status: SubmissionStatus) {
    val (bgColor, textColor, label) = when (status) {
        SubmissionStatus.SUBMITTED -> Triple(Submitted, Black, "Submitted")
        SubmissionStatus.LATE -> Triple(Late, Black, "Late Submission")
        SubmissionStatus.NOT_SUBMITTED -> Triple(NotSubmitted, Black, "Not Submitted")
        SubmissionStatus.GRADED -> Triple(Graded, Black, "Graded")
    }

    Box(
        modifier = Modifier
            .background(bgColor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            fontFamily = Inter,
            fontStyle = FontStyle.Italic,
            letterSpacing = (-0.5).sp,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAssignmentSubmissionsScreen() {
    val students = listOf(
        StudentSubmission("Alice Johnson", null, SubmissionStatus.SUBMITTED),
        StudentSubmission("Bob Smith", null, SubmissionStatus.LATE),
        StudentSubmission("Charlie Davis", null, SubmissionStatus.NOT_SUBMITTED),
        StudentSubmission("David Lee", null, SubmissionStatus.GRADED)
    )
    LazyColumn {
        items(students) { student ->
            StudentSubmissionRow(student)
        }
    }
}
