package com.example.Gestion_Des_Caisses.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Produit {
    @Id
    @SequenceGenerator(name = "produit_sequence", sequenceName = "produit_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "produit_sequence")
    private Long idProduit;
    @Column(unique = true)
    private String codeABarre;
    private String nomProduit;
    private String categorie;
    private Long prix;
    private Long qteStock;
    private String designation;
    private String imageURL;


    public Produit(String codeABarre, String nomProduit, String categorie, Long prix, Long qteStock, String designation, String imageURL ) {
        this.codeABarre = codeABarre;
        this.nomProduit = nomProduit;
        this.categorie = categorie;
        this.prix = prix;
        this.qteStock = qteStock;
        this.designation = designation;
        this.imageURL =imageURL;
    }
}
