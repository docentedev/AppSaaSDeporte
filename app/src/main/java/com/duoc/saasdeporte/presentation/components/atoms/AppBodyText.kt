package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppBodyText(text: String) {
    Text(
        text = text,
        style = AppBodyTextStyles.textStyle()
    )
}

@Preview(showBackground = true)
@Composable
private fun AppBodyTextPreview() {
    MaterialTheme {
        AppBodyText(text = AppBodyTextStyles.PREVIEW_TEXT)
    }
}