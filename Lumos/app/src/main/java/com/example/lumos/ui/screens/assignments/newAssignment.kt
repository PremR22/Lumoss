package com.example.lumos.ui.screens.assignments

import android.app.DatePickerDialog
import android.net.Uri
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lumos.Routes
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.SubmitButtonSmall
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.components.UploadFileDialog
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.LightBlue
import com.example.lumos.ui.theme.OffWhite
import java.util.Calendar

@Composable
fun AddAssignmentScreen(navController: NavController? = null) {
    var title by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var uploadedFileUri by remember { mutableStateOf<Uri?>(null) }
    var showDialog by remember { mutableStateOf(false) }


    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Date Picker Dialog
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            dueDate = "$dayOfMonth/${month + 1}/$year" // Format: DD/MM/YYYY
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(
        topBar = { TopBar(title = "Add New Assignment", onNotificationClick = {}) },
        bottomBar = {
            if (navController != null) {
                BottomNavBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Column (
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
                colors = CardDefaults.cardColors(containerColor = LightBlue)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                ) {
                    // Title Input
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Title",
                            style = TextStyle(
                                fontFamily = Intan,
                                fontSize = 22.sp),
                            modifier = Modifier.padding(top = 4.dp)) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = LightBlue
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    SubmitButtonSmall(
                        onClick = { datePickerDialog.show() },
                        text = (if (dueDate.isEmpty()) "Pick Due Date" else "Due Date: $dueDate"),
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Scrollable Description Input
                    Box(
                        modifier = Modifier
                            .weight(1f) // Only this section scrolls
                            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                            .padding(4.dp)
                        // Background for better visibility
                    ) {
                        BasicTextField(
                            value = description,
                            onValueChange = { description = it },
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState()),
                            textStyle = TextStyle(fontFamily = Inter, fontSize = 16.sp, color = Black)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // File Upload Button (Optional)
                    uploadedFileUri?.let {
                        Text(
                            text = "Uploaded: ${it.lastPathSegment}",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 12.dp)
                        )
                    }

                    SubmitButtonSmall(
                        onClick = { showDialog = true },
                        text = "Upload Files",
                        modifier = Modifier
                            .fillMaxWidth()
                    )


                    if (showDialog) {
                        UploadFileDialog(
                            onDismiss = { showDialog = false },
                            onFileSelected = { uri ->
                                uploadedFileUri = uri // Store the selected file
                                showDialog = false // Close the dialog after file selection
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    //Save Assignment Button
                    LumosSubmitButton(
                        onClick = {
                            navController?.navigate(Routes.assignment)
                            //add save functionality
                            },
                        text = "Save Assignment",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddEditAssignmentScreen() {
    val fakeNavController = rememberNavController()
    AddAssignmentScreen(navController = fakeNavController)
}
