package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

object AppBodyTextStyles {
    @Composable
    fun textStyle(): TextStyle = MaterialTheme.typography.bodyMedium

    const val PREVIEW_TEXT: String = "Texto de apoyo para descripción"
}