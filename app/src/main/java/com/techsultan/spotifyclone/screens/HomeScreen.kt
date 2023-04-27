package com.techsultan.spotifyclone.screens


import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techsultan.spotifyclone.R
import com.techsultan.spotifyclone.ui.theme.Black70
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.techsultan.spotifyclone.ui.theme.Black
import com.techsultan.spotifyclone.ui.theme.White
import java.util.*
import kotlin.text.Typography


@ExperimentalMaterial3Api
@Composable
fun HomePageScreen() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(Color.Black),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        "Good Afternoon",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                        )

                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Black,
                    titleContentColor = White,
                    actionIconContentColor = White
                )

                )
            Spacer(modifier = Modifier.height(24.dp))
        },
        containerColor = Black,
        content = {

            HomeScreen()

        }
    )
}



@Composable
fun RecentlyPlayedCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes name: Int?
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = Black70,
        contentColor = White

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(200.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp)
            )
            Text(
                modifier = modifier.padding(8.dp),
                text = stringResource(id = name!!),
                style = androidx.compose.material.MaterialTheme.typography.subtitle2,
                color = White
            )

        }

    }

}

@Composable
fun RecentlyPlayedGrid(
    modifier: Modifier = Modifier

) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .requiredHeight(275.dp)
            .padding(top = 56.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        recentlyPlayedCard(
            icon = R.drawable.made_in_lagos,
            name = R.string.mil
        )
        recentlyPlayedCard(
            icon = R.drawable.lucid,
            name = R.string.asa
        )
        recentlyPlayedCard(
            icon = R.drawable.baba_hafusa,
            name = R.string.reminisce
        )
        recentlyPlayedCard(
            icon = R.drawable.eclipse,
            name = R.string.oxlade
        )
        recentlyPlayedCard(
            icon = R.drawable.mmwtv,
            name = R.string.asake
        )
        recentlyPlayedCard(
            icon = R.drawable.outside,
            name = R.string.burna
        )


    }
}

fun LazyGridScope.recentlyPlayedCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes name: Int?

){
    item {
        RecentlyPlayedCard(
            modifier = modifier,
            icon = icon,
            name = name
        )
    }

}

@Preview
@Composable
fun RecentlyPlayedGridPreview() {
    RecentlyPlayedGrid()
}

@Composable
fun ArtCoverCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes name: Int?,
    @StringRes albumTitle: Int?
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = stringResource(id = name!!),
            style = MaterialTheme.typography.subtitle2,
            color = White
        )
        Text(
            text = stringResource(id = albumTitle!!),
            style = MaterialTheme.typography.subtitle2,
            color = White
        )

    }
    
}


@Composable
fun ArtCoverCardRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        artCardRow(
            icon = R.drawable.made_in_lagos,
            name = R.string.mil,
            albumTitle = R.string.wizkid
        )
        artCardRow(
            icon = R.drawable.outside,
            name = R.string.outside,
            albumTitle = R.string.burna
        )
        artCardRow(
            icon = R.drawable.lucid,
            name = R.string.asa,
            albumTitle = R.string.lucid
        )
        artCardRow(
            icon = R.drawable.mmwtv,
            name = R.string.asake,
            albumTitle = R.string.mmwtv
        )
        artCardRow(
            icon = R.drawable.eclipse,
            name = R.string.oxlade,
            albumTitle = R.string.lucid
        )
        artCardRow(
            icon = R.drawable.stories_that_touch,
            name = R.string.falz,
            albumTitle = R.string.stt
        )

    }
}

fun LazyListScope.artCardRow(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes name: Int?,
    @StringRes albumTitle: Int?
) {
    item {
        ArtCoverCard(
            icon = icon,
            name = name,
            albumTitle = albumTitle
        )

    }
}

@Preview
@Composable
fun ArtCoverRowPreview() {
    ArtCoverCardRow(

    )
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Implement composable here
    Column(modifier) {

        Text(
            text = stringResource(title),
            style = androidx.compose.material.MaterialTheme.typography.h5,
            color = androidx.compose.material.MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)


        )

        content()

    }
}



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),

) {
    // Implement composable here
    Column(
        modifier
            .verticalScroll(state = scrollState)
            .padding(vertical = 16.dp)
            .background(color = Black)
    ) {

        RecentlyPlayedGrid()
        HomeSection(title = R.string.jump_back_in) {
            ArtCoverCardRow()

        }

        HomeSection(title = R.string.made_for_sultan) {
            ArtCoverCardRow()

        }
        HomeSection(title = R.string.recently_played) {
            ArtCoverCardRow()
            
        }
        Spacer(modifier = Modifier.padding(16.dp))
    }
}


@Preview
@Composable
fun RecentlyPlayedCarPreview(){
    RecentlyPlayedCard(
        icon = R.drawable.made_in_lagos,
        name = R.string.mil)
}

@Preview
@Composable
fun ArtCoverCarPreview() {
    ArtCoverCard(
        icon = R.drawable.stories_that_touch,
        name = R.string.falz,
        albumTitle = R.string.stt
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewScrollableTopAppBar() {
    HomePageScreen()
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}