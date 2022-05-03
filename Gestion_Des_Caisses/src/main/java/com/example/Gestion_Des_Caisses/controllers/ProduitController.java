package com.example.Gestion_Des_Caisses.controllers;


import com.example.Gestion_Des_Caisses.models.Produit;
import com.example.Gestion_Des_Caisses.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    private ProduitService produitService;
    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> getProduits(){
        return produitService.getProduits();
    }
    @GetMapping("{id}")
    public Optional<Produit> getProduitById(@PathVariable  Long id){
        return produitService.getProduitById(id);
    }

    @PostMapping
    public void registerNewProduit(@RequestBody Produit produit){
        produitService.addNewProduit(produit);
    }
    @DeleteMapping(path = "{produitId}")
    public void deleteProduit(@PathVariable("produitId") Long id) {
        produitService.deleteProduit(id);
    }

    @PutMapping()
    public void updateProduit(
                              @RequestBody Produit produitDetail){
        produitService.ModifyProduit(produitDetail);
    }



}
