package com.duoc.saasdeporte.presentation.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duoc.saasdeporte.presentation.components.atoms.AppBodyText
import com.duoc.saasdeporte.presentation.components.atoms.AppPrimaryButton
import com.duoc.saasdeporte.presentation.components.molecules.ScreenHeader
import com.duoc.saasdeporte.presentation.components.templates.AppScreenTemplate

@Composable
fun LoginScreen(onLoginClick: () -> Unit = {}) {
    AppScreenTemplate { _ ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ScreenHeader(
                title = "Login",
                subtitle = "Pantalla lista para conectar LoginViewModel"
            )
            AppBodyText(text = "Aqui iran los campos email/password y validaciones.")
            AppPrimaryButton(label = "Iniciar sesion", onClick = onLoginClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen()
    }
}