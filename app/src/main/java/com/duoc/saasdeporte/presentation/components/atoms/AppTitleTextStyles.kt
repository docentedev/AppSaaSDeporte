package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

object AppTitleTextStyles {
    @Composable
    fun textStyle(): TextStyle = MaterialTheme.typography.headlineSmall

    const val PREVIEW_TEXT: String = "Titulo de ejemplo"
}