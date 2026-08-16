package com.duoc.saasdeporte.presentation.components.templates

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppScreenTemplate(content: @Composable (PaddingValues) -> Unit) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(AppScreenTemplateStyles.ContentPadding)
        ) {
            content(paddingValues)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppScreenTemplatePreview() {
    MaterialTheme {
        AppScreenTemplate { _ ->
            Text(text = AppScreenTemplateStyles.PREVIEW_TEXT)
        }
    }
}