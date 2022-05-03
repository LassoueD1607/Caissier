package com.example.Gestion_Des_Caisses.controllers;


import com.example.Gestion_Des_Caisses.models.Admin;
import com.example.Gestion_Des_Caisses.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }
    @PostMapping
    public void addNewAdmin(@RequestBody Admin admin){
        adminService.addNewAdmin(admin);

    }
    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
    }
    @PutMapping("{id}")
    public void updateAdmin(@PathVariable Long id,@RequestBody Admin admin){
        adminService.updateAdmin(id,admin);
    }

}
