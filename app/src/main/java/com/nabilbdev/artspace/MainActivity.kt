package com.nabilbdev.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nabilbdev.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    Column(
        modifier = Modifier.padding(
            top = 132.dp,
            bottom = 32.dp,
            start = 32.dp,
            end = 32.dp
        )
    ) {
        ArtworkWall()
    }
}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.graffiti_01),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.artwork_title_01),
        modifier = modifier
            .fillMaxHeight(0.85f)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(14.dp)
            )
    )
}


@Preview(showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}