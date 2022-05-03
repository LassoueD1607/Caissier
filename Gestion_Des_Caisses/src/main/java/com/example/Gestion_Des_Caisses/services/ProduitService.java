package com.example.Gestion_Des_Caisses.services;


import com.example.Gestion_Des_Caisses.models.Produit;
import com.example.Gestion_Des_Caisses.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProduitService {

    private ProduitRepository produitRepository;
    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public void addNewProduit(Produit produit) {
        produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        boolean exists = produitRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Produit avec id " + id + "introuvable");
        }
        produitRepository.deleteById(id);
    }

    @Transactional
    public void ModifyProduit( Produit produit) {
        Produit newProduit = produitRepository.findById(produit.getIdProduit())
                .orElseThrow(() -> new IllegalStateException("Achat avec id " + produit.getIdProduit() + "est introuvable!!!"));
        if (produit.getNomProduit() != null && produit.getNomProduit().length() > 0 && !Objects.equals(newProduit.getNomProduit(), produit.getNomProduit())) {
            newProduit.setNomProduit(produit.getNomProduit());
        }
        if (produit.getCodeABarre() != null && produit.getCodeABarre().length() > 0 && !Objects.equals(newProduit.getCodeABarre(), produit.getCodeABarre())) {
            newProduit.setCodeABarre(produit.getCodeABarre());
        }
        if (produit.getCategorie() != null && produit.getCategorie().length() > 0 && !Objects.equals(newProduit.getCategorie(), produit.getCategorie())) {
            newProduit.setCategorie(produit.getCategorie());
        }
        if (produit.getDesignation() != null && produit.getDesignation().length() > 0 && !Objects.equals(newProduit.getDesignation(), produit.getDesignation())) {
            newProduit.setDesignation(produit.getDesignation());
        }

        if (produit.getQteStock() != null && !Objects.equals(newProduit.getQteStock(), produit.getQteStock())) {
            newProduit.setQteStock(produit.getQteStock());
        }
        if (produit.getPrix() != null && !Objects.equals(newProduit.getPrix(), produit.getPrix())) {
            newProduit.setPrix(produit.getPrix());
        }
        if (produit.getImageURL() != null && produit.getDesignation().length() > 0 && !Objects.equals(newProduit.getImageURL(), produit.getImageURL())) {
            newProduit.setImageURL(produit.getImageURL());
        }
    }

}
