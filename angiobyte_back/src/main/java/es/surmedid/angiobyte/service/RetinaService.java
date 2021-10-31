package es.surmedid.angiobyte.service;

import es.surmedid.angiobyte.domain.Retina;
import java.util.List;

/**
 * Service Interface for managing Retina.
 */
public interface RetinaService {

    /**
     * Save a retina.
     *
     * @param retina the entity to save
     * @return the persisted entity
     */
    Retina save(Retina retina);

    /**
     *  Get all the retinas.
     *
     *  @return the list of entities
     */
    List<Retina> findAll();

    /**
     *  Get the "id" retina.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Retina findOne(Integer id);

    /**
     *  Delete the "id" retina.
     *
     *  @param id the id of the entity
     */
    void delete(Integer id);


	List<Retina> findByHistorial(Integer id);

	List<Retina> findByNuhsa(String id);
}
