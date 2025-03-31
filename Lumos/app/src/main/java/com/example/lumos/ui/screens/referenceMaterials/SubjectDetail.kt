package com.example.lumos.ui.screens.referenceMaterials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.ResourceCard
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.OffWhite


@Composable
fun SubjectDetail(navController: NavController?, subject: String) {
    Scaffold(
        topBar = { TopBar(title = "$subject Resources", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .background(OffWhite)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val categories = listOf("Notes", "Textbooks", "PYQs", "Journal")

                items(categories.size) { index ->
                    ResourceCard(
                        Name = categories[index],
                        onClick = { navController?.navigate("subject_details/$subject") }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewsubjectDetail() {
    val fakeNavController = rememberNavController()
    SubjectDetail(navController = fakeNavController, subject = "CTIT")
}