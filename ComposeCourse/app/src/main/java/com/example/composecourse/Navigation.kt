package com.example.composecourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route  ){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
            
        }
        composable(
            route = Screen.SecondeScreen.route
        ){
            SecondeScreen(navController = navController)
        }
        composable(
            route = Screen.ThirdScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue ="Lassoued"
                    nullable=true
                }
            )
        ){ entry ->
            ThirdScreen(name = entry.arguments?.getString("name"))
        }
    }
}
@Composable
fun MainScreen(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 500.dp
            )
    ) {
        Button(onClick = { navController.navigate(Screen.SecondeScreen.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Welcome")
            
        }
    }
    
}