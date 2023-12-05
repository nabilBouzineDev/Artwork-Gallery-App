package com.nabilbdev.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column(
        modifier = Modifier
            .padding(32.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            ArtworkWall()
            ArtworkDescriptor()
        }
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

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Surface(
        color = Color.LightGray.copy(0.55f),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(14.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.artwork_title_01),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.artwork_artist_01),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = DarkBleu
                )
                Text(
                    text = stringResource(id = R.string.artwork_year_01),
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
