package com.example.latihan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun latihan(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var nohendphone by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var nohendphonesv by remember { mutableStateOf("") }
    var jksv by remember { mutableStateOf("") }

    var listJk = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
    HeaderSection()
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)

        ) {
            Text(text = "Yuk Lengkapi Data Dirimu!",
                modifier = Modifier.padding(12.dp),
                fontSize = 15.sp)


            OutlinedTextField(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                leadingIcon = {
                    Icon(Icons.Filled.Face, contentDescription = "") },
                placeholder = { Text("isi nama anda") }

            )
            OutlinedTextField(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = nohendphone,
                onValueChange = { nohendphone = it },
                label = { Text("No Hendphone") },
                leadingIcon = {
                    Icon(Icons.Filled.Phone, contentDescription = "") },
                placeholder = { Text("isi no hendphone anda") }

            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Jenis Kelamin")

            Row {
                listJk.forEach { item ->
                    Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(
                        selected = jk == item,
                        onClick = {
                            jk = item
                        }
                    )
                        Text(item)
                    }
                }
            }
            Button(
                onClick = {
                    namasv = nama
                    nohendphonesv = nohendphone
                    jksv = jk

                },
                modifier = Modifier .padding(top = 16.dp)
                    .fillMaxWidth()

            ) { Text(text = "Submit") }
            Spacer(modifier = Modifier.size(16.dp))
        }
        ElevatedCard (
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)


        ) {
            detail(judul = "Nama", isinya = namasv)
            detail(judul = "No HP", isinya = nohendphonesv)
            detail(judul = "JK", isinya = jksv)



        }
    }
}

@Composable
fun HeaderSection() {
    Box (modifier = Modifier.
    fillMaxWidth().
    background(color = Color.Blue).
    padding(15.dp))
    {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column {

                Text (
                    text = "Halo",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = (FontWeight.Bold)
                )
                Text (
                    text = "Wahyu Firmansyah",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = (FontWeight.Bold)
                )

            }
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kucing),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp),

                )
                Icon(imageVector = Icons.Filled.Done,
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun detail(
    judul: String, isinya: String
) {
    Row(
        modifier = Modifier.
        fillMaxWidth().
        padding(top = 10.dp)
    ) {
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isinya,
            modifier = Modifier.weight(2f))
    }

}