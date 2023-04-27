package com.techsultan.spotifyclone.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techsultan.spotifyclone.R
import com.techsultan.spotifyclone.ui.theme.Black
import com.techsultan.spotifyclone.ui.theme.Pink40
import com.techsultan.spotifyclone.ui.theme.Pink80
import com.techsultan.spotifyclone.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun SearchScreen() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(color = Black),
        topBar = {
            LargeTopAppBar()

        },
        containerColor = Black,
        content = {

            SearchPageScreen()
        }


    )

}

@Composable
fun SearchSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {

        Text(
            text = "Browse all",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(16.dp)
        )

        content()

    }
}

@Composable
fun SearchPageScreen(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    LazyColumn(
        modifier
            .wrapContentSize()
            .padding(vertical = 16.dp)
            .background(color = Black)
    ) {

        item {
                SearchCardGrid()

        }


        }

    }





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBar() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    
    LargeTopAppBar(
        title = {
            Text(
                text = "Search"
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null)

            }
        },
        scrollBehavior = scrollBehavior,

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black,
            titleContentColor = White,
            actionIconContentColor = White
        )
    )

}





@Composable
fun SearchCard(
    modifier: Modifier = Modifier,
    title: String,
    color: Color
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = MaterialTheme.shapes.medium,
        color = Pink40

        ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            
            Text(
                modifier = modifier.padding(8.dp),
                text = "Podcasts",
                style = MaterialTheme.typography.bodyLarge
            )



        }

    }

}

fun LazyGridScope.searchCard(
    modifier: Modifier = Modifier,
    title: String,
    color: Color
){
    item {
        SearchCard(
            modifier = modifier,
            title = title,
            color = color
        )
    }
}

@Composable
fun SearchCardGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
    modifier = modifier.fillMaxHeight(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        searchCard(
            title = "Podcasts",
            color = Pink40
        )
        searchCard(
            title = "Live Events",
            color = Black
        )
        searchCard(
            title = "Made For You",
            color = Color.Blue
        )
        searchCard(
            title = "New releases",
            color = Color.DarkGray
        )
        searchCard(
            title = "Afro",
            color = Color.Magenta
        )
        searchCard(
            title = "Party",
            color = Color.Yellow
        )
        searchCard(
            title = "Hip-Hop",
            color = Color.Green
        )
        searchCard(
            title = "Charts",
            color = Color.Magenta
        )
        searchCard(
            title = "Christian $ Gospel",
            color = Pink80
        )
        searchCard(
            title = "Discover",
            color = Color.White
        )
        searchCard(
            title = "Fresh Finds",
            color = Color.Blue
        )
        searchCard(
            title = "EQUAL",
            color = Color.LightGray
        )
        searchCard(
            title = "RADAR",
            color = Color.Transparent
        )
        searchCard(
            title = "Chill",
            color = Color.Gray
        )
        searchCard(
            title = "Workout",
            color = Color.Green
        )
        searchCard(
            title = "Sleep",
            color = Color.White
        )
        searchCard(
            title = "At Home",
            color = Color.Blue
        )
        searchCard(
            title = "Rock",
            color = Color.DarkGray
        )
        searchCard(
            title = "Decades",
            color = Color.Red
        )
        searchCard(
            title = "Love",
            color = Color.Blue
        )
        searchCard(
            title = "Throwback",
            color = Pink80
        )
    }
}

@Preview
@Composable
fun SearchCardPreview() {

}