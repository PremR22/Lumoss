package com.example.lumos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumos.R
import com.example.lumos.ui.theme.Black
import com.example.lumos.ui.theme.Inter
import com.example.lumos.ui.theme.OffYellow

@Composable
fun ResourceItem(name: String, onClick: () -> Unit, onDownload: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Black, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = OffYellow),
        elevation = CardDefaults.cardElevation(2.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // File Icon (Placeholder for now)
            Image(
                painter = painterResource(id = R.drawable.ic_file),
                contentDescription = "Notifications",
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = name,
                fontFamily = Inter,
                fontSize = 14.sp,
                color = Black
            )

            Spacer(modifier = Modifier.weight(1f))
            // Download Icon
            IconButton(onClick = onDownload) {
                Image(
                    painter = painterResource(id = R.drawable.ic_download),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(22.dp)
                )
            }

            // Delete Icon
            IconButton(onClick = onDelete) {
                Image(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Notifications",
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewResourceItem(){
    ResourceItem(
        name = "chapter1.pdf",
        onClick = {},
        onDownload = {},
        onDelete = {}
    )
}