package es.surmedid.angiobyte.web.rest;

import com.codahale.metrics.annotation.Timed;
import es.surmedid.angiobyte.domain.Angio;
import es.surmedid.angiobyte.service.AngioService;
import es.surmedid.angiobyte.web.rest.util.HeaderUtil;
import es.surmedid.angiobyte.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Angio.
 */
@RestController
@RequestMapping("/api")
public class AngioResource {

    private final Logger log = LoggerFactory.getLogger(AngioResource.class);

    private static final String ENTITY_NAME = "angio";

    private final AngioService angioService;

    public AngioResource(AngioService angioService) {
        this.angioService = angioService;
    }

    /**
     * POST  /angios : Create a new angio.
     *
     * @param angio the angio to create
     * @return the ResponseEntity with status 201 (Created) and with body the new angio, or with status 400 (Bad Request) if the angio has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/angios")
    @Timed
    public ResponseEntity<Angio> createAngio(@Valid @RequestBody Angio angio) throws URISyntaxException {
        log.debug("REST request to save Angio : {}", angio);
        if (angio.getHistorial() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new angio cannot already have an ID")).body(null);
        }
        Angio result = angioService.save(angio);
        return ResponseEntity.created(new URI("/api/angios/" + result.getHistorial()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getHistorial().toString()))
            .body(result);
    }

    /**
     * PUT  /angios : Updates an existing angio.
     *
     * @param angio the angio to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated angio,
     * or with status 400 (Bad Request) if the angio is not valid,
     * or with status 500 (Internal Server Error) if the angio couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/angios")
    @Timed
    public ResponseEntity<Angio> updateAngio(@Valid @RequestBody Angio angio) throws URISyntaxException {
        log.debug("REST request to update Angio : {}", angio);
        if (angio.getHistorial() == null) {
            return createAngio(angio);
        }
        Angio result = angioService.save(angio);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, angio.getHistorial().toString()))
            .body(result);
    }

    /**
     * GET  /angios : get all the angios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of angios in body
     */
    @GetMapping("/angios")
    @Timed
    public ResponseEntity<List<Angio>> getAllAngios(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Angios");
        int totalAngioItems;
        Page<Angio> page = angioService.findAll(pageable);
        List<Angio> listWithoutNull = page.getContent().stream().filter(T -> !Objects.isNull(T)).collect(Collectors.toList());
        totalAngioItems = angioService.count();

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/angios");
       // headers.add("X-Total-Count", String.valueOf(totalAngioItems));
        return new ResponseEntity<>(listWithoutNull, headers, HttpStatus.OK);
    }
    
    /**
     * GET  /angios/:id : get the "id" angio.
     *
     * @param id the id of the angio to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the angio, or with status 404 (Not Found)
     */
    @GetMapping("/angios/{id}")
    @Timed
    public ResponseEntity<Angio> getAngio(@PathVariable String id) {
        log.debug("REST request to get Angio : {}", id);
        Angio angio = angioService.findByNuhsa(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(angio));
    }
    

}
