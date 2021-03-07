package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
    List<Medecin> findByNommedecinLike(@Param("name") String name);
}
