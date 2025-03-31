package com.example.lumos.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.CustomDropdown
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan

@Composable
fun SelectClassScreen(
    navController: NavController? = null,
    onSubmit: (String, String, String) -> Unit
) {
    var selectedYear by remember { mutableStateOf<String?>(null) }
    var selectedCourse by remember { mutableStateOf<String?>(null) }
    var selectedDivision by remember { mutableStateOf<String?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Select your Class",
            fontFamily = Intan,
            fontSize = 22.sp,
            color = Black
        )
        Spacer(modifier = Modifier.height(32.dp))
        // Year Dropdown
        CustomDropdown(
            label = "Select Year",
            items = listOf("First Year", "Second Year", "Third Year", "Final Year"),
            selectedItem = selectedYear ?: "",
            onItemSelected = { selectedYear = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Course Dropdown
        CustomDropdown(
            label = "Select Course",
            items = listOf("BCA", "BBA", "B.Com", "BA"),
            selectedItem = selectedCourse ?: "",
            onItemSelected = { selectedCourse = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Division Dropdown
        CustomDropdown(
            label = "Select Division",
            items = listOf("A", "B", "C", "D"),
            selectedItem = selectedDivision ?: "",
            onItemSelected = { selectedDivision = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Submit Button
        LumosSubmitButton(
            onClick = {
                if (!selectedYear.isNullOrBlank() && !selectedCourse.isNullOrBlank() && !selectedDivision.isNullOrBlank()) {
                    onSubmit(selectedYear!!, selectedCourse!!, selectedDivision!!)
                    navController?.navigate(Routes.st_dashboard)
                }
            },
            text = "Finish",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSelectClassScreen() {
    val fakenavController = rememberNavController()
    SelectClassScreen(navController = fakenavController, onSubmit = { _, _, _ -> })
}
