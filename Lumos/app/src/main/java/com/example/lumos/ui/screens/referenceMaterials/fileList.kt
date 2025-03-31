package com.example.lumos.ui.screens.referenceMaterials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.ResourceItem
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.OffWhite

@Composable
fun FileList(navController: NavController?, subject: String, category: String) {
    val files = listOf(
        "Lecture Notes",
        "Reference Book",
        "Question Paper",
        "Summary Notes"
    )

    Scaffold(
        topBar = { TopBar(title = "$category - $subject", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .background(OffWhite)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(files.size) { index ->
                    ResourceItem(
                        name = files[index],
                        onClick = {},
                        onDownload = {},
                        onDelete = {})
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewfileList(){
    val fakeNavController = rememberNavController()
    FileList(
        navController = fakeNavController,
        subject = "UML",
        category = "Notes"
    )
}
