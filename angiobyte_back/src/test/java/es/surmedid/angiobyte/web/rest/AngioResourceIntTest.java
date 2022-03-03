package es.surmedid.angiobyte.web.rest;

import es.surmedid.angiobyte.AngiobyteApp;

import es.surmedid.angiobyte.domain.Angio;
import es.surmedid.angiobyte.repository.AngioRepository;
import es.surmedid.angiobyte.service.AngioService;
import es.surmedid.angiobyte.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AngioResource REST controller.
 *
 * @see AngioResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AngiobyteApp.class)
public class AngioResourceIntTest {

    private static final Long DEFAULT_HISTORIAL = 1L;
    private static final Long UPDATED_HISTORIAL = 2L;

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final Integer DEFAULT_VISITA = 1;
    private static final Integer UPDATED_VISITA = 2;

    private static final String DEFAULT_DIRECCION = "AAAAAAAAAA";
    private static final String UPDATED_DIRECCION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FECHANAC = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECHANAC = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_FECHA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECHA = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NOTAS = "AAAAAAAAAA";
    private static final String UPDATED_NOTAS = "BBBBBBBBBB";

    private static final String DEFAULT_CIUDAD = "AAAAAAAAAA";
    private static final String UPDATED_CIUDAD = "BBBBBBBBBB";

    private static final String DEFAULT_PROCEDENCIA = "AAAAAAAAAA";
    private static final String UPDATED_PROCEDENCIA = "BBBBBBBBBB";

    private static final String DEFAULT_PROFESION = "AAAAAAAAAA";
    private static final String UPDATED_PROFESION = "BBBBBBBBBB";

    private static final String DEFAULT_ANTECEDENTES = "AAAAAAAAAA";
    private static final String UPDATED_ANTECEDENTES = "BBBBBBBBBB";

    private static final String DEFAULT_I_5 = "AAAAAAAAAA";
    private static final String UPDATED_I_5 = "BBBBBBBBBB";

    private static final String DEFAULT_I_6 = "AAAAAAAAAA";
    private static final String UPDATED_I_6 = "BBBBBBBBBB";

    private static final String DEFAULT_I_7 = "AAAAAAAAAA";
    private static final String UPDATED_I_7 = "BBBBBBBBBB";

    private static final String DEFAULT_I_8 = "AAAAAAAAAA";
    private static final String UPDATED_I_8 = "BBBBBBBBBB";

    private static final String DEFAULT_I_9 = "AAAAAAAAAA";
    private static final String UPDATED_I_9 = "BBBBBBBBBB";

    private static final String DEFAULT_I_10 = "AAAAAAAAAA";
    private static final String UPDATED_I_10 = "BBBBBBBBBB";

    private static final String DEFAULT_I_11 = "AAAAAAAAAA";
    private static final String UPDATED_I_11 = "BBBBBBBBBB";

    private static final String DEFAULT_I_12 = "AAAAAAAAAA";
    private static final String UPDATED_I_12 = "BBBBBBBBBB";

    private static final String DEFAULT_I_13 = "AAAAAAAAAA";
    private static final String UPDATED_I_13 = "BBBBBBBBBB";

    private static final String DEFAULT_I_14 = "AAAAAAAAAA";
    private static final String UPDATED_I_14 = "BBBBBBBBBB";

    private static final String DEFAULT_I_15 = "AAAAAAAAAA";
    private static final String UPDATED_I_15 = "BBBBBBBBBB";

    private static final String DEFAULT_I_16 = "AAAAAAAAAA";
    private static final String UPDATED_I_16 = "BBBBBBBBBB";

    private static final Integer DEFAULT_IMAGINET = 1;
    private static final Integer UPDATED_IMAGINET = 2;

    private static final String DEFAULT_NUHSA = "1";
    private static final String UPDATED_NUHSA = "2";

    @Autowired
    private AngioRepository angioRepository;

    @Autowired
    private AngioService angioService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAngioMockMvc;

    private Angio angio;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AngioResource angioResource = new AngioResource(angioService);
        this.restAngioMockMvc = MockMvcBuilders.standaloneSetup(angioResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Angio createEntity(EntityManager em) {
        Angio angio = new Angio()
            .historial(DEFAULT_HISTORIAL)
            .nombre(DEFAULT_NOMBRE)
            .visita(DEFAULT_VISITA)
            .direccion(DEFAULT_DIRECCION)
            .fechanac(DEFAULT_FECHANAC)
            .fecha(DEFAULT_FECHA)
            .notas(DEFAULT_NOTAS)
            .ciudad(DEFAULT_CIUDAD)
            .procedencia(DEFAULT_PROCEDENCIA)
            .profesion(DEFAULT_PROFESION)
            .antecedentes(DEFAULT_ANTECEDENTES)
            .i5(DEFAULT_I_5)
            .i6(DEFAULT_I_6)
            .i7(DEFAULT_I_7)
            .i8(DEFAULT_I_8)
            .i9(DEFAULT_I_9)
            .i10(DEFAULT_I_10)
            .i11(DEFAULT_I_11)
            .i12(DEFAULT_I_12)
            .i13(DEFAULT_I_13)
            .i14(DEFAULT_I_14)
            .i15(DEFAULT_I_15)
            .i16(DEFAULT_I_16)
            .imaginet(DEFAULT_IMAGINET)
            .nuhsa(DEFAULT_NUHSA);
        return angio;
    }

    @Before
    public void initTest() {
        angio = createEntity(em);
    }

    @Test
    @Transactional
    public void createAngio() throws Exception {
        int databaseSizeBeforeCreate = angioRepository.findAll().size();

        // Create the Angio
        restAngioMockMvc.perform(post("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isCreated());

        // Validate the Angio in the database
        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeCreate + 1);
        Angio testAngio = angioList.get(angioList.size() - 1);
        assertThat(testAngio.getHistorial()).isEqualTo(DEFAULT_HISTORIAL);
        assertThat(testAngio.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testAngio.getVisita()).isEqualTo(DEFAULT_VISITA);
        assertThat(testAngio.getDireccion()).isEqualTo(DEFAULT_DIRECCION);
        assertThat(testAngio.getFechanac()).isEqualTo(DEFAULT_FECHANAC);
        assertThat(testAngio.getFecha()).isEqualTo(DEFAULT_FECHA);
        assertThat(testAngio.getNotas()).isEqualTo(DEFAULT_NOTAS);
        assertThat(testAngio.getCiudad()).isEqualTo(DEFAULT_CIUDAD);
        assertThat(testAngio.getProcedencia()).isEqualTo(DEFAULT_PROCEDENCIA);
        assertThat(testAngio.getProfesion()).isEqualTo(DEFAULT_PROFESION);
        assertThat(testAngio.getAntecedentes()).isEqualTo(DEFAULT_ANTECEDENTES);
        assertThat(testAngio.geti5()).isEqualTo(DEFAULT_I_5);
        assertThat(testAngio.geti6()).isEqualTo(DEFAULT_I_6);
        assertThat(testAngio.geti7()).isEqualTo(DEFAULT_I_7);
        assertThat(testAngio.geti8()).isEqualTo(DEFAULT_I_8);
        assertThat(testAngio.geti9()).isEqualTo(DEFAULT_I_9);
        assertThat(testAngio.geti10()).isEqualTo(DEFAULT_I_10);
        assertThat(testAngio.geti11()).isEqualTo(DEFAULT_I_11);
        assertThat(testAngio.geti12()).isEqualTo(DEFAULT_I_12);
        assertThat(testAngio.geti13()).isEqualTo(DEFAULT_I_13);
        assertThat(testAngio.geti14()).isEqualTo(DEFAULT_I_14);
        assertThat(testAngio.geti15()).isEqualTo(DEFAULT_I_15);
        assertThat(testAngio.geti16()).isEqualTo(DEFAULT_I_16);
        assertThat(testAngio.getImaginet()).isEqualTo(DEFAULT_IMAGINET);
        assertThat(testAngio.getNuhsa()).isEqualTo(DEFAULT_NUHSA);
    }

    @Test
    @Transactional
    public void createAngioWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = angioRepository.findAll().size();

        // Create the Angio with an existing ID
        angio.setHistorial(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAngioMockMvc.perform(post("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isBadRequest());

        // Validate the Angio in the database
        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkHistorialIsRequired() throws Exception {
        int databaseSizeBeforeTest = angioRepository.findAll().size();
        // set the field null
        angio.setHistorial(null);

        // Create the Angio, which fails.

        restAngioMockMvc.perform(post("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isBadRequest());

        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNombreIsRequired() throws Exception {
        int databaseSizeBeforeTest = angioRepository.findAll().size();
        // set the field null
        angio.setNombre(null);

        // Create the Angio, which fails.

        restAngioMockMvc.perform(post("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isBadRequest());

        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkVisitaIsRequired() throws Exception {
        int databaseSizeBeforeTest = angioRepository.findAll().size();
        // set the field null
        angio.setVisita(null);

        // Create the Angio, which fails.

        restAngioMockMvc.perform(post("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isBadRequest());

        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAngios() throws Exception {
        // Initialize the database
        angioRepository.saveAndFlush(angio);

        // Get all the angioList
        restAngioMockMvc.perform(get("/api/angios?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].historial").value(hasItem(DEFAULT_HISTORIAL)))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE.toString())))
            .andExpect(jsonPath("$.[*].visita").value(hasItem(DEFAULT_VISITA)))
            .andExpect(jsonPath("$.[*].direccion").value(hasItem(DEFAULT_DIRECCION.toString())))
            .andExpect(jsonPath("$.[*].fechanac").value(hasItem(DEFAULT_FECHANAC.toString())))
            .andExpect(jsonPath("$.[*].fecha").value(hasItem(DEFAULT_FECHA.toString())))
            .andExpect(jsonPath("$.[*].notas").value(hasItem(DEFAULT_NOTAS.toString())))
            .andExpect(jsonPath("$.[*].ciudad").value(hasItem(DEFAULT_CIUDAD.toString())))
            .andExpect(jsonPath("$.[*].procedencia").value(hasItem(DEFAULT_PROCEDENCIA.toString())))
            .andExpect(jsonPath("$.[*].profesion").value(hasItem(DEFAULT_PROFESION.toString())))
            .andExpect(jsonPath("$.[*].antecedentes").value(hasItem(DEFAULT_ANTECEDENTES.toString())))
            .andExpect(jsonPath("$.[*].i5").value(hasItem(DEFAULT_I_5.toString())))
            .andExpect(jsonPath("$.[*].i6").value(hasItem(DEFAULT_I_6.toString())))
            .andExpect(jsonPath("$.[*].i7").value(hasItem(DEFAULT_I_7.toString())))
            .andExpect(jsonPath("$.[*].i8").value(hasItem(DEFAULT_I_8.toString())))
            .andExpect(jsonPath("$.[*].i9").value(hasItem(DEFAULT_I_9.toString())))
            .andExpect(jsonPath("$.[*].i10").value(hasItem(DEFAULT_I_10.toString())))
            .andExpect(jsonPath("$.[*].i11").value(hasItem(DEFAULT_I_11.toString())))
            .andExpect(jsonPath("$.[*].i12").value(hasItem(DEFAULT_I_12.toString())))
            .andExpect(jsonPath("$.[*].i13").value(hasItem(DEFAULT_I_13.toString())))
            .andExpect(jsonPath("$.[*].i14").value(hasItem(DEFAULT_I_14.toString())))
            .andExpect(jsonPath("$.[*].i15").value(hasItem(DEFAULT_I_15.toString())))
            .andExpect(jsonPath("$.[*].i16").value(hasItem(DEFAULT_I_16.toString())))
            .andExpect(jsonPath("$.[*].imaginet").value(hasItem(DEFAULT_IMAGINET)))
            .andExpect(jsonPath("$.[*].nuhsa").value(hasItem(DEFAULT_NUHSA.toString())));
    }

    @Test
    @Transactional
    public void getAngio() throws Exception {
        // Initialize the database
        angioRepository.saveAndFlush(angio);

        // Get the angio
        restAngioMockMvc.perform(get("/api/angios/{id}", angio.getHistorial()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.historial").value(DEFAULT_HISTORIAL))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE.toString()))
            .andExpect(jsonPath("$.visita").value(DEFAULT_VISITA))
            .andExpect(jsonPath("$.direccion").value(DEFAULT_DIRECCION.toString()))
            .andExpect(jsonPath("$.fechanac").value(DEFAULT_FECHANAC.toString()))
            .andExpect(jsonPath("$.fecha").value(DEFAULT_FECHA.toString()))
            .andExpect(jsonPath("$.notas").value(DEFAULT_NOTAS.toString()))
            .andExpect(jsonPath("$.ciudad").value(DEFAULT_CIUDAD.toString()))
            .andExpect(jsonPath("$.procedencia").value(DEFAULT_PROCEDENCIA.toString()))
            .andExpect(jsonPath("$.profesion").value(DEFAULT_PROFESION.toString()))
            .andExpect(jsonPath("$.antecedentes").value(DEFAULT_ANTECEDENTES.toString()))
            .andExpect(jsonPath("$.i5").value(DEFAULT_I_5.toString()))
            .andExpect(jsonPath("$.i6").value(DEFAULT_I_6.toString()))
            .andExpect(jsonPath("$.i7").value(DEFAULT_I_7.toString()))
            .andExpect(jsonPath("$.i8").value(DEFAULT_I_8.toString()))
            .andExpect(jsonPath("$.i9").value(DEFAULT_I_9.toString()))
            .andExpect(jsonPath("$.i10").value(DEFAULT_I_10.toString()))
            .andExpect(jsonPath("$.i11").value(DEFAULT_I_11.toString()))
            .andExpect(jsonPath("$.i12").value(DEFAULT_I_12.toString()))
            .andExpect(jsonPath("$.i13").value(DEFAULT_I_13.toString()))
            .andExpect(jsonPath("$.i14").value(DEFAULT_I_14.toString()))
            .andExpect(jsonPath("$.i15").value(DEFAULT_I_15.toString()))
            .andExpect(jsonPath("$.i16").value(DEFAULT_I_16.toString()))
            .andExpect(jsonPath("$.imaginet").value(DEFAULT_IMAGINET))
            .andExpect(jsonPath("$.nuhsa").value(DEFAULT_NUHSA.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingAngio() throws Exception {
        // Get the angio
        restAngioMockMvc.perform(get("/api/angios/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }
/*
    @Test
    @Transactional
    public void updateAngio() throws Exception {
        // Initialize the database
        angioService.save(angio);

        int databaseSizeBeforeUpdate = angioRepository.findAll().size();

        // Update the angio
        Angio updatedAngio = angioRepository.findOne(angio.getHistorial());
        updatedAngio
            .historial(UPDATED_HISTORIAL)
            .nombre(UPDATED_NOMBRE)
            .visita(UPDATED_VISITA)
            .direccion(UPDATED_DIRECCION)
            .fechanac(UPDATED_FECHANAC)
            .fecha(UPDATED_FECHA)
            .notas(UPDATED_NOTAS)
            .ciudad(UPDATED_CIUDAD)
            .procedencia(UPDATED_PROCEDENCIA)
            .profesion(UPDATED_PROFESION)
            .antecedentes(UPDATED_ANTECEDENTES)
            .i5(UPDATED_I_5)
            .i6(UPDATED_I_6)
            .i7(UPDATED_I_7)
            .i8(UPDATED_I_8)
            .i9(UPDATED_I_9)
            .i10(UPDATED_I_10)
            .i11(UPDATED_I_11)
            .i12(UPDATED_I_12)
            .i13(UPDATED_I_13)
            .i14(UPDATED_I_14)
            .i15(UPDATED_I_15)
            .i16(UPDATED_I_16)
            .imaginet(UPDATED_IMAGINET)
            .nuhsa(UPDATED_NUHSA);

        restAngioMockMvc.perform(put("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAngio)))
            .andExpect(status().isOk());

        // Validate the Angio in the database
        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeUpdate);
        Angio testAngio = angioList.get(angioList.size() - 1);
        assertThat(testAngio.getHistorial()).isEqualTo(UPDATED_HISTORIAL);
        assertThat(testAngio.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testAngio.getVisita()).isEqualTo(UPDATED_VISITA);
        assertThat(testAngio.getDireccion()).isEqualTo(UPDATED_DIRECCION);
        assertThat(testAngio.getFechanac()).isEqualTo(UPDATED_FECHANAC);
        assertThat(testAngio.getFecha()).isEqualTo(UPDATED_FECHA);
        assertThat(testAngio.getNotas()).isEqualTo(UPDATED_NOTAS);
        assertThat(testAngio.getCiudad()).isEqualTo(UPDATED_CIUDAD);
        assertThat(testAngio.getProcedencia()).isEqualTo(UPDATED_PROCEDENCIA);
        assertThat(testAngio.getProfesion()).isEqualTo(UPDATED_PROFESION);
        assertThat(testAngio.getAntecedentes()).isEqualTo(UPDATED_ANTECEDENTES);
        assertThat(testAngio.geti5()).isEqualTo(UPDATED_I_5);
        assertThat(testAngio.geti6()).isEqualTo(UPDATED_I_6);
        assertThat(testAngio.geti7()).isEqualTo(UPDATED_I_7);
        assertThat(testAngio.geti8()).isEqualTo(UPDATED_I_8);
        assertThat(testAngio.geti9()).isEqualTo(UPDATED_I_9);
        assertThat(testAngio.geti10()).isEqualTo(UPDATED_I_10);
        assertThat(testAngio.geti11()).isEqualTo(UPDATED_I_11);
        assertThat(testAngio.geti12()).isEqualTo(UPDATED_I_12);
        assertThat(testAngio.geti13()).isEqualTo(UPDATED_I_13);
        assertThat(testAngio.geti14()).isEqualTo(UPDATED_I_14);
        assertThat(testAngio.geti15()).isEqualTo(UPDATED_I_15);
        assertThat(testAngio.geti16()).isEqualTo(UPDATED_I_16);
        assertThat(testAngio.getImaginet()).isEqualTo(UPDATED_IMAGINET);
        assertThat(testAngio.getNuhsa()).isEqualTo(UPDATED_NUHSA);
    }*/

    @Test
    @Transactional
    public void updateNonExistingAngio() throws Exception {
        int databaseSizeBeforeUpdate = angioRepository.findAll().size();

        // Create the Angio

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAngioMockMvc.perform(put("/api/angios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(angio)))
            .andExpect(status().isCreated());

        // Validate the Angio in the database
        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteAngio() throws Exception {
        // Initialize the database
        angioService.save(angio);

        int databaseSizeBeforeDelete = angioRepository.findAll().size();

        // Get the angio
        restAngioMockMvc.perform(delete("/api/angios/{id}", angio.getHistorial())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Angio> angioList = angioRepository.findAll();
        assertThat(angioList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Angio.class);
        Angio angio1 = new Angio();
        angio1.setHistorial(1L);
        Angio angio2 = new Angio();
        angio2.setHistorial(angio1.getHistorial());
        assertThat(angio1).isEqualTo(angio2);
        angio2.setHistorial(2L);
        assertThat(angio1).isNotEqualTo(angio2);
        angio1.setHistorial(null);
        assertThat(angio1).isNotEqualTo(angio2);
    }
}
