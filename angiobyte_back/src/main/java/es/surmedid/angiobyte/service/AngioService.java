package es.surmedid.angiobyte.service;

import es.surmedid.angiobyte.domain.Angio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Angio.
 */
public interface AngioService {

    /**
     * Save a angio.
     *
     * @param angio the entity to save
     * @return the persisted entity
     */
    Angio save(Angio angio);

    /**
     *  Get all the angios.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<Angio> findAll(Pageable pageable);

    /**
     *  Get the "id" angio.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Angio findOne(Integer id);

	int count();

	/**
	 *  Get one angio by id.
	 *
	 *  @param id the id of the entity
	 *  @return the entity
	 */
	Angio findByNuhsa(String id);

}
