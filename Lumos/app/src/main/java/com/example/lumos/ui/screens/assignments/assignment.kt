package com.example.lumos.ui.screens.assignments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.ui.components.AssignmentCard
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.OffWhite

data class Assignment(
    val title: String,
    val dueDate: String,
    val teacherName: String,
    val description: String
)

@Composable
fun AssignmentScreen(navController: NavController?) {
    Scaffold(
        topBar = { TopBar(title = "Assignments", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).background(OffWhite)) {
            val assignments = listOf(
                Assignment(
                    title = "Math Assignment",
                    dueDate = "March 30, 2025",
                    teacherName = "Prof. Smith",
                    description = "Solve all the algebra problems given in chapter 5 and submit before the due date."
                ),
                Assignment(
                    title = "Physics Homework",
                    dueDate = "April 5, 2025",
                    teacherName = "Dr. Johnson",
                    description = "Complete the lab report on Newton’s Laws of Motion."
                ),
                Assignment(
                    title = "History Essay",
                    dueDate = "April 10, 2025",
                    teacherName = "Mrs. Thompson",
                    description = "Write a detailed essay on World War II causes and consequences."
                ),
                Assignment(
                    title = "Math Assignment",
                    dueDate = "March 30, 2025",
                    teacherName = "Prof. Smith",
                    description = "Solve all the algebra problems given in chapter 5 and submit before the due date."
                ),
                Assignment(
                    title = "Physics Homework",
                    dueDate = "April 5, 2025",
                    teacherName = "Dr. Johnson",
                    description = "Complete the lab report on Newton’s Laws of Motion."
                ),
            )

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)) {
                // Assignments List
                LazyColumn (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(assignments.size) { index ->
                        val assignment = assignments[index]
                        AssignmentCard(
                            title = assignment.title,
                            dueDate = assignment.dueDate,
                            teacherName = assignment.teacherName,
                            description = assignment.description,
                            onSubmitClick = { /* TODO: Handle submit */ }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewsAss() {
    val fakeNavController = rememberNavController()
    AssignmentScreen(navController = fakeNavController)
}