package com.example.lumos.ui.screens.noticeBoard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.NoticeBoardItem
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.OffWhite
import java.time.LocalDate

@Composable
fun NoticeBoardScreen(navController: NavController?) {
    val notices = listOf(
        Notice(
            title = "Exam Schedule Released",
            postedOn = LocalDate.of(2025, 3, 27),
            content = "Final exams will be held from April 10th to April 20th."
        ),
        Notice(
            title = "Holiday Announcement",
            postedOn = LocalDate.of(2025, 3, 25),
            content = "College will remain closed on April 1st due to a public holiday."
        ),
        Notice(
            title = "New Library Books Arrived",
            postedOn = LocalDate.of(2025, 3, 22),
            content = "https://de7i3bh7bgh0d.cloudfront.net/2024/03/22/17/35/10/0ae85aa8-9b1e-47b8-9e0f-ed885dd21467/BLEACH_TYBW_P1_LE_Blog_1200x630.jpg"
        )
    )

    Scaffold(
        topBar = { TopBar(title = "Notice Board", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(OffWhite)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(notices) { notice ->
                    NoticeBoardItem(
                        title = notice.title,
                        postedOn = notice.postedOn,
                        content = notice.content
                    )
                }
            }
        }
    }
}

// Data Class for Notice
data class Notice(
    val title: String,
    val postedOn: LocalDate,
    val content: String?
)

@Preview(showBackground = true)
@Composable
fun PreviewNoticeBoard(){
    val fakeNavController = rememberNavController()
    NoticeBoardScreen(fakeNavController)
}