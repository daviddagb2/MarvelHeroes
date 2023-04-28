package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalezblanchard.marvelheroes.presentation.components.MyText
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem
import com.gonzalezblanchard.marvelheroes.presentation.components.CharacterElementItem


private val characters: List<CharacterItem> = listOf(
    CharacterItem(1, "Iron Man",
        "Tony Stark",
        "2023000202",
        ThumbnailItem(
            "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            "jpg"
        ),
        "http://gateway.marvel.com/v1/public/characters/1017851"
    ),
    CharacterItem(1, "Iron Man",
        "Tony Stark",
        "2023000202",
        ThumbnailItem(
            "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            "jpg"
        ),
        "http://gateway.marvel.com/v1/public/characters/1017851"
    ),
    CharacterItem(1, "Iron Man",
        "Tony Stark",
        "2023000202",
        ThumbnailItem(
            "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            "jpg"
        ),
        "http://gateway.marvel.com/v1/public/characters/1017851"
    ),
    CharacterItem(1, "Iron Man",
        "Tony Stark",
        "2023000202",
        ThumbnailItem(
            "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            "jpg"
        ),
        "http://gateway.marvel.com/v1/public/characters/1017851"
    ),
)


@Composable
fun CharacterText(character: CharacterItem){

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {

        }) {

        Row(modifier = Modifier.padding(5.dp)) {
            MyImage()
            Spacer(modifier = Modifier.width(20.dp))
            MyText(character.name,
                MaterialTheme.colors.onBackground,
                MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.character_icon_white),
        "",
        Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(32.dp)
            .padding(8.dp)
    )
}

@Composable
fun MyComponent(character: CharacterItem){
    Row (modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        CharacterText(character = character)
    }
}



@Composable
fun CharacterList(isDisplayed: Boolean, characters: List<CharacterItem>){
    if (isDisplayed) {
        LazyColumn(){
            items(characters){
                CharacterElementItem(character = it)
            }
        }
    }
}

@Composable
fun CharacterListGrid(isDisplayed: Boolean, characters: List<CharacterItem>){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(characters) { character ->
           // MyComponent(character = character)
            CharacterElementItem(character = character)
        }
    }
}

@Preview
@Composable
fun previewMyCategories(){
    CharacterListGrid(true, characters = characters)
}