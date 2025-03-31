package com.example.lumos.ui.screens.referenceMaterials

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.CustomDropdown
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.ResourceItem
import com.example.lumos.ui.components.SubmitButtonSmall
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.Green
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.OffWhite

@Composable
fun NewReferenceMaterialScreen(
    onSubmit: (String, String, String, Uri?) -> Unit,
    navController: NavController? = null
) {
    var title by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf<String?>(null) }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var fileUri by remember { mutableStateOf<Uri?>(null) }

    val filePicker =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            fileUri = uri
        }
    Scaffold(
        topBar = { TopBar(title = "Add New Resource", onNotificationClick = {}) },
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
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(650.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Green)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(
                            "Title",
                            fontFamily = Inter,
                            fontSize = 16.sp,
                            modifier = Modifier
                        ) },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Green
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    // Subject Dropdown
                    CustomDropdown(
                        label = "Select Subject",
                        items = listOf("Mathematics", "Physics", "Chemistry", "Biology"),
                        selectedItem = selectedSubject ?: "",
                        onItemSelected = { selectedSubject = it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Category Dropdown
                    CustomDropdown(
                        label = "Select Category",
                        items = listOf("Notes", "Textbooks", "PYQs", "Journal"),
                        selectedItem = selectedCategory ?: "",
                        onItemSelected = { selectedCategory = it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    // File Upload Section
                    if (fileUri == null) {
                        SubmitButtonSmall(
                            onClick = { filePicker.launch("*/*") },
                            text = "Select File (PDF, Doc, Image)",
                            modifier = Modifier.fillMaxWidth()
                        )
                    } else {
                        ResourceItem(
                            name = "${fileUri?.lastPathSegment}",
                            onClick = {},
                            onDownload = {}
                        ) {}
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Upload Button (Disabled if file is not selected)
                    if (fileUri == null) { // CHANGE KAR == to != BC
                        LumosSubmitButton(
                            onClick = {
                                if (title.isNotBlank() && selectedSubject?.isNotBlank() == true && selectedCategory?.isNotBlank() == true) {
                                    onSubmit(title, selectedSubject!!, selectedCategory!!, fileUri)
                                    navController?.navigate(Routes.refMaterial)
                                }
                            },
                            text = "Upload",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewReferenceMaterialScreen() {
    val fakeNavController = rememberNavController()
    NewReferenceMaterialScreen(
        onSubmit = { _, _, _, _ -> },
        navController = fakeNavController
    )
}


