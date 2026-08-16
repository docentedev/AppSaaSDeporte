package com.duoc.saasdeporte.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duoc.saasdeporte.presentation.components.atoms.AppBodyText
import com.duoc.saasdeporte.presentation.components.organisms.HomeWelcomeCard
import com.duoc.saasdeporte.presentation.components.templates.AppScreenTemplate

@Composable
fun HomeScreen() {
    val dataStatus = remember { mutableStateOf("Sin cargar") }

    AppScreenTemplate { _ ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HomeWelcomeCard(
                onPrimaryAction = {
                    dataStatus.value = "Datos cargados (simulado)"
                }
            )
            AppBodyText(text = "Estado de datos: ${dataStatus.value}")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}