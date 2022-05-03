package com.example.Gestion_Des_Caisses.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Admin {
    @Id
    @SequenceGenerator(name = "admin_sequence", sequenceName = "admin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
    generator = "admin_sequence")
    private Long idAdmin;
    private String adminName;
    private String password;


    public Admin(String admiName, String password) {
        this.adminName = admiName;
        this.password = password;
    }
}
