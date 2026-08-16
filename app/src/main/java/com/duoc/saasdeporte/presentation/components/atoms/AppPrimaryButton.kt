package com.duoc.saasdeporte.presentation.components.atoms

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppPrimaryButton(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(AppPrimaryButtonStyles.CORNER_RADIUS),
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val targetContainerColor = when {
        !enabled -> AppPrimaryButtonStyles.DISABLED_CONTAINER_COLOR
        isPressed -> AppPrimaryButtonStyles.PRESSED_CONTAINER_COLOR
        else -> AppPrimaryButtonStyles.CONTAINER_COLOR
    }
    val animatedContainerColor by animateColorAsState(
        targetValue = targetContainerColor,
        label = "appPrimaryButtonContainer"
    )

    val contentColor = if (enabled) {
        AppPrimaryButtonStyles.CONTENT_COLOR
    } else {
        AppPrimaryButtonStyles.DISABLED_CONTENT_COLOR
    }

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        interactionSource = interactionSource,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = animatedContainerColor,
            contentColor = contentColor,
            disabledContainerColor = AppPrimaryButtonStyles.DISABLED_CONTAINER_COLOR,
            disabledContentColor = AppPrimaryButtonStyles.DISABLED_CONTENT_COLOR
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = AppPrimaryButtonStyles.DEFAULT_ELEVATION,
            pressedElevation = AppPrimaryButtonStyles.PRESSED_ELEVATION,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = label)
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPrimaryButtonPreview() {
    MaterialTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AppPrimaryButton(label = AppPrimaryButtonStyles.PREVIEW_LABEL, onClick = {})
            AppPrimaryButton(label = "Deshabilitado", onClick = {}, enabled = false)
        }
    }
}