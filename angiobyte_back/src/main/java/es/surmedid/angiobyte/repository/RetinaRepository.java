package es.surmedid.angiobyte.repository;

import es.surmedid.angiobyte.domain.Retina;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Retina entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RetinaRepository extends JpaRepository<Retina, Integer> {

	List<Retina> findByNuhsa(String id);
	List<Retina> findByHistorial(Integer id);

}
