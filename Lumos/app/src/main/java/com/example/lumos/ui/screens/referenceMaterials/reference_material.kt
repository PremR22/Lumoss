package com.example.lumos.ui.screens.referenceMaterials

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


@Composable
fun RefMaterial(navController: NavController?) {
    Scaffold(
        topBar = { TopBar(title = "Reference Material", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                val subjects = listOf("Math", "Science", "History", "English")

                items(subjects.size) {index ->
                    val subject = subjects[index]
                    ResourceCard(
                        Name = subject,
                        onClick = { navController?.navigate("subject_details/$subject") }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewrefMaterial() {
    val fakeNavController = rememberNavController()
    RefMaterial(navController = fakeNavController)
}