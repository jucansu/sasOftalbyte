package es.surmedid.angiobyte.service.impl;

import es.surmedid.angiobyte.service.RetinaService;
import es.surmedid.angiobyte.domain.Retina;
import es.surmedid.angiobyte.repository.RetinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Retina.
 */
@Service
@Transactional
public class RetinaServiceImpl implements RetinaService{

    private final Logger log = LoggerFactory.getLogger(RetinaServiceImpl.class);

    private final RetinaRepository retinaRepository;

    public RetinaServiceImpl(RetinaRepository retinaRepository) {
        this.retinaRepository = retinaRepository;
    }

    /**
     * Save a retina.
     *
     * @param retina the entity to save
     * @return the persisted entity
     */
    @Override
    public Retina save(Retina retina) {
        log.debug("Request to save Retina : {}", retina);
        return retinaRepository.save(retina);
    }

    /**
     *  Get all the retinas.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Retina> findAll() {
        log.debug("Request to get all Retinas");
        return retinaRepository.findAll();
    }

    /**
     *  Get all retina by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public List<Retina> findByNuhsa(String id) {
        log.debug("Request to get Retina : {}", id);
        return retinaRepository.findByNuhsa(id);
    }

    /**
     *  Get all retina by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public List<Retina> findByHistorial(Long id) {
        log.debug("Request to get Retina : {}", id);
        return retinaRepository.findByHistorial(id);
    }
    
    /**
     *  Delete the  retina by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Retina : {}", id);
        retinaRepository.delete(id);
    }

    /**
     *  Get one retina by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Retina findOne(Integer id) {
        log.debug("Request to get Retina : {}", id);
        return retinaRepository.findOne(id);
    }
}
