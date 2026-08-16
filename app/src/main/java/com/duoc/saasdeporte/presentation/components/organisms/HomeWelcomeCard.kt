package com.duoc.saasdeporte.presentation.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duoc.saasdeporte.presentation.components.atoms.AppPrimaryButton
import com.duoc.saasdeporte.presentation.components.molecules.ScreenHeader

@Composable
fun HomeWelcomeCard(onPrimaryAction: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(HomeWelcomeCardStyles.ContentPadding),
            verticalArrangement = Arrangement.spacedBy(HomeWelcomeCardStyles.ContentSpacing)
        ) {
            ScreenHeader(
                title = HomeWelcomeCardStyles.TITLE,
                subtitle = HomeWelcomeCardStyles.SUBTITLE
            )
            AppPrimaryButton(label = HomeWelcomeCardStyles.BUTTON_LABEL) {
                onPrimaryAction()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeWelcomeCardPreview() {
    MaterialTheme {
        HomeWelcomeCard(onPrimaryAction = {})
    }
}