package com.example.Gestion_Des_Caisses.services;

import com.example.Gestion_Des_Caisses.models.Achat;
import com.example.Gestion_Des_Caisses.models.Admin;
import com.example.Gestion_Des_Caisses.models.Produit;
import com.example.Gestion_Des_Caisses.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    @Autowired

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        boolean exists = adminRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Admin avec id " + id + "introuvable");
        }
        adminRepository.deleteById(id);
    }
    @Transactional
    public void updateAdmin(Long id, Admin admin) {
        Admin newProduit = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Admin avec id " + id + "est introuvable!!!"));
        if (admin.getAdminName() != null && admin.getAdminName().length() > 0 && !Objects.equals(newProduit.getAdminName(), admin.getAdminName())) {
            newProduit.setAdminName(admin.getAdminName());
        }
        if (admin.getPassword() != null && admin.getPassword().length() > 0 && !Objects.equals(newProduit.getPassword(), admin.getPassword())) {
            newProduit.setPassword(admin.getPassword());
        }}

}
