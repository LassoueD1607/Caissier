package com.example.Gestion_Des_Caisses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Achat {
    @Id
    @SequenceGenerator(name = "achat_sequence", sequenceName = "achat_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "achat_sequence")
    private Long idAchat;
    private LocalDate dateAchat;
    private Double remise;

    @ManyToMany()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "Achat_Produit",
            joinColumns= @JoinColumn(
                    name = "achat_id",
                    referencedColumnName = "idAchat"


            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produit_id",
                    referencedColumnName = "idProduit",
                    foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (produit_id) REFERENCES produit(id_Produit) ON DELETE CASCADE")

            )
    )
    private List<Produit> produits;

    public Achat(LocalDate dateAchat, Double remise) {
        this.dateAchat = dateAchat;
        this.remise = remise;

    }


    public Achat(LocalDate dateAchat, Double remise, List<Produit> produits) {
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.produits = produits;
    }

    public void addAchat(Produit produit) {
            if (produits==null) produits=new ArrayList<>();
            produits.add(produit);
        }



    }




