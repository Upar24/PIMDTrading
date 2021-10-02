package com.upar24.chattingtrading.ui.component

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.upar24.chattingtrading.ui.auth.AuthViewModel
import com.upar24.chattingtrading.util.KangDooShik.BUYING_RATE
import com.upar24.chattingtrading.util.KangDooShik.INTEREST_RATE
import com.upar24.chattingtrading.util.KangDooShik.KEY_LOGGED_IN_USERNAME
import com.upar24.chattingtrading.util.KangDooShik.MAXPLUMBERVALUE
import com.upar24.chattingtrading.util.KangDooShik.NO_USERNAME
import com.upar24.chattingtrading.util.KangDooShik.T10L1
import com.upar24.chattingtrading.util.KangDooShik.T10L2
import com.upar24.chattingtrading.util.KangDooShik.T10L3
import com.upar24.chattingtrading.util.KangDooShik.T10L4
import com.upar24.chattingtrading.util.KangDooShik.T11L1
import com.upar24.chattingtrading.util.KangDooShik.T11L2
import com.upar24.chattingtrading.util.KangDooShik.T11L3
import com.upar24.chattingtrading.util.KangDooShik.T11L4
import com.upar24.chattingtrading.util.KangDooShik.T1L1
import com.upar24.chattingtrading.util.KangDooShik.T1L2
import com.upar24.chattingtrading.util.KangDooShik.T1L3
import com.upar24.chattingtrading.util.KangDooShik.T1L4
import com.upar24.chattingtrading.util.KangDooShik.T2L1
import com.upar24.chattingtrading.util.KangDooShik.T2L2
import com.upar24.chattingtrading.util.KangDooShik.T2L3
import com.upar24.chattingtrading.util.KangDooShik.T2L4
import com.upar24.chattingtrading.util.KangDooShik.T3L1
import com.upar24.chattingtrading.util.KangDooShik.T3L2
import com.upar24.chattingtrading.util.KangDooShik.T3L3
import com.upar24.chattingtrading.util.KangDooShik.T3L4
import com.upar24.chattingtrading.util.KangDooShik.T4L1
import com.upar24.chattingtrading.util.KangDooShik.T4L2
import com.upar24.chattingtrading.util.KangDooShik.T4L3
import com.upar24.chattingtrading.util.KangDooShik.T4L4
import com.upar24.chattingtrading.util.KangDooShik.T5L1
import com.upar24.chattingtrading.util.KangDooShik.T5L2
import com.upar24.chattingtrading.util.KangDooShik.T5L3
import com.upar24.chattingtrading.util.KangDooShik.T5L4
import com.upar24.chattingtrading.util.KangDooShik.T6L1
import com.upar24.chattingtrading.util.KangDooShik.T6L2
import com.upar24.chattingtrading.util.KangDooShik.T6L3
import com.upar24.chattingtrading.util.KangDooShik.T6L4
import com.upar24.chattingtrading.util.KangDooShik.T7L1
import com.upar24.chattingtrading.util.KangDooShik.T7L2
import com.upar24.chattingtrading.util.KangDooShik.T7L3
import com.upar24.chattingtrading.util.KangDooShik.T7L4
import com.upar24.chattingtrading.util.KangDooShik.T8L1
import com.upar24.chattingtrading.util.KangDooShik.T8L2
import com.upar24.chattingtrading.util.KangDooShik.T8L3
import com.upar24.chattingtrading.util.KangDooShik.T8L4
import com.upar24.chattingtrading.util.KangDooShik.T9L1
import com.upar24.chattingtrading.util.KangDooShik.T9L2
import com.upar24.chattingtrading.util.KangDooShik.T9L3
import com.upar24.chattingtrading.util.KangDooShik.T9L4
import com.upar24.chattingtrading.util.KangDooShik.TSVALUE
import com.upar24.chattingtrading.util.KangDooShik.nope
import com.upar24.chattingtrading.util.KangDooShik.ts
import java.text.NumberFormat
import kotlin.math.roundToLong

class TextFieldState(string: String=""){
    var text : String by mutableStateOf(string)
}

fun getTimePost(timePost: Long): String {
    val endTime = System.currentTimeMillis()
    val diff = (endTime - timePost) / 1000
    return if (diff >= 86400) {
        if ((diff < 172799)) "1 day" else "${
            NumberFormat.getNumberInstance().format(diff / 86400)
        } days"
    } else if (diff >= 3600) {
        if ((diff < 7199)) "1 hour" else "${
            NumberFormat.getNumberInstance().format(diff / 3600)
        } hours"
    } else if (diff >= 60) {
        if ((diff < 119)) "1 minute" else "${
            NumberFormat.getNumberInstance().format(diff / 60)
        } minutes"
    } else if ((diff == 1.toLong())) "1 second" else "${
        NumberFormat.getNumberInstance().format(diff)
    } seconds"
}
@Composable
fun getUsernameLoginFunction():String{
    val authVM = hiltViewModel<AuthViewModel>()
    return authVM.sharedPref.getString(KEY_LOGGED_IN_USERNAME,NO_USERNAME) ?: NO_USERNAME
}
@Composable
fun GetAuthenticateFunction(){
    val authVM = hiltViewModel<AuthViewModel>()
    authVM.isLoggedIn()
    authVM.authenticateApi(authVM.usernamevm ?: "", authVM.passwordvm ?: "")
}

fun navigateRouteFunction(
    navController: NavHostController,
    route:String
){
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let {
            popUpTo(it) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}
fun hoppingValueFunction(init:Long,limit:Long,request:String):String{
    var initValue = init
    var hoppingTimes=0
    var interest : Long= 0
    if(limit < initValue) return "Limit value cant be less than init value"
    else if(limit == initValue) return "0"
    else{
        while(limit > initValue){
            if((initValue * BUYING_RATE).roundToLong() > limit)break else{
                hoppingTimes += 1
                interest += (initValue * INTEREST_RATE).roundToLong()
                initValue = (initValue * BUYING_RATE).roundToLong()
            }
        }
    }

    return when (request) {
        "A" -> NumberFormat.getNumberInstance().format(hoppingTimes)
        "B" -> NumberFormat.getNumberInstance().format(interest)
        else -> NumberFormat.getNumberInstance().format(initValue)
    }
}
fun upgradeFunction(current:Long,drop:Long,hire:Long):String{
    return NumberFormat.getNumberInstance().format(current - drop + hire)
}
fun valueOfTheTier(tier:String):Long {
    val value: Long
    when(tier){
        nope -> value= 0
        T1L1 -> value= 14
        T1L2 -> value= 28
        T1L3 -> value=56
        T1L4 -> value=112
        T2L1 -> value= 126
        T2L2 -> value= 188
        T2L3 -> value=282
        T2L4 -> value=424
        T3L1 -> value= 840
        T3L2 -> value= 1260
        T3L3 -> value=1890
        T3L4 -> value=2834
        T4L1 -> value= 3402
        T4L2 -> value= 5104
        T4L3 -> value=7654
        T4L4 -> value=11482
        T5L1 -> value= 13780
        T5L2 -> value= 20668
        T5L3 -> value=31000
        T5L4 -> value=46496
        T6L1 -> value= 51200
        T6L2 -> value= 38400
        T6L3 -> value=115200
        T6L4 -> value=172800
        T7L1 -> value= 201400
        T7L2 -> value= 242000
        T7L3 -> value=277852
        T7L4 -> value=304792
        T8L1 -> value= 397440
        T8L2 -> value= 476928
        T8L3 -> value=548468
        T8L4 -> value=603312
        T9L1 -> value= 723978
        T9L2 -> value= 839812
        T9L3 -> value=948990
        T9L4 -> value=1034398
        T10L1 -> value= 1396400
        T10L2 -> value= 1619866
        T10L3 -> value=1798052
        T10L4 -> value=1905936
        T11L1 -> value= 2300000
        T11L2 -> value= 2517194
        T11L3 -> value=2682194
        T11L4 -> value=2776064
        else ->value =0

    }
    return value
}
fun tsmaxplunder(tsValue:Long,request: String):String{
    return if(request== ts) NumberFormat.getNumberInstance().format(Math.round((tsValue * TSVALUE)*10.0)/10.0) else NumberFormat.getNumberInstance().format(tsValue * MAXPLUMBERVALUE)
}
