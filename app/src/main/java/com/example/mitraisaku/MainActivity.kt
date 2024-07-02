package com.example.mitraisaku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitraisaku.ui.theme.MitraIsakuTheme
import com.example.mitraisaku.ui.theme.biruMuda
import com.example.mitraisaku.ui.theme.biruTua

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MitraIsakuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dashboard()
                }
            }
        }
    }
}

@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(biruTua)
            .padding(16.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        BalanceDisplay(balance = "Rp. 1.072.024,00")
        Spacer(modifier = Modifier.height(16.dp))
        TransactionList()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "mitra i.saku",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Gray, CircleShape)
        )
        {
            // Profile image here
        }
    }
}

@Composable
fun BalanceDisplay(balance: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
    ) {
        Text(
            text = "Hi, Toko Bagus!",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Saldo anda",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = balance,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TransactionList() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Transaksi Terakhir",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Keluar", amount = "-Rp. 100.000", date = "1 Juli 2024, 07:20 WIB")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Masuk", amount = "+Rp. 100.000", date = "30 Juni 2024, 20:30 WIB")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Masuk", amount = "+Rp. 100.000", date = "30 Juni 2024, 19:22 WIB")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Masuk", amount = "+Rp. 100.000", date = "30 Juni 2024, 19:10 WIB")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Masuk", amount = "+Rp. 100.000", date = "30 Juni 2024, 17:43 WIB")
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(type = "Saku Masuk", amount = "+Rp. 100.000", date = "30 Juni 2024, 10:36 WIB")
    }
}

@Composable
fun TransactionItem(type: String, amount: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = type,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
        Text(
            text = amount,
            color = if (amount.startsWith("-")) Color.Red else Color.Green,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayDashboard() {
    MitraIsakuTheme {
        Dashboard()
    }
}
