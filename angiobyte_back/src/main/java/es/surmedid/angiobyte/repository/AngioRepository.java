package es.surmedid.angiobyte.repository;

import es.surmedid.angiobyte.domain.Angio;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Angio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AngioRepository extends JpaRepository<Angio, Integer> {

public Angio findByNuhsa(String nuhsa);
}
