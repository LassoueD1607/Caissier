import { Produit } from './../model/produit';
import { Injectable, Optional } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  apiURL: string = 'http://localhost:8080/produit';
  produits: Produit[] = [];
  produit: Produit | undefined;
  produitsRecherche: Produit[] = [];




  constructor(private http: HttpClient) {
    this.http.get<Produit[]>(this.apiURL).subscribe(prods => {

      this.produits = prods;



    });
    /*this.produits = [
      { idProduit: 1, nomProduit: "ASUS", prix: 3000.600, categorie: "Pc", codeABarre: "6190000001", qteStock: 10, designation: "" },
      { idProduit: 2, nomProduit: "Impremente", prix: 2500.600, categorie: "Impremente", codeABarre: "6190000002", qteStock: 10, designation: "" },
      { idProduit: 3, nomProduit: "Lait", prix: 1.600, categorie: "Alimentaire", codeABarre: "6190000003", qteStock: 10, designation: "" },
      { idProduit: 4, nomProduit: "Beurre", prix: 2.600, categorie: "Alimentaire", codeABarre: "6190000004", qteStock: 10, designation: "" },
      { idProduit: 5, nomProduit: "TOSHIBA", prix: 1800.600, categorie: "Pc", codeABarre: "6190000005", qteStock: 10, designation: "" },
      { idProduit: 6, nomProduit: "EPSON", prix: 1700.600, categorie: "Impremente", codeABarre: "6190000006", qteStock: 10, designation: "" }


    ];*/
  }
  listeProduit2(categorie: string, produitt: Produit[]) {
    this.produits = produitt

    return this.rechercherParCategorie(categorie);
  }

  listeProduit(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.apiURL);
  }

  /*addProduit(produit: Produit) {
    this.produits.push(produit);
    this.trierProduits()

  }*/
  addProduit(prod: Produit): Observable<Produit> {
    return this.http.post<Produit>(this.apiURL, prod, httpOptions);
  }
  /* deleteProduit(produit: Produit) {
     const index = this.produits.indexOf(produit, 0); //start from 0   
     if (index >= 0) {
       this.produits.splice(index, 1); //delete from index 1 element
 
       //on peut utlisier forEach
     }
   }*/
  supprimerProduit(id: number) {
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }
  /*consulterProduit(id: number): any {
    console.log(this.produits)

    this.produit = this.produits.find(p => p.idProduit == id);

    return this.produit;
  }*/
  consulterProduit(id: number): Observable<Produit> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Produit>(url);
  }
  /*updateProduit(p: Produit) {
    //this.supprimerProduit();
    this.addProduit(p);
    this.trierProduits()

  }*/
  updateProduit(prod: Produit): Observable<Produit> {
    return this.http.put<Produit>(this.apiURL, prod, httpOptions);
  }
  trierProduits(produits: Produit[]) {
    produits.sort((n1, n2) => {
      if (n1.idProduit > n2.idProduit) {
        return 1;
      }
      if (n1.idProduit < n2.idProduit) {
        return -1;
      }
      return 0;
    });
  }
  rechercherParCategorie(categor: string): Produit[] {
    this.produitsRecherche = [];
    this.produits.forEach((cur, index) => {
      if (categor === "All") this.produitsRecherche = this.produits
      else if (categor == cur.categorie) {
        this.produitsRecherche.push(cur);
      }
      else return []
    });
    return this.produitsRecherche;
  }
}
