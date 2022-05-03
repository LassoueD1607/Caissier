package com.example.composecourse

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object SecondeScreen : Screen("seconde_screen")
    object ThirdScreen : Screen("third_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {
                arg -> append("/$arg")
            }
        }
    }



}
