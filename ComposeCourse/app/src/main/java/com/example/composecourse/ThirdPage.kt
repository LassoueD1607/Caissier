package com.example.composecourse

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview
@Composable
fun ThirdScreen(name: String?=""){

    var totale = remember { mutableStateOf(0)


    }
    Box(modifier = Modifier.padding(25.dp)){
        Column {
            
    Box(modifier = Modifier.fillMaxWidth() ){
        Text(text = "votre achat coûte: $name", style = TextStyle(fontSize = 25.sp)) 
    }
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
    Box(modifier = Modifier.fillMaxWidth())  {
        Text(text = "paiement en espèces:")
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }
    Row(modifier = Modifier.padding(top = 15.dp)) {


    Card(modifier = Modifier.fillMaxWidth(0.5f),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp){
        Box(modifier = Modifier.height(100.dp)){



            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clickable { totale.value = totale.value + 50000 },
                contentAlignment = Alignment.Center){
                Text("50DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
            }

        }

    }
        Spacer(modifier = Modifier.padding(end = 10.dp))
    Card(modifier = Modifier.fillMaxWidth(1f),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp){
        Box(modifier = Modifier.height(100.dp)){



            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clickable { totale.value = totale.value + 20000},
                contentAlignment = Alignment.Center){
                Text("20DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
            }

        }

    }}
     Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Row() {


                Card(modifier = Modifier.fillMaxWidth(0.5f),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(100.dp)){



                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 10000 },
                            contentAlignment = Alignment.Center){
                            Text("10DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Card(modifier = Modifier.fillMaxWidth(1f),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(100.dp)){



                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 5000 },
                            contentAlignment = Alignment.Center){
                            Text("5DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }}
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            Row() {


                Card(modifier = Modifier,
                    shape = RoundedCornerShape(50.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(50.dp)){



                        Box(modifier = Modifier

                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 2000 },
                            contentAlignment = Alignment.Center){
                            Text("2DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
                Spacer(modifier = Modifier.padding(end = 20.dp))
                Card(modifier = Modifier,
                    shape = RoundedCornerShape(50.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(50.dp)){



                        Box(modifier = Modifier

                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 1000 },
                            contentAlignment = Alignment.Center){
                            Text("1DT", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
                Spacer(modifier = Modifier.padding(end = 20.dp))
                Card(modifier = Modifier,
                    shape = RoundedCornerShape(50.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(50.dp)){



                        Box(modifier = Modifier

                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 500 },
                            contentAlignment = Alignment.Center){
                            Text("500", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
                Spacer(modifier = Modifier.padding(end = 20.dp))
                Card(modifier = Modifier,
                    shape = RoundedCornerShape(50.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(50.dp)){



                        Box(modifier = Modifier

                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 200 },
                            contentAlignment = Alignment.Center){
                            Text("200", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
                Spacer(modifier = Modifier.padding(end = 20.dp))
                Card(modifier = Modifier,
                    shape = RoundedCornerShape(50.dp),
                    elevation = 5.dp){
                    Box(modifier = Modifier.height(50.dp)){



                        Box(modifier = Modifier

                            .padding(10.dp)
                            .clickable { totale.value = totale.value + 100 },
                            contentAlignment = Alignment.Center){
                            Text("100", style = TextStyle(color = Color.Gray, fontSize = 16.sp))
                        }

                    }

                }
            }



    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 50.dp)){
        Text(text = "Montant payé: ${totale.value} ", style = TextStyle(fontSize = 20.sp))
    }
            
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 50.dp)){
        if (name != null) {
            var diff = totale.value-name.toInt()
            if (diff>0){

                Text(text = "Le montant a rendre est : $diff", style = TextStyle(fontSize = 20.sp))
            }

        }
    }
            
            

}}}

