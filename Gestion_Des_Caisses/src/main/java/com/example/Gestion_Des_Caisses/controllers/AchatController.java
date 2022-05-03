package com.example.Gestion_Des_Caisses.controllers;


import com.example.Gestion_Des_Caisses.models.Achat;
import com.example.Gestion_Des_Caisses.services.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/achat")
public class AchatController {
    private AchatService achatService;

    @Autowired
    public AchatController(AchatService achatService) {
        this.achatService = achatService;
    }
    @GetMapping
    public List<Achat> getAchat(){
        return achatService.getAchat();
    }
    @GetMapping("{id}")
    public Optional<Achat> getAchatById(@PathVariable Long id){
        return achatService.getAchatById(id);
    }
    @PostMapping
    public void addNewAchat(@RequestBody Achat achat){
        achatService.addNewAchat(achat);
    }
    @DeleteMapping("{id}")
    public void deleteAchat(@PathVariable Long id){
        achatService.deleteAchatById(id);
    }
    @PutMapping("{id}")
    public void updateAchat(@PathVariable Long id, @RequestBody Achat achat){
        achatService.updateAchat(id,achat);
    }

}
