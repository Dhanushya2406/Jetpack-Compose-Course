package com.dhanu.trailproject.superheros

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhanu.trailproject.R
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class SuperHeros : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHerosApp()
                }
            }
        }
    }
}


@Composable
fun SuperHerosApp() {
    Scaffold(
        topBar = {
            SuperHerosTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it){
            items(HeroesRepository.heroes){
                SuperHerosItem(
                    heros = it,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
        
    }
}


@Composable
fun SuperHerosItem(heros: Heros, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)){
                SuperHerosInformation(
                    dogName = heros.herosName,
                    dogDescription = heros.herosDescription
                )
            }
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                SuperHerosIcon(dogImage = heros.herosImage)
            }
        }
    }

}

@Composable
fun SuperHerosInformation(
    @StringRes dogName: Int,
    @StringRes dogDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = stringResource(dogDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SuperHerosIcon(@DrawableRes dogImage: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.superheros_image_size))
            .padding(dimensionResource(R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(dogImage),
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHerosTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.superhero_app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}


@Preview (showBackground = true)
@Composable
fun SuperHerosPreview() {
    TrailProjectTheme(darkTheme = false) {
        SuperHerosApp()
    }
}

@Preview (showBackground = true)
@Composable
fun SuperHerosDarkThemePreview() {
    TrailProjectTheme(darkTheme = true) {
        SuperHerosApp()
    }
}


