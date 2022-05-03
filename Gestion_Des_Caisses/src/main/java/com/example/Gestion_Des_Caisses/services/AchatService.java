package com.example.Gestion_Des_Caisses.services;


import com.example.Gestion_Des_Caisses.models.Achat;
import com.example.Gestion_Des_Caisses.models.Produit;
import com.example.Gestion_Des_Caisses.repositories.AchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AchatService {
    private AchatRepository achatRepository;
    @Autowired
    public AchatService(AchatRepository achatRepository) {
        this.achatRepository = achatRepository;
    }

    public List<Achat> getAchat() {
        return achatRepository.findAll();
    }

    public Optional<Achat> getAchatById(Long id) {
        return achatRepository.findById(id);
    }

    public void addNewAchat(Achat achat) {
        achatRepository.save(achat);
    }

    public void deleteAchatById(Long id) {
        boolean exists = achatRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Achat avec id " + id + "introuvable");
        }
        achatRepository.deleteById(id);
    }

    @Transactional
    public void updateAchat(Long id, Achat achat) {
        Achat newAchat = achatRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Achat avec id " + id + "est introuvable!!!"));

        if (achat.getRemise() != null && !Objects.equals(newAchat.getRemise(), achat.getRemise())) {
            newAchat.setRemise(achat.getRemise());
        }
        if (achat.getDateAchat() != null && !Objects.equals(newAchat.getDateAchat(), achat.getDateAchat())) {
            newAchat.setDateAchat(achat.getDateAchat());
        }

    }
}
