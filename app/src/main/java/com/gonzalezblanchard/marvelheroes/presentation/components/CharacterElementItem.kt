package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem
import com.gonzalezblanchard.marvelheroes.presentation.view.navigation.Actions
import com.gonzalezblanchard.marvelheroes.ui.theme.red


@Composable
fun CharacterElementItem(
    character: CharacterItem,
    action: Actions
) {
    Column(
        modifier = Modifier.padding(10.dp)
            .width(130.dp)
            .clickable {
                action.characterDetails.invoke(character.id.toString())
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imagenCharacter = character.thumbnail.path + "." + character.thumbnail.extension

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagenCharacter)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
        )

        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(
            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            text = character.name,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.marvel_regular)),
                fontSize = 18.sp,
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row {
            Divider(startIndent = 8.dp, thickness = 1.dp, color = red)
        }
    }
}