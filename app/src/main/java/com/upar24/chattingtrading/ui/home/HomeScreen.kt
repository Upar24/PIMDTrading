package com.upar24.chattingtrading.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.upar24.chattingtrading.ui.component.AdvertView
import com.upar24.chattingtrading.util.KangDooShik.arts
import com.upar24.chattingtrading.util.KangDooShik.calculation
import com.upar24.chattingtrading.util.KangDooShik.chatchar
import com.upar24.chattingtrading.util.KangDooShik.partychar

@Composable
fun HomeScreen(navController: NavHostController
) {
    val homeVM= hiltViewModel<HomeViewModel>()
    var visibleHome by remember { mutableStateOf(calculation)}
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 60.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column{
            var tabIndex by remember { mutableStateOf(1)}
            val homeItem = listOf(partychar, calculation,chatchar)
            TabRow(selectedTabIndex = tabIndex,Modifier.fillMaxWidth(),
                backgroundColor = Color.Transparent) {
                homeItem.forEachIndexed { index,text ->
                    Tab(selected=tabIndex==index,onClick={
                        tabIndex=index
                        visibleHome=text
                    },text={
                        Text(text,color=if (visibleHome == text) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
                            style = if (visibleHome == text) MaterialTheme.typography.h2 else MaterialTheme.typography.button
                        )
                    })
                }
            }
            if(visibleHome== partychar){
                homeVM.getToday()
                homeVM.getDropList()
                homeVM.getPartyList(arts)
                PartyScreen(navController)
            }else if(visibleHome== chatchar){
                homeVM.getChat()
                ChatScreen(navController)
            }else{
                CalculationScreen()
            }
        }
        AdvertView()
    }
}