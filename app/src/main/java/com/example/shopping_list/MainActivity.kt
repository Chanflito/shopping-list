package com.example.shopping_list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.example.shopping_list.security.BiometricAuthManager
import com.example.shopping_list.ui.composable.MainScreen
import com.example.shopping_list.ui.theme.ShoppinglistTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    @Inject
    lateinit var biometricAuthManager: BiometricAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val biometricManager = BiometricManager.from(this)
        val canAuthenticate = biometricManager.canAuthenticate(BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)

        if (canAuthenticate == BiometricManager.BIOMETRIC_SUCCESS) {
            biometricAuthManager.authenticate(
                context = this,
                onError = {
                    Toast.makeText(this, "Authentication error", Toast.LENGTH_SHORT).show()
                },
                onSuccess = {
                    setContent {
                        ShoppinglistTheme {
                            val navController = rememberNavController()
                            Surface(modifier = Modifier.fillMaxSize()) {
                                MainScreen(navController = navController)
                            }
                        }
                    }
                },
                onFail = {
                    Toast.makeText(this, "Authentication failed, please try again", Toast.LENGTH_SHORT).show()
                }
            )
        } else {
            handleBiometricError(canAuthenticate)
        }
    }

    private fun handleBiometricError(errorCode: Int) {
        val errorMessage = when (errorCode) {
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> "This phone doesn't have biometric hardware"
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> "Biometric hardware is currently unavailable"
            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> "Security update required for biometric authentication"
            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> "This version of Android does not support biometric authentication"
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> "No biometric credentials enrolled"
            else -> "Unknown biometric error"
        }

        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()

        setContent {
            ShoppinglistTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}