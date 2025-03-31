package com.example.lumos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.OffYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingActionButtonWithSheet() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        FloatingActionButton(
            onClick = { showSheet = true }
        )

        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                BottomSheetContent { showSheet = false }
            }
        }
    }
}

@Composable
fun FloatingActionButton(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        containerColor = OffYellow,
        contentColor = Black,
        modifier = Modifier
            .border(2.dp, Black, CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Add",
            modifier = Modifier
                .size(36.dp)
                .padding(4.dp)
        )
    }
}

@Composable
fun BottomSheetContent(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        /*SheetItem("New Assignment", onDismiss)
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Black)
        Spacer(modifier = Modifier.height(20.dp))
        SheetItem("New Notice", onDismiss)
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Black)
        Spacer(modifier = Modifier.height(20.dp))
        SheetItem("New Reference Material", onDismiss)
        Spacer(modifier = Modifier.height(20.dp))*/
    }
}

@Composable
fun SheetItem(text: String, navController: NavController, route: String, onDismiss: () -> Unit) {
    Text(
        text = text,
        fontFamily = Intan,
        fontSize = 22.sp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onDismiss() // 👈 Close the sheet
                navController.navigate(route) // 👈 Then navigate
            },
        color = Color.Black
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(true) } // 👈 Force it open for preview

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = rememberStandardBottomSheetState(
                initialValue = SheetValue.Expanded
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            BottomSheetContent { showSheet = false }
        }
    }
}