package com.example.composecourse

import androidx.compose.ui.graphics.painter.Painter

data class Produit(
    val categorie: String,
    val codeABarre: String,
    val designation: String,
    val idProduit: Int,
    val imageURL: Painter,
    val nomProduit: String,
    val prix: Int,
    val qteStock: Int
)