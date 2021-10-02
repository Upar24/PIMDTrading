package com.upar24.chattingtrading.ui.component

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.upar24.chattingtrading.R
import com.upar24.chattingtrading.data.local.entities.*
import com.upar24.chattingtrading.data.remote.requests.UpdateUserRequest
import com.upar24.chattingtrading.ui.BottomNavigationScreens
import com.upar24.chattingtrading.ui.add.AddViewModel
import com.upar24.chattingtrading.ui.auth.AuthViewModel
import com.upar24.chattingtrading.ui.home.HomeViewModel
import com.upar24.chattingtrading.ui.profile.ProfileViewModel
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
import com.upar24.chattingtrading.util.KangDooShik.cancel
import com.upar24.chattingtrading.util.KangDooShik.nope
import com.upar24.chattingtrading.util.KangDooShik.pleasewait
import com.upar24.chattingtrading.util.KangDooShik.save
import com.upar24.chattingtrading.util.KangDooShik.title
import com.upar24.chattingtrading.util.Status
import java.text.NumberFormat
import java.util.*


@Composable
fun ProfileInfoItem(number:String,desc:String){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = number,
            style = MaterialTheme.typography.button,
            color= MaterialTheme.colors.onBackground
        )
        Spacer(Modifier.padding(4.dp))
        Text(
            text=desc,
            style= MaterialTheme.typography.body1,
            color=MaterialTheme.colors.onBackground
        )
    }
}
@Composable
fun DividerItem(){
    Divider(
        color = MaterialTheme.colors.onSurface.copy(alpha = .2f),
        modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 2.dp,top=7.dp)
    )
}
@Composable
fun DividerIklan(){
    Divider(
        color = MaterialTheme.colors.onSurface.copy(alpha = .2f),
        modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 10.dp,top=10.dp)
    )
}
@Composable
fun SwitchTOLoginOrRegisterTexts(modifier: Modifier,text1: String,text2: String,onClick: () -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text1,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = text2,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.button,
            modifier = Modifier.clickable { onClick() }
        )
    }
}
@Composable
fun TextFieldOutlined(desc:String,state: TextFieldState = remember {TextFieldState()}){
    OutlinedTextField(
        label={Text(text=desc,style=MaterialTheme.typography.body1,color=MaterialTheme.colors.onBackground)},
        value =state.text,
        onValueChange = {
            state.text = it
        },
        textStyle = MaterialTheme.typography.body2,
        shape= RoundedCornerShape(8.dp),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = MaterialTheme.colors.onBackground)
    )
}
//lam9
@Composable
fun EditTextStringItem(state: TextFieldState = remember {TextFieldState()},text:String="Type Something"){
    TextField(
        value =state.text,
        onValueChange = {
            state.text = it
        },
        textStyle=MaterialTheme.typography.body2,
        placeholder={Text(text,style=MaterialTheme.typography.body1)},
        shape= RoundedCornerShape(24.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}
@Composable
fun EditTextItem(modifier: Modifier=Modifier, desc: String, string: TextFieldState, keyboard: KeyboardOptions= KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)) {
    val status = remember{ mutableStateOf(TextFieldValue(text= string.text))}
    TextField(
        value = status.value,
        onValueChange ={lamo ->
            if(lamo.text.isNotEmpty()){
                var result = lamo.text.filter { it.isLetterOrDigit() }
                result = NumberFormat.getNumberInstance(Locale.US).format(result.toLong())
                status.value = TextFieldValue(text=result,selection=TextRange(result.length.plus(1)))
                string.text=status.value.text
            }else{
                status.value = TextFieldValue("0")
            }
        },
        placeholder = {Text(desc,style = MaterialTheme.typography.body1)},
        modifier = modifier,
        keyboardOptions = keyboard,
        shape= RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle=MaterialTheme.typography.body2,
        maxLines=7
    )
}
@Composable
fun ButtonClickItem(
    modifier: Modifier = Modifier,
    desc: String,
    onClick: () -> Unit,
    bordercolor: Color = MaterialTheme.colors.background,
    colors: ButtonColors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
) {
    Button(
        onClick =  onClick,
        border= BorderStroke(2.dp,bordercolor),
        colors = colors,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ){
        Text(desc,style=MaterialTheme.typography.button,color= bordercolor)
    }
}
@Composable
fun CardDrop(dropped: Dropped){
    Card(
        border= BorderStroke(1.dp,MaterialTheme.colors.primaryVariant),
        shape= RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ){
        Column(
            Modifier
                .padding(8.dp),
            horizontalAlignment = CenterHorizontally,
        ){
            Text("Day ${dropped.day}",style=MaterialTheme.typography.body1,color=MaterialTheme.colors.onBackground)
            Text(dropped.name,style = MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
            Text(dropped.duration,style = MaterialTheme.typography.body1,color=MaterialTheme.colors.onBackground)
        }
    }
}
@Composable
fun ProgressBarItem(){
    Row(
        verticalAlignment =Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator()
            Spacer(Modifier.size(10.dp))
            Text(text=pleasewait,style=MaterialTheme.typography.body1,color=MaterialTheme.colors.onBackground)
        }
    }
}
@Composable
fun ProgressCardToastItem(){
    Row(modifier = Modifier
        .fillMaxSize()
        .padding(6.dp),
        Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            shape= RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.secondary
        ){
            ProgressBarItem()
        }
    }
}
@Composable
fun SvgItemClick(icon:Int,onClick: () -> Unit){
    Icon(
        painter = painterResource(id = icon),"",
        tint=MaterialTheme.colors.primary,
        modifier=Modifier.clickable(onClick=onClick))
}
@Composable
fun IconItemClick(icon: ImageVector, onIconClick: () -> Unit){
    Icon(
        imageVector = icon,
        contentDescription ="",
        tint=MaterialTheme.colors.primary,
        modifier= Modifier
            .clickable(onClick = onIconClick)
            .size(24.dp)
    )
}
@Composable
fun TopBarItem(onIconClick: () -> Unit){
    Row(Modifier.padding(8.dp),verticalAlignment = Alignment.CenterVertically){
        IconItemClick(icon = Icons.Filled.Menu,onIconClick = onIconClick)
        Text(
            text = "CTForever",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            modifier=Modifier.padding(start=16.dp)
        )
    }
}
@Composable
fun ChatCard(chat: Chat, navController: NavHostController){
    Card(
        border= BorderStroke(1.dp,MaterialTheme.colors.primaryVariant),
        shape= RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ){
        Column(Modifier.padding(8.dp)) {
            HeaderCardItem(text1 = "${getTimePost(chat.date)} ago", text2 = chat.username.toString(), text3 = chat.clubName.toString(),navController)
            DividerItem()
            Text(chat.chat.toString(),textAlign= TextAlign.Justify,color=MaterialTheme.colors.onBackground,style=MaterialTheme.typography.body1)
        }
    }
}
@Composable
fun TradingCard(username:String, trading: Trading, editClick: () -> Unit, deleteClick: () -> Unit, navController: NavHostController){
    Card(
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary
    )
    {
        Column(Modifier.padding(8.dp)) {

            HeaderCardItem("${getTimePost(trading.date)} ago",trading.username.toString(),
                if(trading.ign == "") "IGN" else trading.ign ?: "IGN",navController)
            DividerItem()
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,Alignment.CenterVertically){
                Row(Modifier.weight(5f),horizontalArrangement = Arrangement.Start,verticalAlignment = Alignment.CenterVertically){
                    TwoTextItem(title,trading.title.toString())
                }
                if(username==trading.username){
                    Row(Modifier.weight(1f),horizontalArrangement=Arrangement.Center,verticalAlignment=Alignment.CenterVertically){
                        IconItemClick(Icons.Filled.Edit,editClick )
                    }
                    Row(Modifier.weight(1f),horizontalArrangement=Arrangement.Center,verticalAlignment=Alignment.CenterVertically){
                        Icon(imageVector = Icons.Filled.Delete, contentDescription ="",Modifier.clickable(onClick = deleteClick),tint=Color.Red )
                    }
                }
            }
            Spacer(Modifier.padding(5.dp))
            TwoTextItem("Description", trading.desc.toString())
            Spacer(Modifier.padding(5.dp))
            Row(
                Modifier
                    .fillMaxWidth(),horizontalArrangement =Arrangement.SpaceBetween){
                Row(Modifier.weight(1f),horizontalArrangement = Arrangement.Start){
                    TwoTextItem("Buying", "${trading.amountBuying} ${trading.itemBuying}" )
                }
                Row(Modifier.weight(1f),horizontalArrangement = Arrangement.End){
                    TwoTextItem("Selling", "${trading.amountSelling} ${trading.itemSelling}" )
                }
            }
        }
    }
}
@Composable
fun TwoTextItem(text1:String,text2:String){
    Column {
        Text(text1,color=MaterialTheme.colors.onBackground,style = MaterialTheme.typography.subtitle2)
        Text(text2,color=MaterialTheme.colors.onBackground,textAlign = TextAlign.Justify,style=MaterialTheme.typography.body2)
    }
}
@Composable
fun HeaderCardItem(text1:String,text2: String,text3:String,navController: NavHostController){
    SelectionContainer {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = {
                    navController.navigate(BottomNavigationScreens.OtherProfile.withArgs(text2))
                })
        ) {
            Row(Modifier.weight(1f)) {
                Text(text1,Modifier.fillMaxWidth(),style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
            }
            Row(Modifier.weight(1f)) {
                Text(text2,Modifier.fillMaxWidth(),textAlign = TextAlign.Center,style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
            }
            Row(Modifier.weight(1f)) {
                Text(text3,Modifier.fillMaxWidth(),textAlign = TextAlign.End,style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
            }
        }
    }
}
@Composable
fun WallCard(wall: Wall?, onWall: () -> Unit, onDelete:() ->Unit, navController: NavHostController){
    Card(
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Column (Modifier.padding(8.dp),horizontalAlignment= CenterHorizontally,verticalArrangement = Arrangement.Center){
            wall?.let {
                HeaderCardItem(text1 = "${getTimePost(it.date)} ago", text2 = it.username.toString(), text3 =it.ign ?: "IGN",navController)
                DividerItem()
                Row(Modifier.fillMaxWidth(), Arrangement.Center,verticalAlignment= Alignment.CenterVertically) {
                    Row(Modifier.weight(5f),Arrangement.Start,verticalAlignment=Alignment.CenterVertically){
                        it.chat?.let { it1 -> Text(it1,style= MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground) }}
                    Row(Modifier.weight(1f),Arrangement.Center,verticalAlignment= Alignment.CenterVertically){
                        if(getUsernameLoginFunction() != it.username || it.wallOwner != it.username) SvgItemClick(icon = R.drawable.ic_reply,onWall)}
                    Row(Modifier.weight(1f),Arrangement.Center,verticalAlignment=Alignment.CenterVertically){
                        if((getUsernameLoginFunction()==it.wallOwner)) Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "",
                            modifier = Modifier.clickable(onClick = onDelete),
                            tint=Color.Red
                        )}
                }
            }
        }
    }
}
@Composable
fun UserProfile(user: User?){
    if(user?.username!=""){
        user?.let {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),verticalArrangement = Arrangement.Center,horizontalAlignment = CenterHorizontally
            ){
                DividerItem()
                SelectionContainer {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Row(Modifier.weight(1f)) {
                            Text(user.name.toString(),Modifier.fillMaxWidth(),style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
                        }
                        Row(Modifier.weight(1f)) {
                            Text(user.ign.toString(),Modifier.fillMaxWidth(),textAlign = TextAlign.Center,style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
                        }
                        Row(Modifier.weight(1f)) {
                            Text(user.clubName.toString(),Modifier.fillMaxWidth(),textAlign = TextAlign.End,style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
                        }
                    }
                }
                DividerItem()
                Text("Age",style=MaterialTheme.typography.subtitle2)
                Text(getTimePost(user.created),textAlign = TextAlign.Center,style = MaterialTheme.typography.body1)
                DividerItem()
                Text("Bio",style=MaterialTheme.typography.subtitle2)
                Text(it.bio.toString(),textAlign = TextAlign.Justify,style=MaterialTheme.typography.body1)
                DividerItem()
            }
        }
    }
}
@Composable
fun EditProfileDialog(user: User,onClick: () -> Unit,username: String){
    var openEdit by remember { mutableStateOf(true)}
    val profileVM = hiltViewModel<ProfileViewModel>()
    val nameState = remember { TextFieldState(user.name.toString()) }
    val clubNameState = remember { TextFieldState(user.clubName.toString()) }
    val ignState = remember { TextFieldState(user.ign.toString()) }
    val bioState = remember { TextFieldState(user.bio.toString()) }
    val uiState=profileVM.updateProfile.observeAsState()
    uiState.value?.let {
        when(it.status){
            Status.SUCCESS ->{onClick}
            Status.ERROR -> {onClick}
            Status.LOADING -> {
                ProgressCardToastItem()
            }
        }
    }

    if(openEdit){
        AlertDialog(
            backgroundColor=MaterialTheme.colors.secondary,
            modifier= Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f)
                .padding(8.dp),
            onDismissRequest=onClick,
            title = { Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),horizontalArrangement = Arrangement.Center)
            {Text(text = "EDIT",style = MaterialTheme.typography.h2,color=MaterialTheme.colors.onBackground) }},
            text = {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally
                ) {
                    TextFieldOutlined(desc = "Name", nameState)
                    TextFieldOutlined(desc = "Club Name", clubNameState)
                    TextFieldOutlined(desc = "IGN", ignState)
                    TextFieldOutlined(desc = "Bio", bioState)
                }
            },
            confirmButton ={
                Text(save,modifier = Modifier
                    .padding(8.dp)
                    .clickable(onClick = {
                        profileVM.updateProfile(
                            UpdateUserRequest(
                                name = if (nameState.text.length > 101) nameState.text.substring(
                                    0,
                                    100
                                ) else nameState.text,
                                clubName = if (clubNameState.text.length > 101) clubNameState.text.substring(
                                    0,
                                    100
                                ) else clubNameState.text,
                                ign = if (ignState.text.length > 101) ignState.text.substring(
                                    0,
                                    100
                                ) else ignState.text,
                                bio = if (bioState.text.length > 501) bioState.text.substring(
                                    0,
                                    500
                                ) else bioState.text
                            ), username
                        )
                        openEdit = false
                    }),color=MaterialTheme.colors.primary,style=MaterialTheme.typography.subtitle2)
            },
            dismissButton = {
                Text(cancel,
                    Modifier
                        .padding(8.dp)
                        .clickable(onClick = onClick),color=Color.Red)
            }
        )
    }
}
@Composable
fun WallList(wallList: List<Wall>, navController: NavHostController, modifier: Modifier) {
    Column( modifier=modifier) {
        wallList.forEach {
            val profileVM= hiltViewModel<ProfileViewModel>()
            val authVM= hiltViewModel<AuthViewModel>()
            WallCard(
                wall = it,
                onWall = {
                    navController.navigate(BottomNavigationScreens.OtherProfile.withArgs(it.username.toString()))},
                onDelete = {
                    authVM.isLoggedIn()
                    authVM.authenticateApi(authVM.usernamevm ?: "", authVM.passwordvm ?: "")
                    profileVM.deleteWall(it.wallOwner.toString(),it)},navController
            )
            Spacer(modifier = Modifier.padding(2.dp))
        }
    }

}
@Composable
fun AddTradingDialog(trading: Trading? ){
    Column {
        var openDialog by remember { mutableStateOf(true)}
        val addVM = hiltViewModel<AddViewModel>()
        val titleState = remember { TextFieldState(trading?.title.toString()) }
        val descState= remember {TextFieldState(trading?.desc.toString())}
        val itemBuyingState = remember { TextFieldState(trading?.itemBuying.toString()) }
        val amountBuyingState = remember { TextFieldState(trading?.amountBuying.toString()) }
        val itemSellingState = remember { TextFieldState(trading?.itemSelling.toString()) }
        val amountSellingState = remember { TextFieldState(trading?.amountSelling.toString()) }
        val authVM= hiltViewModel<AuthViewModel>()
        val login : Boolean= getUsernameLoginFunction() == NO_USERNAME
        val context = LocalContext.current
        if(openDialog){
            AlertDialog(
                backgroundColor=MaterialTheme.colors.secondary,
                onDismissRequest={openDialog = false},
                title = { Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),horizontalArrangement = Arrangement.Center)
                {Text(text = "TRADING",style = MaterialTheme.typography.h2,color=MaterialTheme.colors.onBackground) }},
                text = {
                    Column(
                        Modifier
                            .fillMaxHeight()
                            .padding(top = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.padding(4.dp))
                        TextFieldOutlined(desc = "Title", titleState)
                        TextFieldOutlined(desc = "Description", descState)
                        Spacer(Modifier.padding(top=4.dp))
                        Text("Item Buying",style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
                        Row(Modifier.fillMaxWidth()){
                            Row(Modifier.weight(3f)){
                                TextFieldOutlined(desc = "Name Item", itemBuyingState)
                            }
                            Row(Modifier.weight(1.6f)){
                                TextFieldOutlined(desc = "Amount", amountBuyingState)
                            }
                        }
                        Spacer(Modifier.padding(top=4.dp))
                        Text("Item Selling",style=MaterialTheme.typography.subtitle2,color=MaterialTheme.colors.onBackground)
                        Row(Modifier.fillMaxWidth()){
                            Row(Modifier.weight(3f)){
                                TextFieldOutlined(desc = "Name Item", itemSellingState)
                            }
                            Row(Modifier.weight(1.6f)){
                                TextFieldOutlined(desc = "Amount", amountSellingState)
                            }
                        }
                    }
                },
                confirmButton ={
                    Text(save,
                        Modifier
                            .padding(8.dp)
                            .clickable(onClick = {
                                if (login) {
                                    Toast
                                        .makeText(
                                            context, "Please Login First.", Toast.LENGTH_SHORT,
                                        )
                                        .show()
                                } else {
                                    authVM.isLoggedIn()
                                    authVM.authenticateApi(
                                        authVM.usernamevm ?: "",
                                        authVM.passwordvm ?: ""
                                    )
                                    addVM.saveTrading(
                                        Trading(
                                            _id = trading?._id.toString(),
                                            title = if (titleState.text.length > 51) titleState.text.substring(
                                                0,
                                                50
                                            ) else titleState.text,
                                            desc = if (descState.text.length > 101) descState.text.substring(
                                                0,
                                                100
                                            ) else descState.text,
                                            itemBuying = if (itemBuyingState.text.length > 101) itemBuyingState.text.substring(
                                                0,
                                                100
                                            ) else itemBuyingState.text,
                                            amountBuying = if (amountBuyingState.text.length > 51) amountBuyingState.text.substring(
                                                0,
                                                50
                                            ) else amountBuyingState.text,
                                            itemSelling = if (itemSellingState.text.length > 101) itemSellingState.text.substring(
                                                0,
                                                100
                                            ) else itemSellingState.text,
                                            amountSelling = if (amountSellingState.text.length > 51) amountSellingState.text.substring(
                                                0,
                                                50
                                            ) else amountSellingState.text
                                        )
                                    )
                                    openDialog = false
                                }
                            }),color=MaterialTheme.colors.primary,style=MaterialTheme.typography.subtitle2)},
                dismissButton = {
                    Text(cancel,
                        Modifier
                            .padding(8.dp)
                            .clickable(onClick = {
                                openDialog = false
                            }),color=Color.Red,style=MaterialTheme.typography.subtitle2)
                }
            )
        }
    }
}
@Composable
fun ObserveUserList(onClick: () -> Unit,navController: NavHostController,title: String){
    val homeVM = hiltViewModel<HomeViewModel>()
    val userList = mutableListOf<User>()
    val listUserState = homeVM.listUserStatus.observeAsState()
    listUserState.value?.let {
        when (it.status) {
            Status.SUCCESS -> {
                it.data?.let {listUser ->
                    userList.clear()
                    listUser.forEach { user ->
                        userList.add(user)
                    }
                }  ?: userList.clear()
            }
            Status.ERROR -> {
                Toast.makeText(
                    LocalContext.current, it.message ?: "An unknown error occured",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Status.LOADING -> {
                ProgressCardToastItem()
            }
        }
    }
    AlertDialog(
        modifier=Modifier.fillMaxHeight(0.65f),
        backgroundColor=MaterialTheme.colors.secondary,
        onDismissRequest=onClick,
        title={ Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),horizontalArrangement = Arrangement.Center)
        {Text(text = title,style = MaterialTheme.typography.h2,color=MaterialTheme.colors.onBackground) }},
        text = {
            Column(Modifier.verticalScroll(rememberScrollState()),verticalArrangement = Arrangement.Center) {
                userList.forEach {
                    Card(
                        border=BorderStroke(1.dp,MaterialTheme.colors.primaryVariant),
                        shape= RoundedCornerShape(8.dp),
                        backgroundColor = MaterialTheme.colors.secondary
                    ){
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            Arrangement.SpaceBetween
                        ){
                            HeaderCardItem(text1 = it.ign.toString(), text2 = it.username, text3 = it.clubName.toString(), navController = navController)
                        }
                    }
                    Spacer(Modifier.padding(2.dp))
                }
            }
        },
        confirmButton = {
            Text("Close",
                Modifier
                    .padding(8.dp)
                    .clickable(onClick = onClick),
                style=MaterialTheme.typography.subtitle2,color=Color.Red)}
    )
}

@Composable
fun DropDownListItem(
    desc:String,
    state: TextFieldState = remember {TextFieldState()}
){
    val countryList= listOf(nope,
        T1L1, T1L2, T1L3, T1L4,
        T2L1, T2L2, T2L3, T2L4,
        T3L1, T3L2, T3L3, T3L4,
        T4L1, T4L2, T4L3, T4L4,
        T5L1, T5L2, T5L3, T5L4,
        T6L1, T6L2, T6L3, T6L4,
        T7L1, T7L2, T7L3, T7L4,
        T8L1, T8L2, T8L3, T8L4,
        T9L1, T9L2, T9L3, T9L4,
        T10L1, T10L2, T10L3, T10L4,
        T11L1, T11L2, T11L3, T11L4
    )
    val isOpen= remember{ mutableStateOf(false)}
    val openCloseOfDropDownList:(Boolean) -> Unit = {isOpen.value = it}
    val userSelectedString:(String) -> Unit = {state.text = it}
    Box{
        Column (horizontalAlignment = CenterHorizontally){
            TextFieldOutlined(desc = desc,state)
            DropdownMenu(
                modifier= Modifier
                    .background(MaterialTheme.colors.secondary)
                    .align(CenterHorizontally)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(0.7f),
                expanded = isOpen.value,
                onDismissRequest = { openCloseOfDropDownList(false) }
            ) {
                countryList.forEach {
                    DropdownMenuItem(
                        onClick = {
                            openCloseOfDropDownList(false)
                            userSelectedString(it)
                        }) {
                        Text(it,style=MaterialTheme.typography.body1)
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(
                    onClick = { isOpen.value = true }
                )
        )
    }
}
@Composable
fun TermTextItem(title:String,desc:String){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(6.dp)) {
        Text(title,style=MaterialTheme.typography.subtitle1,color = MaterialTheme.colors.onBackground)
        Text(desc,style=MaterialTheme.typography.body1,textAlign= TextAlign.Justify,color=MaterialTheme.colors.onBackground)
        Spacer(modifier = Modifier.padding(6.dp))
    }
}
@Composable
fun AdvertView(modifier: Modifier = Modifier) {
    val isInEditMode = LocalInspectionMode.current
    if (isInEditMode) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(horizontal = 2.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            text = "Advert Here",
        )
    } else {
        AndroidView(
            modifier = modifier,
            factory = { context ->
                AdView(context).apply {
                    adSize = AdSize.BANNER
                    adUnitId = "ca-app-pub-9520915968199258/6658345563"
                    loadAd(AdRequest.Builder().build())
                }
            }
        )
    }
}
@Composable
fun CardTipsTrick(title:String, credit:String,modifier : Modifier = Modifier){
    Card(
        border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = modifier
    ){
        Row(Modifier.fillMaxWidth(1f),horizontalArrangement = Arrangement.SpaceBetween){
            Text(title)
            Text(credit)
        }
    }
}
