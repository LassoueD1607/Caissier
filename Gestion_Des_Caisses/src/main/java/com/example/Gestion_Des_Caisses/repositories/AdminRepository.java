package com.example.Gestion_Des_Caisses.repositories;

import com.example.Gestion_Des_Caisses.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
