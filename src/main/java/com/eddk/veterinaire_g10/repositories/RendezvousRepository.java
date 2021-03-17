package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.RendezVous;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RendezvousRepository extends JpaRepository<RendezVous, Integer> {

    RendezVous findByDaterdvLike(@Param("daterdv") Date rdvd);

    RendezVous findByHeuredebutrdvLike(@Param("heuredebutrdv") Date rdvhd);

    RendezVous findByHeurefinrdvLike(@Param("heurefinrdv") Date rdvhf);

    List<RendezVous> findBynomrdvLike(@Param("nomrdv") String nomrdv);

}
