package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.ui.theme.red
import com.gonzalezblanchard.marvelheroes.ui.theme.selectedColor
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.ui.theme.redDisabled

@Composable
fun SimplePaginator (
    currentPage: Int,
    maxPages: Int,
    onNextPage: () -> Unit,
    onPreviousPage: () -> Unit,
    onGoToPage: (Int) -> Unit,
    showHeader: Boolean = false,
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {

        if(showHeader) {
            SimplePaginatorHeader(
                currentPage = currentPage,
                maxPages = maxPages,
                onNextPage = onNextPage,
                onPreviousPage = onPreviousPage,
            )
        }
        val currentPageIndex = currentPage - 1 // Convertimos el número de página a un índice de array (comenzando en 0)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ){
            val start = (currentPage - 2).coerceAtLeast(1)
            val end = maxPages.coerceAtMost(currentPage + 1)

            if (start > 2) {
                DefaultButtonPage(onGoToPage, currentPageIndex, 1) // GO to first page
                if (start > 3) {
                    OnlyButton(
                        "..."
                    ) { onGoToPage(start - 1) }
                }
            }

            for (i in start..end) {
                DefaultButtonPage(onGoToPage, currentPageIndex, i)
            } //End For

            if (end < maxPages) {
                if (end < maxPages - 1) {
                    OnlyButton(
                        "..."
                    ) { onGoToPage(end + 1) }
                }
                DefaultButtonPage(onGoToPage, currentPageIndex, maxPages) // Go to last page
            }
        }

    }
}



@Composable
fun DefaultButtonPage(onGoToPage: (Int) -> Unit, currentPageIndex: Int, i: Int){
    val isSelected = (i - 1 == currentPageIndex)
    val value = if (i < 10) "0$i" else "$i"
    Text(
        text = "$value",
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.marvel_regular)),
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(10.dp) // margin
            .border(10.dp, Color.Transparent) // outer border
            .background(
                color = if (isSelected) selectedColor else red,
                shape = RoundedCornerShape(1.dp)
            )
            .padding(5.dp) // margin
            .clickable {
                onGoToPage(i)
            }

    )
}


@Composable
fun OnlyButton(value:String, onClick : () -> Unit){
    //End Button

    Text(
        text = "$value",
        color = Color.White,
        fontFamily = FontFamily(Font(R.font.marvel_regular)),
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(10.dp) // margin
            .border(10.dp, Color.Transparent) // outer border
            .background(
                color = redDisabled,
                shape = RoundedCornerShape(1.dp)
            )
            .padding(5.dp) // margin
            .clickable {
               onClick()
            }

    )
}



@Preview
@Composable
fun previewButtonPage(){
    DefaultButtonPage({}, 1, 2)
}