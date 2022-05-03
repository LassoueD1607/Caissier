package com.example.composecourse

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun SecondeScreen(navController: NavController){
    val produits = listOf<Produit>(
        Produit("Alimentaire","6190000001","Ok",1,
            painterResource(id = R.drawable.fromage),"Fromage",3000,5),
        Produit("Alimentaire","6190000002","Ok",2,
            painterResource(id = R.drawable.beurre),"Beurre",1850,10),
        Produit("Alimentaire","6190000003","Ok",3,
            painterResource(id = R.drawable.lait_vitalait),"Lait Vitalait",1300,10),
        Produit("Alimentaire","6190000003","Ok",3,
            painterResource(id = R.drawable.eau_minerale),"Eau Minirale",800,100),
        Produit("Alimentaire","6190000003","Ok",3,
            painterResource(id = R.drawable.lait_vitalait),"Lait Vitalait",1300,10),
        Produit("Alimentaire","6190000003","Ok",3,
            painterResource(id = R.drawable.lait_vitalait),"Lait Vitalait",1300,10),
        Produit("Alimentaire","6190000003","Ok",3,
            painterResource(id = R.drawable.lait_vitalait),"Lait Vitalait",1300,10))

    var groceriesState by remember {  mutableStateOf(listOf("")) }
    var prixState by remember { mutableStateOf(0)
    }

    Row{
        ProductInput(produits){
                item,prix -> groceriesState = groceriesState + listOf(item)
            prixState = prixState + prix}
        ListItem(groceriesState,prixState,navController)
    }
}