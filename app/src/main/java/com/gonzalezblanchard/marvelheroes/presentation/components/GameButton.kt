package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.R

@Composable
fun InnerElement(text: String, resourceId:Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = text,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text, Modifier.fillMaxWidth(), color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center)
        Text("Subtitle", Modifier.fillMaxWidth(), color = Color.White, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun GameButton (onClickEvent: () -> Unit){
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),
        onClick = {
            onClickEvent()
        },
        modifier = Modifier.size(width = 196.dp, height = 190.dp).clip(RoundedCornerShape(10.dp)),
    ) {
        InnerElement(text = "Iniciar App", R.mipmap.ic_launcher)
    }
}

@Preview
@Composable
fun PreviewGameButton(){
    GameButton(onClickEvent = {  })
}