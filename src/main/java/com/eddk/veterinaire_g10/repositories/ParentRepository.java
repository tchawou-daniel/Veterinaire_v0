package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
    //List<Parent> findByNomparentLike(@Param("nomparent") String nomparent);

    List<Parent> findByNomparentLike(String s);
}
