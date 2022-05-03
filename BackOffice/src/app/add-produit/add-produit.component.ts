import { Router } from '@angular/router';
import { ProduitService } from './../services/produit.service';
import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html'
})
export class AddProduitComponent implements OnInit {


  newProduit = new Produit;
  message: string = "";
  warning: string = "";


  constructor(private produitService: ProduitService,
    private router: Router) { }


  ngOnInit(): void {


  }
  valideProduit(): boolean {
    if (this.newProduit.prix > 0 && this.newProduit.categorie != null && this.newProduit.categorie != "" && this.newProduit.prix > 0 && this.newProduit.qteStock > 0 && this.newProduit.codeABarre != null && this.newProduit.codeABarre != ""
      && this.newProduit.nomProduit != null && this.newProduit.imageURL != null && this.newProduit.imageURL != "") {
      return true
    }
    else {
      this.message = ""
      this.warning = "Verifier les données du produit"
      return false
    };

  }
  addProduit() {
    if (this.valideProduit()) {
      this.produitService.addProduit(this.newProduit).subscribe(prod => {
        this.newProduit.codeABarre = ""
        this.newProduit.designation = ""
        this.newProduit.imageURL = ""
        this.newProduit.nomProduit = ""
        this.newProduit.qteStock = 0
        this.newProduit.prix = 0
        this.newProduit.categorie = ""



        this.warning = ""
        this.message = "Produit " + this.newProduit.nomProduit + " ajouté avec succès";
      });
    }
    /*this.router.navigate(['produits']).then(() => {
      window.location.reload();
    });*/
  }
  /*addProduit() {
    if (this.newProduit.idProduit != null && this.newProduit.nomProduit != null && this.newProduit.prix != null
      && this.newProduit.codeABarre != null && this.newProduit.qteStock != null
      && this.newProduit.idProduit > 0 && this.newProduit.prix > 0) {

      this.produitService.addProduit(this.newProduit);
      if (this.newProduit.nomProduit != "")
        this.message = "Produit " + this.newProduit.nomProduit + " ajouté avec succès";

    }

  }*/


}
