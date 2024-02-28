package com.example.composemovieapp.presentation.ui.core.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composemovieapp.R
import com.example.composemovieapp.domain.base.AnotherError
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.extensions.isNetworkError
import com.example.composemovieapp.presentation.util.fonts.dp40
import com.example.composemovieapp.presentation.util.fonts.interMedium
import com.example.composemovieapp.presentation.util.fonts.interRegular
import com.example.composemovieapp.presentation.util.fonts.titleSmallLineHeight

@Composable
fun ShowError(
    throwable: Throwable,
    onConfirmation: () -> Unit,
) {
    when {
        throwable is AnotherError -> BaseErrorScreen(onConfirmation = { onConfirmation.invoke() })

        isNetworkError(throwable) -> NetworkErrorScreen(onConfirmation = { onConfirmation.invoke() })

        else -> BaseErrorScreen(onConfirmation = { onConfirmation.invoke() })
    }
}


@Composable
private fun ErrorScreen(
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogDescription: String,
    icon: ImageBitmap,
) {
    AlertDialog(
        containerColor = MovieTheme.colors.colorSurfaceContainerHigh,
        icon = {
            Image(
                bitmap = icon,
                contentDescription = null,
                modifier = Modifier.size(dp40)
            )
        },
        title = {
            Text(
                text = dialogTitle,
                fontSize = titleSmallLineHeight,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = interMedium
            )
        },
        text = {
            Text(
                text = dialogDescription,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = interRegular
            )
        },

        onDismissRequest = {},

        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    stringResource(id = R.string.dialog_retry),
                    fontFamily = interRegular
                )
            }
        },
    )
}

@Composable
fun NetworkErrorScreen(
    onConfirmation: () -> Unit,
) {
    val imageBitmap = ImageBitmap.imageResource(R.drawable.no_signal)

    ErrorScreen(
        onConfirmation = { onConfirmation.invoke() },
        dialogTitle = stringResource(id = R.string.error_connection_title),
        dialogDescription = stringResource(id = R.string.error_connection_subtitle),
        icon = imageBitmap
    )
}


@Composable
private fun BaseErrorScreen(
    onConfirmation: () -> Unit,
) {
    val imageBitmap = ImageBitmap.imageResource(R.drawable.base_error)
    ErrorScreen(
        onConfirmation = { onConfirmation.invoke() },
        dialogTitle = stringResource(id = R.string.error_base_title),
        dialogDescription = stringResource(id = R.string.server_connection_error),
        icon = imageBitmap
    )
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    MaterialTheme {
        val imageBitmap = ImageBitmap.imageResource(R.drawable.base_error)
        ErrorScreen(
            onConfirmation = {},
            dialogTitle = "Alert dialog example",
            dialogDescription = "This is an example of an alert dialog with buttons.",
            icon = imageBitmap
        )
    }
}