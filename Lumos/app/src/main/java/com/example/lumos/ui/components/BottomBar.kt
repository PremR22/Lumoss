package com.example.lumos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.R
import com.example.lumos.Routes
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.OffWhite

data class BottomNavItem(
    val title: String,
    val iconRes: Int,  // Resource ID for the custom icon
    val route: String
)

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", R.drawable.ic_home, Routes.st_dashboard),
        BottomNavItem("assignment", R.drawable.ic_assignment, Routes.assignment),
        BottomNavItem("notes", R.drawable.ic_notes, Routes.refMaterial),
        BottomNavItem("noticeboard", R.drawable.ic_noticeboard, Routes.noticeBoard),
        BottomNavItem("profile", R.drawable.ic_profile, Routes.profile)
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.background(OffWhite)) {
        HorizontalDivider( thickness = 2.dp, color = Color.Black)

        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.surface
        ) {

            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = item.title,
                            modifier = Modifier.size(
                                when (item.title) {
                                    "home" -> 32.dp  // Bigger Home icon
                                    "assignment" -> 32.dp // Default size
                                    "notes" -> 32.dp // Slightly bigger
                                    "noticeboard" -> 42.dp // Medium size
                                    "profile" -> 36.dp // Smallest
                                    else -> 32.dp // Default
                                }
                            ),
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Black,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavBar() {
    val fakeNavController = rememberNavController()
    BottomNavBar(navController = fakeNavController)
}
