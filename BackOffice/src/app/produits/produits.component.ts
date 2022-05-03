import { ProduitService } from './../services/produit.service';
import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html'
})
export class ProduitsComponent implements OnInit {

  produits: Produit[] = [];
  produitsAll: Produit[] = [];

  idCategorie: string = "All"

  constructor(private produitService: ProduitService) {

    // this.produits = produitService.listeProduit(this.idCategorie);

  }

  ngOnInit(): void {

    this.produitService.listeProduit().subscribe(prods => {

      this.produits = prods;
      this.produitsAll = prods
      this.produitService.trierProduits(this.produits)

    });


  }
  SuprimerProduitDuTableau(prod: Produit) {
    this.produits.forEach((cur, index) => {
      if (prod.idProduit === cur.idProduit) {
        this.produits.splice(index, 1);
      }
    });
  }
  supprimerProduit(p: Produit) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      this.produitService.supprimerProduit(p.idProduit).subscribe(() => {
        console.log("produit supprimé");
        this.SuprimerProduitDuTableau(p);
      });
  }
  onChange() {
    this.produits = this.produitsAll

    this.produits = this.produitService.listeProduit2(this.idCategorie, this.produits)

  }

}
