package com.example.Gestion_Des_Caisses;


import com.example.Gestion_Des_Caisses.models.Achat;
import com.example.Gestion_Des_Caisses.models.Admin;
import com.example.Gestion_Des_Caisses.models.Produit;
import com.example.Gestion_Des_Caisses.repositories.AchatRepository;
import com.example.Gestion_Des_Caisses.repositories.AdminRepository;
import com.example.Gestion_Des_Caisses.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository,
                                        AdminRepository adminRepository,
                                        AchatRepository achatRepository){
        return args -> {
            Produit produit1 = new Produit("6190000001","Lait","Alimentaire",1350L,10L,"Lait Vitalait","../../assets/lait.jpg");
            Produit produit2 = new Produit("6190000002","Yaourt","Alimentaire",350L,100L,"Yaourt Delice","../../assets/yaourt.webp");
            Produit produit3 = new Produit("6190000003","Fromage","Alimentaire",1850L,100L,"Fromage Presedent","../../assets/fromage.jpg");

            Produit produit4 = new Produit("6190000004","shampoing","Cosmetique",3500L,10L,"shampoing  Head & Shoulder","../../assets/shamp.jpg");
            Produit produit5 = new Produit("6190000005","Savon","Cosmetique",1000L,10L,"shampoing  Head & Shoulder","../../assets/savon.jpg");

            Produit produit6 = new Produit("6190000006","Viande de Boeuf","Viande",28000L,10L,"Viande de Boeuf","../../assets/viande1.webp");
            Produit produit7 = new Produit("6190000007","Viande de lapin","Viande",25000L,10L,"Viande de lapin","../../assets/viande2.webp");



            Achat achat1 = new Achat(LocalDate.of(2022, Month.JULY,10),10.0);
            Achat achat2 = new Achat(LocalDate.of(2022, Month.JULY,16),10.0);
            Achat achat3 = new Achat(LocalDate.of(2022, Month.JULY,19),10.0);
            Admin admin1 = new Admin("admin","admin");
            achat1.addAchat(produit1);
            achat1.addAchat(produit2);
            achat1.addAchat(produit3);
            achat1.addAchat(produit3);
            achat1.addAchat(produit5);
            achat1.addAchat(produit5);
            achat1.addAchat(produit6);

            achat2.addAchat(produit2);
            achat2.addAchat(produit3);
            achat2.addAchat(produit4);
            achat2.addAchat(produit4);
            achat2.addAchat(produit5);
            achat2.addAchat(produit7);
            achat2.addAchat(produit7);

            achat3.addAchat(produit1);
            achat3.addAchat(produit1);
            achat3.addAchat(produit1);
            achat3.addAchat(produit5);
            achat3.addAchat(produit7);






            produitRepository.saveAll(List.of(produit1,produit2,produit3,produit4,produit5,produit6,produit7));
            achatRepository.saveAll(List.of(achat1,achat2,achat3));
            adminRepository.saveAll(List.of(admin1));

        };
    }
}
