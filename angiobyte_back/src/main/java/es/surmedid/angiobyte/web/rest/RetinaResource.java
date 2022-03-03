package es.surmedid.angiobyte.web.rest;

import com.codahale.metrics.annotation.Timed;

import es.surmedid.angiobyte.domain.Angio;
import es.surmedid.angiobyte.domain.Retina;
import es.surmedid.angiobyte.service.AngioService;
import es.surmedid.angiobyte.service.RetinaService;
import es.surmedid.angiobyte.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Retina.
 */
@RestController
@RequestMapping("/api")
public class RetinaResource {

    private final Logger log = LoggerFactory.getLogger(RetinaResource.class);

    private static final String ENTITY_NAME = "retina";

    private final RetinaService retinaService;
    private final AngioService angioService;

    public RetinaResource(RetinaService retinaService, AngioService angioService) {
        this.retinaService = retinaService;
        this.angioService = angioService;
    }

    /**
     * POST  /retinas : Create a new retina.
     *
     * @param retina the retina to create
     * @return the ResponseEntity with status 201 (Created) and with body the new retina, or with status 400 (Bad Request) if the retina has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/retinas")
    @Timed
    public ResponseEntity<Retina> createRetina(@Valid @RequestBody Retina retina) throws URISyntaxException {
        log.debug("REST request to save Retina : {}", retina);
        if (retina.getHistorial() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new retina cannot already have an ID")).body(null);
        }
        Retina result = retinaService.save(retina);
        return ResponseEntity.created(new URI("/api/retinas/" + result.getHistorial()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getHistorial().toString()))
            .body(result);
    }

    /**
     * PUT  /retinas : Updates an existing retina.
     *
     * @param retina the retina to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated retina,
     * or with status 400 (Bad Request) if the retina is not valid,
     * or with status 500 (Internal Server Error) if the retina couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/retinas")
    @Timed
    public ResponseEntity<Retina> updateRetina(@Valid @RequestBody Retina retina) throws URISyntaxException {
        log.debug("REST request to update Retina : {}", retina);
        if (retina.getHistorial() == null) {
            return createRetina(retina);
        }
        Retina result = retinaService.save(retina);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, retina.getHistorial().toString()))
            .body(result);
    }

    /**
     * GET  /retinas : get all the retinas.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of retinas in body
     */
    @GetMapping("/retinas")
    @Timed
    public List<Retina> getAllRetinas() {
        log.debug("REST request to get all Retinas");
        return retinaService.findAll();
        }

    /**
     * GET  /retinas/:id : get the "id" retina.
     *
     * @param id the id of the retina to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the retina, or with status 404 (Not Found)
     */
    @GetMapping("/retinas/{id}")
    @Timed
    public ResponseEntity<List<Retina>> getRetina(@PathVariable String id) {
        log.debug("REST request to get Retina : {}", id);
		Angio angio = angioService.findByNuhsa(id);
		Long historial = null;
		historial = angio.getHistorial();
        List<Retina> retina = retinaService.findByHistorial(historial);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(retina));
    }

    /**
     * DELETE  /retinas/:id : delete the "id" retina.
     *
     * @param id the id of the retina to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/retinas/{id}")
    @Timed
    public ResponseEntity<Void> deleteRetina(@PathVariable Integer id) {
        log.debug("REST request to delete Retina : {}", id);
        retinaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
