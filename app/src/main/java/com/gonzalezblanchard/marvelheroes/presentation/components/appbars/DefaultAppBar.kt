package com.gonzalezblanchard.marvelheroes.presentation.components.appbars

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.ui.theme.colorHeaderMarvel
import com.gonzalezblanchard.marvelheroes.R

@Composable
fun DefaultAppBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = "Marvel Heroes",
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.marvel_bold)),
                    fontSize = 24.sp,
                    color = Color.White,
                ),
            )
        },
        backgroundColor = colorHeaderMarvel,
        actions = {
            IconButton(
                onClick = { onSearchClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        },

    )
    
}

@Composable
fun SearchAppBar(
    text:String,
    onTextChange:(String) -> Unit,
    onCloseClicked:() -> Unit,
    onSearchClicked: (String) -> Unit
){
    Surface(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(56.dp)
        ,
        color = colorHeaderMarvel,
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(value = text,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                    onTextChange(it)
                },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Buscar personajes",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.marvel_italic)),
                fontSize = 24.sp,
                color = Color.White,
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = { /*
                        onSearchClicked()
                    */
                    }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                }
            },

            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {
                        if(text.isNotEmpty()){
                            onTextChange("")
                        }else{
                            onCloseClicked()
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.White
                    )
                }
            },

            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium),
            )

        )
    }
}

@Composable
@Preview(
    name = "AppBarPrev",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
fun DefautAppBarPreview(){
    DefaultAppBar(onSearchClicked = {})
}


@Composable
@Preview(
    name = "SearchAppBarPrev",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
fun SearchAppBarPreview(){
    SearchAppBar(
        text = "Some Random text",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}