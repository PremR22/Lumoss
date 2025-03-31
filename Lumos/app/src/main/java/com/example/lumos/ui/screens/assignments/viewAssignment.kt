package com.example.lumos.ui.screens.assignments

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.R
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.StudentSubmission
import com.example.lumos.ui.components.StudentSubmissionRow
import com.example.lumos.ui.components.SubmissionStatus
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.components.UploadFileDialog
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.LightBlue
import com.example.lumos.ui.theme.OffWhite

@Composable
fun ViewAssignmentScreen(navController: NavController, assignment: Assignment, students: List<StudentSubmission>) {
    var showDialog by remember { mutableStateOf(false) } // Controls dialog visibility
    var uploadedFileUri by remember { mutableStateOf<Uri?>(null) } // Stores uploaded file
    val pagerState = rememberPagerState { 2 } // Number of pages

    Scaffold(
        topBar = {
            TopBar(title = "Assignment Details") {
                navController.popBackStack() // Navigate back
            }
        },
        bottomBar = {
            if (true) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(OffWhite)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Pager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp)
            )
            { page ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(650.dp)
                        .padding(
                            16.dp, bottom = 1.dp,
                            top = 22.dp,
                            end = 16.dp
                        ),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = LightBlue)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize(),
                    ) {
                        if (page == 1) {
                            Text(
                                text = assignment.title,
                                fontFamily = Intan,
                                fontSize = 22.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_duedate),
                                    contentDescription = "Duedate",
                                    modifier = Modifier.size(32.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = assignment.dueDate,
                                    fontFamily = Inter,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.ic_profile),
                                    contentDescription = "Profile",
                                    modifier = Modifier.size(32.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = assignment.teacherName,
                                    fontFamily = Inter,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                text = assignment.description,
                                fontFamily = Inter,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box{
                                LumosSubmitButton(
                                    onClick = { showDialog = true },
                                    text = "Submit",
                                    modifier = Modifier.align(Alignment.BottomCenter)
                                )
                            }

                            uploadedFileUri?.let {
                                Text(
                                    text = "Uploaded: ${it.lastPathSegment}",
                                    fontSize = 14.sp,
                                    color = Color.Gray,
                                    modifier = Modifier.padding(top = 12.dp)
                                )
                            }

                            if (showDialog) {
                                UploadFileDialog(
                                    onDismiss = { showDialog = false },
                                    onFileSelected = { uri ->
                                        uploadedFileUri = uri // Store the selected file
                                        showDialog = false // Close the dialog after file selection
                                    }
                                )
                            }
                        } else {
                            Text(
                                text = "Submissions",
                                fontFamily = Intan,
                                fontSize = 22.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "(${students.count { it.status != SubmissionStatus.NOT_SUBMITTED }}/${students.size} Received)",
                                fontFamily = Inter,
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyColumn {
                                items(students) { student ->
                                    StudentSubmissionRow(student)
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(12.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewViewAss(){
    val navController = rememberNavController()

    // Sample Assignment Data
    val sampleAssignment = Assignment(
        title = "Math Homework",
        dueDate = "March 30, 2025",
        teacherName = "Dr. Smith",
        description = "Complete exercises 1-10 from Chapter 5."
    )

    val sampleStudents = listOf(
        StudentSubmission("Alice Johnson", null, SubmissionStatus.SUBMITTED),
        StudentSubmission("Bob Smith", null, SubmissionStatus.LATE),
        StudentSubmission("Charlie Davis", null, SubmissionStatus.NOT_SUBMITTED),
        StudentSubmission("David Lee", null, SubmissionStatus.GRADED)
    )

    ViewAssignmentScreen(navController = navController, assignment = sampleAssignment, students = sampleStudents)
}