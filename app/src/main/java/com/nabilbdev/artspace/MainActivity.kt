package com.nabilbdev.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nabilbdev.artspace.ui.theme.ArtSpaceTheme
import com.nabilbdev.artspace.ui.theme.ButtonBackground
import com.nabilbdev.artspace.ui.theme.DarkBleu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
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

    var result by remember { mutableIntStateOf(1) }
    var nextClicked by remember { mutableStateOf({}) }
    var prevClicked by remember { mutableStateOf({}) }

    Column(
        modifier = Modifier
            .padding(32.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {

            when (result) {
                1 -> {
                    ArtworkWall(
                        imageResource = R.drawable.graffiti_01,
                        contentDescription = R.string.artwork_title_01
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_01,
                        artist = R.string.artwork_artist_01,
                        publishYear = R.string.artwork_year_01
                    )
                    nextClicked = { result = 2 }
                    prevClicked = { result -= 1 }
                }

                2 -> {
                    ArtworkWall(
                        imageResource = R.drawable.candles_02,
                        contentDescription = R.string.artwork_title_02
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_02,
                        artist = R.string.artwork_artist_02,
                        publishYear = R.string.artwork_year_02
                    )
                    nextClicked = { result = 3 }
                    prevClicked = { result -= 1 }
                }

                3 -> {
                    ArtworkWall(
                        imageResource = R.drawable.house_03,
                        contentDescription = R.string.artwork_title_03
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_03,
                        artist = R.string.artwork_artist_03,
                        publishYear = R.string.artwork_year_03
                    )
                    nextClicked = { result = 4 }
                    prevClicked = { result -= 1 }
                }

                4 -> {
                    ArtworkWall(
                        imageResource = R.drawable.abstract_04,
                        contentDescription = R.string.artwork_title_04
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_04,
                        artist = R.string.artwork_artist_04,
                        publishYear = R.string.artwork_year_04
                    )
                    nextClicked = { result = 5 }
                    prevClicked = { result -= 1 }
                }

                5 -> {
                    ArtworkWall(
                        imageResource = R.drawable.modern_05,
                        contentDescription = R.string.artwork_title_05
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_05,
                        artist = R.string.artwork_artist_05,
                        publishYear = R.string.artwork_year_05
                    )
                    nextClicked = { result = 6 }
                    prevClicked = { result -= 1 }
                }

                6 -> {
                    ArtworkWall(
                        imageResource = R.drawable.heart_06,
                        contentDescription = R.string.artwork_title_06
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_06,
                        artist = R.string.artwork_artist_06,
                        publishYear = R.string.artwork_year_06
                    )
                    nextClicked = { result = 7 }
                    prevClicked = { result -= 1 }
                }

                7 -> {
                    ArtworkWall(
                        imageResource = R.drawable.jellyfish_07,
                        contentDescription = R.string.artwork_title_07
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_07,
                        artist = R.string.artwork_artist_07,
                        publishYear = R.string.artwork_year_07
                    )
                    nextClicked = { result = 8 }
                    prevClicked = { result -= 1 }
                }

                else -> {
                    ArtworkWall(
                        imageResource = R.drawable.icecream_08,
                        contentDescription = R.string.artwork_title_08
                    )
                    ArtworkDescriptor(
                        title = R.string.artwork_title_08,
                        artist = R.string.artwork_artist_08,
                        publishYear = R.string.artwork_year_08
                    )
                    nextClicked = { result = 1 }
                    prevClicked = { result = 7 }
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        DisplayController(
            onPrevClick = prevClicked,
            onNextClick = nextClicked
        )
    }
}

@Composable
fun DisplayController(
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonBackground
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
            onClick = onPrevClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.previous_button),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = DarkBleu
            )
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonBackground
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.next_button),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = DarkBleu
            )
        }
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes imageResource: Int,
    @StringRes contentDescription: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imageResource),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = contentDescription),
        modifier = modifier
            .fillMaxHeight(0.85f)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(14.dp)
            )
    )
}

@Composable
fun ArtworkDescriptor(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes publishYear: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = Color.LightGray.copy(0.45f),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = stringResource(id = title),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = artist),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = DarkBleu
                )
                Text(
                    text = stringResource(id = publishYear),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}
