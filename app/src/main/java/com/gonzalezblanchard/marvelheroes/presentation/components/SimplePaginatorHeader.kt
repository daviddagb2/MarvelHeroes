package com.gonzalezblanchard.marvelheroes.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.ui.theme.red
import com.gonzalezblanchard.marvelheroes.ui.theme.selectedColor
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.ui.theme.redDisabled

@Composable
fun SimplePaginatorHeader (
    currentPage: Int,
    maxPages: Int,
    onNextPage: () -> Unit,
    onPreviousPage: () -> Unit,
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 5.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Center)
        {
            Button(onClick = {
                onPreviousPage()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = red)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "drawable icons",
                    tint = Color.White
                )
            } //End Button

            TitleText(value = "Página $currentPage de $maxPages")

            Button(onClick = {
                onNextPage()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = red)) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "drawable icons",
                    tint = Color.White
                )
            } //End Button

        }
    }
}
