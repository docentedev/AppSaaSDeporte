package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppPrimaryButton(label: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = label)
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPrimaryButtonPreview() {
    MaterialTheme {
        AppPrimaryButton(label = AppPrimaryButtonStyles.PREVIEW_LEVEL) {}
    }
}