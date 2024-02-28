package com.example.composemovieapp.presentation.ui.components.items

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composemovieapp.presentation.model.app.AppTheme
import com.example.composemovieapp.presentation.model.app.AppearanceModel
import com.example.composemovieapp.presentation.model.app.appearanceItems
import com.example.composemovieapp.presentation.ui.core.colors.LocalThemeIsDark
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.util.fonts.dp18
import com.example.composemovieapp.presentation.util.fonts.dp2
import com.example.composemovieapp.presentation.util.fonts.dp50
import com.example.composemovieapp.presentation.util.fonts.dp6
import compose.icons.FeatherIcons
import compose.icons.feathericons.Check
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppearanceBottomSheet(
    dialogState: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    val isDarkTheme = LocalThemeIsDark.current

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch { modalBottomSheetState.hide() }
            dialogState.invoke(false)
        },
        sheetState = modalBottomSheetState
    ) {
        LazyColumn(modifier = modifier.padding(vertical = dp6)) {
            items(
                items = appearanceItems(isDarkTheme.value),
                key = { item -> item.id }
            ) { item ->
                AppearanceBottomSheetItem(
                    data = item,
                    dialogState = dialogState,
                    changeTheme = { isDarkTheme.value = !isDarkTheme.value },
                    theme = if (isDarkTheme.value) AppTheme.Dark else AppTheme.Light
                )
            }
        }
    }
}


@Composable
fun AppearanceBottomSheetItem(
    data: AppearanceModel,
    dialogState: (Boolean) -> Unit,
    theme: AppTheme,
    changeTheme: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Log.i("Umar","data.theme = ${data.theme} theme =$theme")
    Row(
        modifier
            .fillMaxWidth()
            .height(dp50)
            .clickable {
                changeTheme.invoke()
                dialogState.invoke(false)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = dp18),
            text = stringResource(id = data.title),
            style = MovieTheme.typography.bodyLarge,
        )
        if (data.theme == theme) {
            Icon(
                imageVector = FeatherIcons.Check,
                contentDescription = null,
                tint = MovieTheme.colors.colorPrimary,
                modifier = Modifier.padding(horizontal = dp18)
            )
        }
    }
    Divider(modifier = Modifier.padding(vertical = dp2))
}
