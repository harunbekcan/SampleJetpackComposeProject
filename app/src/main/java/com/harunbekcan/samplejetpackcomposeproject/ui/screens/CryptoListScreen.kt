package com.harunbekcan.samplejetpackcomposeproject.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponseItem

@Composable
fun CryptoListScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(
                "Coin Market", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            CryptoList()
        }
    }
}

@Composable
fun CryptoList(
    viewModel: CryptoListScreenViewModel = hiltViewModel()
) {
    val cryptoList by remember { viewModel.cryptoList }
    //val errorMessage by remember { viewModel.errorMessage }
    val isLoading by remember { viewModel.isLoading }

    CryptoListView(cryptos = cryptoList)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
    }

}

@Composable
fun CryptoListView(cryptos: List<CryptoListResponseItem>) {
    LazyVerticalGrid(contentPadding = PaddingValues(5.dp), columns = GridCells.Fixed(2)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}


@Composable
fun CryptoRow(crypto: CryptoListResponseItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        modifier = Modifier.padding(8.dp),
        border = BorderStroke(1.5.dp, MaterialTheme.colors.secondary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Text(
                text = crypto.currency ?: "",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                fontSize = 24.sp
            )
            Text(
                text = crypto.price ?: "",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(4.dp),
                color = MaterialTheme.colors.primaryVariant,
                fontSize = 16.sp
            )
        }
    }
}