package com.techsultan.spotifyclone.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.techsultan.spotifyclone.BottomBarScreen
import com.techsultan.spotifyclone.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Transparent,
                contentColor = White,
                content = {
                    BottomBar(navController = navController)
                }
            )
        }
    ) {
        BottomNavGraph(navController = navController)

    }
}

@Composable
fun BottomBar(
    navController: NavHostController,

) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Library
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    
    BottomNavigation {
        screens.forEach { bottomBarScreen ->
            AddItem(screen = bottomBarScreen, currentDestination = currentDestination, navController = navController)
        }
    }

    }

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){

    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        } ,
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = null,
                tint = White
            )
        },
        selected = currentDestination?.hierarchy?.any() {
            it.route == screen.route
        } == true,

        onClick = {
            navController.navigate(screen.route)
        }
    )

}

