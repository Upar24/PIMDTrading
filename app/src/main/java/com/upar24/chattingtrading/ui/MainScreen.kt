package com.upar24.chattingtrading.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.upar24.chattingtrading.R
import com.upar24.chattingtrading.ui.add.AddScreen
import com.upar24.chattingtrading.ui.auth.AuthViewModel
import com.upar24.chattingtrading.ui.auth.LoginScreen
import com.upar24.chattingtrading.ui.auth.RegisterScreen
import com.upar24.chattingtrading.ui.component.Navigation.CTFAppBottomNavigation
import com.upar24.chattingtrading.ui.component.Navigation.CTFAppDrawerNavigation
import com.upar24.chattingtrading.ui.component.Navigation.CTFAppTopNavigation
import com.upar24.chattingtrading.ui.component.getUsernameLoginFunction
import com.upar24.chattingtrading.ui.home.CalculationScreen
import com.upar24.chattingtrading.ui.home.HomeScreen
import com.upar24.chattingtrading.ui.home.PartyScreen
import com.upar24.chattingtrading.ui.profile.OtherProfileScreen
import com.upar24.chattingtrading.ui.profile.ProfileScreen
import com.upar24.chattingtrading.ui.profile.ProfileViewModel
import kotlinx.coroutines.launch

sealed class DrawerNavigationScreens(
    val route:String,
    @StringRes val resourceId:Int,
    val icon: Int
){
    object TipsTricks:DrawerNavigationScreens("TipsTricks", R.string.tipstricks_screen_route, R.drawable.ic_lamp)
    object Dictionary:DrawerNavigationScreens("Dictionary",R.string.dictionary_screen_route, R.drawable.ic_dictionary)
    object Support:DrawerNavigationScreens("Support",R.string.support_screen_route, R.drawable.ic_support)
}
sealed class BottomNavigationScreens(
    val route:String,
    @StringRes val resourceId:Int,
    val icon: ImageVector
){
    object Home:BottomNavigationScreens("Home", R.string.home_screen_route, Icons.Filled.Home )
    object Add:BottomNavigationScreens("Add",R.string.add_screen_route, Icons.Filled.AddCircleOutline)
    object Profile:BottomNavigationScreens("Profile",R.string.profile_screen_route, Icons.Filled.Person)
    object Search:BottomNavigationScreens("Search",R.string.search_screen_route, Icons.Filled.Search)
    object OtherProfile:BottomNavigationScreens("OtherProfile",R.string.otherprofile_screen_route, Icons.Filled.AddCircleOutline)
    fun withArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
@Composable
fun MainScreen(){
    Card(
        modifier= Modifier.fillMaxSize(),
        backgroundColor= MaterialTheme.colors.background
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(1f),
            backgroundColor = MaterialTheme.colors.background){
            val navController: NavHostController = rememberNavController()
            val scaffoldState: ScaffoldState = rememberScaffoldState()
            val coroutineScope= rememberCoroutineScope()
            val bottomNavigationItems= listOf(
                BottomNavigationScreens.Home,
                BottomNavigationScreens.Add,
                BottomNavigationScreens.Search,
                BottomNavigationScreens.Profile
            )
            val drawerNavigationItems= listOf(
                DrawerNavigationScreens.TipsTricks,
                DrawerNavigationScreens.Dictionary,
                DrawerNavigationScreens.Support
            )
            val authVM = hiltViewModel<AuthViewModel>()

            Scaffold (
                topBar={
                    CTFAppTopNavigation(
                        onIconClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                            authVM.getDesc()
                        }
                    )
                },
                scaffoldState=scaffoldState,
                drawerContent={
                    CTFAppDrawerNavigation(
                        closeDrawerAction = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        },
                        navController = navController,
                        items = drawerNavigationItems,
                    )
                },
                bottomBar ={
                    CTFAppBottomNavigation(navController , bottomNavigationItems )
                }
            ){
                MainScreenNavigationConfiguration(navController)
            }
        }
    }
}
@Composable
fun MainScreenNavigationConfiguration(
    navController: NavHostController
){
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route){
        composable(BottomNavigationScreens.Home.route){
            HomeScreen(navController)
        }
        composable("Party"){
            PartyScreen(navController)
        }
        composable(BottomNavigationScreens.OtherProfile.route + "/{username}",arguments = listOf(
            navArgument("username"){
                type= NavType.StringType
                defaultValue=""
                nullable=true
            }
        )){

            val profileVM = hiltViewModel<ProfileViewModel>()
            it.arguments?.getString("username")?.let { it1 ->
                profileVM.getWall(it1)
                OtherProfileScreen(it1,navController) }
        }
        composable(BottomNavigationScreens.Add.route){
            AddScreen(navController)
        }
        composable(BottomNavigationScreens.Profile.route){
            val profileVM = hiltViewModel<ProfileViewModel>()
            profileVM.getWall(getUsernameLoginFunction())
            ProfileScreen(navController)
        }
        composable(BottomNavigationScreens.Search.route){
            SearchScreen(navController)
        }
        composable("Calculate"){
            CalculationScreen()
        }
        composable(DrawerNavigationScreens.TipsTricks.route){
            TipsTricksScreen()
        }
        composable("Dictionary"){
            DictionaryScreen()
        }
        composable("Support"){
            SupportScreen()
        }
        composable("LoginRoute"){
            LoginScreen(navController)
        }
        composable("RegisterRoute"){
            RegisterScreen(navController)
        }
    }
}