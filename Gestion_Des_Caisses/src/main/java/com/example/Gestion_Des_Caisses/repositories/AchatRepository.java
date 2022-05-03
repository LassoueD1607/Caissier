package com.example.Gestion_Des_Caisses.repositories;

import com.example.Gestion_Des_Caisses.models.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AchatRepository extends JpaRepository<Achat,Long> {
}
