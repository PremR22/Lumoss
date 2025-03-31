package com.example.lumos.ui.screens.noticeBoard

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.lumos.Routes
import com.example.lumos.ui.components.BottomNavBar
import com.example.lumos.ui.components.LumosSubmitButton
import com.example.lumos.ui.components.SubmitButtonSmall
import com.example.lumos.ui.components.TopBar
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.LightBlue
import com.example.lumos.ui.theme.OffWhite

@Composable
fun NewNoticeScreen(
    navController: NavController? = null
) {
    var title by remember { mutableStateOf(TextFieldValue()) }
    var content by remember { mutableStateOf(TextFieldValue()) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    Scaffold(
        topBar = { TopBar(title = "Add New Notice", onNotificationClick = {}) },
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
                colors = CardDefaults.cardColors(containerColor = LightBlue)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(
                            "Title",
                            fontFamily = Intan,
                            fontSize = 22.sp,
                            modifier = Modifier
                                .padding(top = 4.dp)
                        ) },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = LightBlue
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        label = { Text("Content",
                                fontFamily = Inter,
                                fontSize = 16.sp) },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 5,
                        maxLines = 10
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    SubmitButtonSmall(
                        onClick = { imagePicker.launch("image/*") },
                        text = "Select Image (Optional)",
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Show Selected Image
                    imageUri?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        AsyncImage(
                            model = it,
                            contentDescription = "Selected Image",
                            modifier = Modifier.height(200.dp)
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    LumosSubmitButton(
                        onClick = {
                            navController?.navigate(Routes.noticeBoard)
                            /*if (title.text.isNotBlank() && content.text.isNotBlank()) {
                                onSubmit(title.text, content.text, imageUri)

                                SUBMIT FUNCTIONALITY REDO
                            }*/
                        },
                        text = "Submit Notice",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewNoticeScreen() {
    val fakeNavController = rememberNavController()
    NewNoticeScreen(
        navController = fakeNavController
    )
}