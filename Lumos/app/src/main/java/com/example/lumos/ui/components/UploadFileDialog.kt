package com.example.lumos.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Intan
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.OffWhite
import com.example.lumos.ui.theme.OffYellow


@Composable
fun UploadFileDialog(onDismiss: () -> Unit, onFileSelected: (Uri) -> Unit) {
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedFileUri = it // Store selected file URI
        }
    }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = CardDefaults.shape,
            colors = CardDefaults.cardColors(containerColor = OffWhite),
            modifier = Modifier
                .height(220.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 20.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                // Title
                Text(
                    text = "Submit Assignment",
                    fontFamily = Intan,
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 12.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { filePickerLauncher.launch("*/*") },
                    contentAlignment = Alignment.Center
                )
                {
                    if (selectedFileUri == null) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .background(OffYellow, shape = RoundedCornerShape(16.dp))
                            .border(
                                BorderStroke(1.dp, Black),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable { filePickerLauncher.launch("*/*") },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_upload),
                                contentDescription = "Upload",
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp)) // Space between icon and text
                            Text(
                                "Drag & Drop OR Browse to choose your files",
                                color = Black,
                                fontSize = 14.sp)
                        }
                    } else {
                        Column(modifier = Modifier
                            .fillMaxSize()
                        )
                        {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(70.dp)
                                    .padding(bottom = 12.dp)
                                    .background(OffYellow, shape = RoundedCornerShape(8.dp))
                                    .border(
                                        BorderStroke(1.dp, Black),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.width(16.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.ic_file),
                                    contentDescription = "Notifications",
                                    modifier = Modifier
                                        .size(28.dp)
                                )

                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "${selectedFileUri?.lastPathSegment}",
                                    fontFamily = Inter,
                                    fontSize = 14.sp,
                                    color = Black
                                )

                                Spacer(modifier = Modifier.weight(1f))
                                IconButton(onClick = { selectedFileUri = null } ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_cancel),
                                        contentDescription = "Notifications",
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                            LumosSubmitButton(
                                onClick = { selectedFileUri?.let { onFileSelected(it) } },
                                text = "Submit"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSubmitAssignmentDialog() {
    var showDialog by remember { mutableStateOf(true) } // Set to true for preview

    if (showDialog) {
        UploadFileDialog(onDismiss = { showDialog = false }, onFileSelected = {})
    }
}