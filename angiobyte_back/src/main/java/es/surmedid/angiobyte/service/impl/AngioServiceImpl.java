package es.surmedid.angiobyte.service.impl;

import es.surmedid.angiobyte.service.AngioService;
import es.surmedid.angiobyte.domain.Angio;
import es.surmedid.angiobyte.repository.AngioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Angio.
 */
@Service
@Transactional
public class AngioServiceImpl implements AngioService{

    private final Logger log = LoggerFactory.getLogger(AngioServiceImpl.class);

    private final AngioRepository angioRepository;

    public AngioServiceImpl(AngioRepository angioRepository) {
        this.angioRepository = angioRepository;
    }

    /**
     * Save a angio.
     *
     * @param angio the entity to save
     * @return the persisted entity
     */
    @Override
    public Angio save(Angio angio) {
        log.debug("Request to save Angio : {}", angio);
        return angioRepository.save(angio);
    }

    /**
     *  Get all the angios.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Angio> findAll(Pageable pageable) {
        log.debug("Request to get all Angios");
        return angioRepository.findAll(pageable);
    }

    /**
     *  Get one angio by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Angio findOne(Integer id) {
        log.debug("Request to get Angio : {}", id);
        return angioRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public int count() {
        return angioRepository.findAll().size();
    }

}
