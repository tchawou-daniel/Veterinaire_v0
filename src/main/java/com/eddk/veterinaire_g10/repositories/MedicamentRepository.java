package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer>, JpaSpecificationExecutor<Medicament>, CrudRepository<Medicament, Integer> {
    List<Medicament> findByNommedicamentLike(@Param("nommedicament") String nommedicament);
}
