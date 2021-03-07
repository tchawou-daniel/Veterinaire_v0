package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.Medicament;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeAnimalRepository extends JpaRepository<TypeAnimal, Integer> {
    List<TypeAnimal> findByLibtypeanimalLike(@Param("libtypeanimal") String libtypeanimal);
}
