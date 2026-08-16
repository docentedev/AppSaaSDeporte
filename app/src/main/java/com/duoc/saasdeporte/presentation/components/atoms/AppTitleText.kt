package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppTitleText(text: String) {
    Text(
        text = text,
        style = AppTitleTextStyles.textStyle()
    )
}

@Preview(showBackground = true)
@Composable
private fun AppTitleTextPreview() {
    MaterialTheme {
        AppTitleText(text = AppTitleTextStyles.PREVIEW_TEXT)
    }
}