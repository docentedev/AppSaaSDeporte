package com.duoc.saasdeporte.presentation.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duoc.saasdeporte.presentation.components.atoms.AppBodyText
import com.duoc.saasdeporte.presentation.components.atoms.AppTitleText

@Composable
fun ScreenHeader(title: String, subtitle: String) {
    Column {
        AppTitleText(text = title)
        Spacer(modifier = Modifier.height(ScreenHeaderStyles.SubtitleSpacing))
        AppBodyText(text = subtitle)
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenHeaderPreview() {
    MaterialTheme {
        ScreenHeader(
            title = ScreenHeaderStyles.PREVIEW_TITLE,
            subtitle = ScreenHeaderStyles.PREVIEW_SUBTITLE
        )
    }
}