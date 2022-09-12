package com.harunbekcan.samplejetpackcomposeproject.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harunbekcan.samplejetpackcomposeproject.ui.screens.CryptoListScreen
import com.harunbekcan.samplejetpackcomposeproject.ui.theme.SampleJetpackComposeProjectTheme
import com.harunbekcan.samplejetpackcomposeproject.utils.Constants.CRYPTO_LIST_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                        CryptoListScreen()
                    }
                }
            }
        }
    }
}