package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem
import com.gonzalezblanchard.marvelheroes.presentation.components.TitleText
import com.gonzalezblanchard.marvelheroes.presentation.components.appbars.AppBarGoBack
import com.gonzalezblanchard.marvelheroes.presentation.components.appbars.DefaultAppBar
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharacterDetailViewModel
import com.gonzalezblanchard.marvelheroes.ui.theme.red

@Composable
fun CharacterDetailScreen(
    navController: NavController,
    id:String,
    characterVM: CharacterDetailViewModel = hiltViewModel()
) {

    val mContext = LocalContext.current
    val character by characterVM.characterItemState.observeAsState()
    val isLoading by characterVM.isLoading.observeAsState()

    characterVM.getCharacterDetail(id.toInt())
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            AppBarGoBack(
                title = character?.name ?: "",
                onBackClicked = { navController.popBackStack() }
            )
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {

            Column(modifier = Modifier.fillMaxSize()) {
                BoxWithConstraints(modifier = Modifier.weight(1f)) {
                    Surface {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(scrollState),
                        ) {

                            character?.let {
                                CharacterHeader(
                                    scrollState = ScrollState(0),
                                    character = it,
                                    containerHeight = this@BoxWithConstraints.maxHeight
                                )

                                CharacterContent(it, this@BoxWithConstraints.maxHeight, navController)
                            }

                        }
                    }

                }
            }

        }

        }
    }

@Composable
private fun CharacterHeader(
    scrollState: ScrollState,
    character: CharacterItem,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    val imagenCharacter = character.thumbnail.path + "." + character.thumbnail.extension
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imagenCharacter)
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )

    if (painter.state is AsyncImagePainter.State.Success) {
        Log.d("CharacterDetailScreen", "Success")
    } else if (painter.state is AsyncImagePainter.State.Error) {
        Log.d("CharacterDetailScreen", "Error")
    }

    Image(
        painter = painter,
        contentDescription = character.name,
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),

        contentScale = ContentScale.Crop,
    )
}


@Composable
private fun CharacterContent(character: CharacterItem, containerHeight: Dp, navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(8.dp))

        TitleText(character.name)

        if(character.description.isEmpty() || character.description.trim().isEmpty()){
            Text(
                text = stringResource(R.string.str_empty_desc),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.marvel_regular)),
                    fontSize = 16.sp,
                ),
                modifier = Modifier.padding(20.dp)
            )
        }else{
            ProfileProperty(stringResource(R.string.str_description), character.description)
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(1.dp, Color.Transparent, RectangleShape)
                .fillMaxWidth()
                .padding(20.dp)) {
            Button(onClick = {
                navController.popBackStack()
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = red),
            ) {
                Text(text = "Regresar")
            }
        }

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                style = MaterialTheme.typography.caption,
                color = Color.White
            )
        }

        Text(
            text = value,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.marvel_regular)),
                fontSize = 15.sp,
            ),
        )
    }
}


