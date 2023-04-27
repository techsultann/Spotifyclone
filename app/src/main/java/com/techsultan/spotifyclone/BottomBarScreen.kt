package com.techsultan.spotifyclone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home,
    )
    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Outlined.Search
    )
    object Library : BottomBarScreen(
        route = "library",
        title = "Your Library",
        icon = Icons.Filled.Person
    )
}
