package com.upar24.chattingtrading.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.upar24.chattingtrading.R
import com.upar24.chattingtrading.ui.component.AdvertView
import com.upar24.chattingtrading.ui.component.DividerIklan
import com.upar24.chattingtrading.ui.component.DividerItem

@Composable
fun TipsTricksScreen(){
    AdvertView()
    DividerIklan()
    Column (
        Modifier
            .fillMaxSize()
            .padding(8.dp),verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Still Empty :(",color= MaterialTheme.colors.onBackground)
        Spacer(Modifier.padding(10.dp))
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Start,verticalAlignment = Alignment.CenterVertically){
            Image(painter= painterResource(R.drawable.email),modifier=Modifier.size(48.dp),contentDescription="")
            Spacer(Modifier.padding(5.dp))
            Column {
                Text("Send your Feedback & Support",color= MaterialTheme.colors.onBackground)
                SelectionContainer {
                    Text("chattingtrading@gmail.com",color= MaterialTheme.colors.onBackground)
                }
            }
        }
    }
}