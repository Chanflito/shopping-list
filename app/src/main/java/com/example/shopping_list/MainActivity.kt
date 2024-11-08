package com.example.shopping_list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
        setContent {
            var isAuthenticated by remember { mutableStateOf(false) }
            if (isAuthenticated) {
                val navController = rememberNavController()
                ShoppinglistTheme {
                    MainScreen(navController = navController)
                }
            } else {
                BiometricAuthentication(
                    isAuthenticated = isAuthenticated,
                    onSuccess = { isAuthenticated = true },
                    biometricAuthManager = biometricAuthManager
                )
            }
        }
    }

    @Composable
    fun BiometricAuthentication(
        isAuthenticated: Boolean,
        onSuccess: () -> Unit,
        biometricAuthManager: BiometricAuthManager
    ) {
        val context = LocalContext.current
        val biometricManager = remember { BiometricManager.from(context) }
        val isBiometricAvailable = remember {
            biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
        }

        when (isBiometricAvailable) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                if (!isAuthenticated) {
                    biometricAuthManager.authenticate(context, onError = {
                        Toast.makeText(context, "Authentication error", Toast.LENGTH_SHORT).show()
                    }, onSuccess = {
                        onSuccess()
                    }, onFail = {
                        Toast.makeText(context, "Authentication failed, please try again", Toast.LENGTH_SHORT).show()
                    })
                }
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Text(text = "This phone doesn't support biometric authentication")
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                Text(text = "Biometric hardware is unavailable")
            }

            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                Text(text = "Security update required for biometric authentication")
            }

            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                Text(text = "Biometric authentication is unsupported on this Android version")
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                Text(text = "No biometric credentials enrolled")
            }

            else -> {
                Text(text = "Unknown biometric error")
            }
        }
    }
}