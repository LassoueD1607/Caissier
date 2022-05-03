import { ProduitGuard } from './produit.guard';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { AddProduitComponent } from './add-produit/add-produit.component';
import { ProduitsComponent } from './produits/produits.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: "produits", component: ProduitsComponent, canActivate: [ProduitGuard] },
  { path: "add-produit", component: AddProduitComponent, canActivate: [ProduitGuard] },
  { path: "home", component: HomeComponent },
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: 'login', component: LoginComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: "updateProduit/:id", component: UpdateProduitComponent, canActivate: [ProduitGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
