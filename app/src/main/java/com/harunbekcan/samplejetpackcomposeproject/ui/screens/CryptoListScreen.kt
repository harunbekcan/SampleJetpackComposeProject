package com.harunbekcan.samplejetpackcomposeproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponseItem

@Composable
fun CryptoListScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text("Crypto Crazy",modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                textAlign = TextAlign.Center,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            CryptoList(navController = navController)
        }
    }
}

@Composable
fun CryptoList(
    navController: NavController,
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
        if(isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
    }

}

@Composable
fun CryptoListView(cryptos: List<CryptoListResponseItem>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) { crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}


@Composable
fun CryptoRow(crypto: CryptoListResponseItem) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.secondary)
    ) {
        Text(text = crypto.currency?:"",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
        Text(text = crypto.price?:"",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(2.dp),
            color = MaterialTheme.colors.primaryVariant
        )
    }
}