import { ProduitService } from './../services/produit.service';
import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styles: [
  ]
})
export class UpdateProduitComponent implements OnInit {
  currentProduit = new Produit();

  constructor(private activatedRoute: ActivatedRoute,
    private produitService: ProduitService, private router: Router) { }

  ngOnInit(): void {
    //this.currentProduit = this.produitService.consulterProduit(this.activatedRoute.snapshot.params.id);
    this.produitService.consulterProduit(this.activatedRoute.snapshot.params.id).subscribe((prod: Produit) => { this.currentProduit = prod; });
    /* pour afficher le current produits dans ces champs
    this.activatedRoute.snapshot.params.id ve passer le parametre id qu'on a specifier dans 
    [routerLink]="['/updateProduit',produit.idProduit]"*/
  }

  /*updateProduit() {
    if (this.currentProduit.idProduit != null && this.currentProduit.nomProduit != null && this.currentProduit.prix != null
      && this.currentProduit.codeABarre != null && this.currentProduit.qteStock != null
      && this.currentProduit.idProduit > 0 && this.currentProduit.prix > 0) {

      this.produitService.updateProduit(this.currentProduit);

      this.router.navigate(['produits']);
    }
  }*/
  updateProduit() {
    this.produitService.updateProduit(this.currentProduit).subscribe(() => {
      this.router.navigate(['produits']);
    }, (error) => { alert("Problème lors de la modification !"); }
    );
  }

}
