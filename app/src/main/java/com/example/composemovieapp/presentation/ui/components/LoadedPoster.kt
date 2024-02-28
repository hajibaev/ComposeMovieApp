package com.example.composemovieapp.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers


@Composable
fun LoadedPoster(
    modifier: Modifier = Modifier,
    url: String,
//    placeholder: Int = R.drawable.ic_placeholder,
) {

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .dispatcher(Dispatchers.IO)
        .data(url)
        .memoryCacheKey(url)
        .diskCacheKey(url)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
