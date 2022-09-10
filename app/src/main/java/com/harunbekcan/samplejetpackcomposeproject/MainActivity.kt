package com.harunbekcan.samplejetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.harunbekcan.samplejetpackcomposeproject.ui.screens.CryptoDetailScreen
import com.harunbekcan.samplejetpackcomposeproject.ui.screens.CryptoListScreen
import com.harunbekcan.samplejetpackcomposeproject.ui.theme.SampleJetpackComposeProjectTheme
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.CRYPTO_DETAIL_SCREEN
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.CRYPTO_ID
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.CRYPTO_LIST_SCREEN
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.CRYPTO_PRICE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleJetpackComposeProjectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = CRYPTO_LIST_SCREEN
                ) {
                    composable(CRYPTO_LIST_SCREEN) {
                        CryptoListScreen(navController = navController)
                    }
                    composable(
                        "$CRYPTO_DETAIL_SCREEN/{$CRYPTO_ID}/{$CRYPTO_PRICE}",
                        arguments = listOf(
                            navArgument(CRYPTO_ID) {
                                type = NavType.StringType
                            },
                            navArgument(CRYPTO_PRICE) {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val cryptoId = remember {
                            it.arguments?.getString(CRYPTO_ID)
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString(CRYPTO_PRICE)
                        }
                        CryptoDetailScreen(
                            id = cryptoId ?: "",
                            price = cryptoPrice ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}