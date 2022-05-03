package com.example.composecourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ImagerCard(painter: Painter,
               contentDescription: String,
               title:String,
               prix:String,
               modifier: Modifier
){
    Card(modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp){
        Box(modifier = Modifier.height(100.dp)){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(10.dp)
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.White
                        ),
                        startX = 460f,
                    )
                )
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Gray
                        ),
                        startY = 150f,
                    ),


                    )){
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.BottomStart){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.TopEnd){
                Text(prix, style = TextStyle(color = Color.Gray, fontSize = 16.sp))
            }

        }

    }
}

@Composable
fun ProductInput(produits : List<Produit>, onGroceryItemAdded: (String,Int) -> Unit){
    LazyColumn(modifier = Modifier
        .fillMaxWidth(.55f)
        .padding(10.dp)){
        items(produits.size) { index ->
            ImagerCard(
                painter = produits[index].imageURL,
                contentDescription = produits[index].designation,
                title = produits[index].nomProduit,
                prix = produits[index].prix.toString() + "DT",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onGroceryItemAdded(
                            "${produits[index].nomProduit}: ${produits[index].prix} DT",
                            produits[index].prix
                        )
                    }

            )
        }}
}




@Composable
fun ListItem(groceries: List<String>, prix:Int, navController: NavController){


    Column{


        Card(shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            modifier = Modifier.padding(top =10.dp)){
            Box(modifier = Modifier
                .background(color = colorResource(id = R.color.purple_700))
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .padding(5.dp))
            {
                LazyColumn {
                    items(groceries.size) { index ->
                        Text(
                            text = groceries[index], modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .fillMaxWidth(0.8f), style = TextStyle(color = Color.White)

                        )
                    }


                }



            }
        }
        Card(shape = RoundedCornerShape(10.dp),
            elevation = 5.dp,
            modifier = Modifier.padding(top =5.dp, bottom = 5.dp)){
            Box(modifier = Modifier
                .background(color = colorResource(id = R.color.purple_700))
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
            )


            Text(text = "Prix: $prix",
                Modifier.padding(start = 10.dp, top = 5.dp, end = 5.dp), style = TextStyle(fontSize = 20.sp, color = Color.White)
            )
        }
        Button(modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
            onClick = { navController.navigate(Screen.ThirdScreen.withArgs(prix.toString())) },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Text("Acheter")
        }
    }}
