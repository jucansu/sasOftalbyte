package es.surmedid.angiobyte.web.rest;

import es.surmedid.angiobyte.AngiobyteApp;

import es.surmedid.angiobyte.domain.Retina;
import es.surmedid.angiobyte.repository.RetinaRepository;
import es.surmedid.angiobyte.service.RetinaService;
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
 * Test class for the RetinaResource REST controller.
 *
 * @see RetinaResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AngiobyteApp.class)
public class RetinaResourceIntTest {

    private static final Long DEFAULT_HISTORIAL = 1L;
    private static final Long UPDATED_HISTORIAL = 2L;

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final Integer DEFAULT_VISITA = 1;
    private static final Integer UPDATED_VISITA = 2;

    private static final String DEFAULT_DIAGANGIO = "AAAAAAAAAA";
    private static final String UPDATED_DIAGANGIO = "BBBBBBBBBB";

    private static final String DEFAULT_DIAGOFT = "AAAAAAAAAA";
    private static final String UPDATED_DIAGOFT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FECHA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECHA = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NOTAS = "AAAAAAAAAA";
    private static final String UPDATED_NOTAS = "BBBBBBBBBB";

    private static final String DEFAULT_R_1 = "AAAAAAAAAA";
    private static final String UPDATED_R_1 = "BBBBBBBBBB";

    private static final String DEFAULT_R_2 = "AAAAAAAAAA";
    private static final String UPDATED_R_2 = "BBBBBBBBBB";

    private static final String DEFAULT_R_3 = "AAAAAAAAAA";
    private static final String UPDATED_R_3 = "BBBBBBBBBB";

    private static final String DEFAULT_R_4 = "AAAAAAAAAA";
    private static final String UPDATED_R_4 = "BBBBBBBBBB";

    private static final String DEFAULT_R_5 = "AAAAAAAAAA";
    private static final String UPDATED_R_5 = "BBBBBBBBBB";

    private static final String DEFAULT_R_6 = "AAAAAAAAAA";
    private static final String UPDATED_R_6 = "BBBBBBBBBB";

    private static final String DEFAULT_R_7 = "AAAAAAAAAA";
    private static final String UPDATED_R_7 = "BBBBBBBBBB";

    private static final String DEFAULT_R_8 = "AAAAAAAAAA";
    private static final String UPDATED_R_8 = "BBBBBBBBBB";

    private static final String DEFAULT_R_9 = "AAAAAAAAAA";
    private static final String UPDATED_R_9 = "BBBBBBBBBB";

    private static final String DEFAULT_R_10 = "AAAAAAAAAA";
    private static final String UPDATED_R_10 = "BBBBBBBBBB";

    private static final String DEFAULT_R_11 = "AAAAAAAAAA";
    private static final String UPDATED_R_11 = "BBBBBBBBBB";

    private static final String DEFAULT_R_12 = "AAAAAAAAAA";
    private static final String UPDATED_R_12 = "BBBBBBBBBB";

    private static final String DEFAULT_R_13 = "AAAAAAAAAA";
    private static final String UPDATED_R_13 = "BBBBBBBBBB";

    private static final String DEFAULT_R_14 = "AAAAAAAAAA";
    private static final String UPDATED_R_14 = "BBBBBBBBBB";

    private static final String DEFAULT_R_15 = "AAAAAAAAAA";
    private static final String UPDATED_R_15 = "BBBBBBBBBB";

    private static final String DEFAULT_R_16 = "AAAAAAAAAA";
    private static final String UPDATED_R_16 = "BBBBBBBBBB";

    private static final String DEFAULT_R_17 = "AAAAAAAAAA";
    private static final String UPDATED_R_17 = "BBBBBBBBBB";

    private static final String DEFAULT_R_18 = "AAAAAAAAAA";
    private static final String UPDATED_R_18 = "BBBBBBBBBB";

    private static final String DEFAULT_R_19 = "AAAAAAAAAA";
    private static final String UPDATED_R_19 = "BBBBBBBBBB";

    private static final String DEFAULT_R_20 = "AAAAAAAAAA";
    private static final String UPDATED_R_20 = "BBBBBBBBBB";

    private static final String DEFAULT_R_21 = "AAAAAAAAAA";
    private static final String UPDATED_R_21 = "BBBBBBBBBB";

    private static final String DEFAULT_R_22 = "AAAAAAAAAA";
    private static final String UPDATED_R_22 = "BBBBBBBBBB";

    private static final String DEFAULT_R_23 = "AAAAAAAAAA";
    private static final String UPDATED_R_23 = "BBBBBBBBBB";

    private static final String DEFAULT_R_24 = "AAAAAAAAAA";
    private static final String UPDATED_R_24 = "BBBBBBBBBB";

    private static final String DEFAULT_R_25 = "AAAAAAAAAA";
    private static final String UPDATED_R_25 = "BBBBBBBBBB";

    private static final String DEFAULT_R_26 = "AAAAAAAAAA";
    private static final String UPDATED_R_26 = "BBBBBBBBBB";

    private static final String DEFAULT_R_27 = "AAAAAAAAAA";
    private static final String UPDATED_R_27 = "BBBBBBBBBB";

    private static final String DEFAULT_R_28 = "AAAAAAAAAA";
    private static final String UPDATED_R_28 = "BBBBBBBBBB";

    private static final String DEFAULT_R_29 = "AAAAAAAAAA";
    private static final String UPDATED_R_29 = "BBBBBBBBBB";

    private static final String DEFAULT_R_30 = "AAAAAAAAAA";
    private static final String UPDATED_R_30 = "BBBBBBBBBB";

    private static final String DEFAULT_R_31 = "AAAAAAAAAA";
    private static final String UPDATED_R_31 = "BBBBBBBBBB";

    private static final String DEFAULT_R_32 = "AAAAAAAAAA";
    private static final String UPDATED_R_32 = "BBBBBBBBBB";

    private static final String DEFAULT_R_33 = "AAAAAAAAAA";
    private static final String UPDATED_R_33 = "BBBBBBBBBB";

    private static final String DEFAULT_R_34 = "AAAAAAAAAA";
    private static final String UPDATED_R_34 = "BBBBBBBBBB";

    private static final String DEFAULT_R_35 = "AAAAAAAAAA";
    private static final String UPDATED_R_35 = "BBBBBBBBBB";

    private static final String DEFAULT_R_36 = "AAAAAAAAAA";
    private static final String UPDATED_R_36 = "BBBBBBBBBB";

    private static final String DEFAULT_R_37 = "AAAAAAAAAA";
    private static final String UPDATED_R_37 = "BBBBBBBBBB";

    private static final String DEFAULT_R_38 = "AAAAAAAAAA";
    private static final String UPDATED_R_38 = "BBBBBBBBBB";

    private static final String DEFAULT_R_39 = "AAAAAAAAAA";
    private static final String UPDATED_R_39 = "BBBBBBBBBB";

    private static final String DEFAULT_R_40 = "AAAAAAAAAA";
    private static final String UPDATED_R_40 = "BBBBBBBBBB";

    private static final String DEFAULT_R_41 = "AAAAAAAAAA";
    private static final String UPDATED_R_41 = "BBBBBBBBBB";

    private static final String DEFAULT_R_42 = "AAAAAAAAAA";
    private static final String UPDATED_R_42 = "BBBBBBBBBB";

    private static final String DEFAULT_R_43 = "AAAAAAAAAA";
    private static final String UPDATED_R_43 = "BBBBBBBBBB";

    private static final String DEFAULT_R_44 = "AAAAAAAAAA";
    private static final String UPDATED_R_44 = "BBBBBBBBBB";

    private static final String DEFAULT_R_45 = "AAAAAAAAAA";
    private static final String UPDATED_R_45 = "BBBBBBBBBB";

    private static final String DEFAULT_R_46 = "AAAAAAAAAA";
    private static final String UPDATED_R_46 = "BBBBBBBBBB";

    private static final String DEFAULT_R_47 = "AAAAAAAAAA";
    private static final String UPDATED_R_47 = "BBBBBBBBBB";

    private static final String DEFAULT_R_48 = "AAAAAAAAAA";
    private static final String UPDATED_R_48 = "BBBBBBBBBB";

    private static final String DEFAULT_R_49 = "AAAAAAAAAA";
    private static final String UPDATED_R_49 = "BBBBBBBBBB";

    private static final String DEFAULT_R_50 = "AAAAAAAAAA";
    private static final String UPDATED_R_50 = "BBBBBBBBBB";

    private static final String DEFAULT_R_51 = "AAAAAAAAAA";
    private static final String UPDATED_R_51 = "BBBBBBBBBB";

    private static final String DEFAULT_R_52 = "AAAAAAAAAA";
    private static final String UPDATED_R_52 = "BBBBBBBBBB";

    private static final String DEFAULT_R_53 = "AAAAAAAAAA";
    private static final String UPDATED_R_53 = "BBBBBBBBBB";

    private static final String DEFAULT_R_54 = "AAAAAAAAAA";
    private static final String UPDATED_R_54 = "BBBBBBBBBB";

    private static final String DEFAULT_R_55 = "AAAAAAAAAA";
    private static final String UPDATED_R_55 = "BBBBBBBBBB";

    private static final String DEFAULT_I_1 = "AAAAAAAAAA";
    private static final String UPDATED_I_1 = "BBBBBBBBBB";

    private static final String DEFAULT_I_2 = "AAAAAAAAAA";
    private static final String UPDATED_I_2 = "BBBBBBBBBB";

    private static final String DEFAULT_I_3 = "AAAAAAAAAA";
    private static final String UPDATED_I_3 = "BBBBBBBBBB";

    private static final String DEFAULT_I_4 = "AAAAAAAAAA";
    private static final String UPDATED_I_4 = "BBBBBBBBBB";

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

    private static final String DEFAULT_I_17 = "AAAAAAAAAA";
    private static final String UPDATED_I_17 = "BBBBBBBBBB";

    private static final String DEFAULT_I_18 = "AAAAAAAAAA";
    private static final String UPDATED_I_18 = "BBBBBBBBBB";

    private static final String DEFAULT_I_19 = "AAAAAAAAAA";
    private static final String UPDATED_I_19 = "BBBBBBBBBB";

    private static final String DEFAULT_I_20 = "AAAAAAAAAA";
    private static final String UPDATED_I_20 = "BBBBBBBBBB";

    private static final String DEFAULT_I_21 = "AAAAAAAAAA";
    private static final String UPDATED_I_21 = "BBBBBBBBBB";

    private static final String DEFAULT_I_22 = "AAAAAAAAAA";
    private static final String UPDATED_I_22 = "BBBBBBBBBB";

    private static final String DEFAULT_I_23 = "AAAAAAAAAA";
    private static final String UPDATED_I_23 = "BBBBBBBBBB";

    private static final String DEFAULT_I_24 = "AAAAAAAAAA";
    private static final String UPDATED_I_24 = "BBBBBBBBBB";

    private static final String DEFAULT_I_25 = "AAAAAAAAAA";
    private static final String UPDATED_I_25 = "BBBBBBBBBB";

    private static final String DEFAULT_I_26 = "AAAAAAAAAA";
    private static final String UPDATED_I_26 = "BBBBBBBBBB";

    private static final String DEFAULT_I_27 = "AAAAAAAAAA";
    private static final String UPDATED_I_27 = "BBBBBBBBBB";

    private static final String DEFAULT_I_28 = "AAAAAAAAAA";
    private static final String UPDATED_I_28 = "BBBBBBBBBB";

    private static final String DEFAULT_I_29 = "AAAAAAAAAA";
    private static final String UPDATED_I_29 = "BBBBBBBBBB";

    private static final String DEFAULT_I_30 = "AAAAAAAAAA";
    private static final String UPDATED_I_30 = "BBBBBBBBBB";

    private static final String DEFAULT_I_31 = "AAAAAAAAAA";
    private static final String UPDATED_I_31 = "BBBBBBBBBB";

    private static final String DEFAULT_I_32 = "AAAAAAAAAA";
    private static final String UPDATED_I_32 = "BBBBBBBBBB";

    private static final String DEFAULT_I_33 = "AAAAAAAAAA";
    private static final String UPDATED_I_33 = "BBBBBBBBBB";

    private static final String DEFAULT_I_34 = "AAAAAAAAAA";
    private static final String UPDATED_I_34 = "BBBBBBBBBB";

    private static final String DEFAULT_I_35 = "AAAAAAAAAA";
    private static final String UPDATED_I_35 = "BBBBBBBBBB";

    private static final String DEFAULT_I_36 = "AAAAAAAAAA";
    private static final String UPDATED_I_36 = "BBBBBBBBBB";

    private static final String DEFAULT_I_37 = "AAAAAAAAAA";
    private static final String UPDATED_I_37 = "BBBBBBBBBB";

    private static final String DEFAULT_I_38 = "AAAAAAAAAA";
    private static final String UPDATED_I_38 = "BBBBBBBBBB";

    private static final String DEFAULT_I_39 = "AAAAAAAAAA";
    private static final String UPDATED_I_39 = "BBBBBBBBBB";

    private static final String DEFAULT_I_40 = "AAAAAAAAAA";
    private static final String UPDATED_I_40 = "BBBBBBBBBB";

    private static final String DEFAULT_I_41 = "AAAAAAAAAA";
    private static final String UPDATED_I_41 = "BBBBBBBBBB";

    private static final String DEFAULT_I_42 = "AAAAAAAAAA";
    private static final String UPDATED_I_42 = "BBBBBBBBBB";

    private static final String DEFAULT_I_43 = "AAAAAAAAAA";
    private static final String UPDATED_I_43 = "BBBBBBBBBB";

    private static final String DEFAULT_I_44 = "AAAAAAAAAA";
    private static final String UPDATED_I_44 = "BBBBBBBBBB";

    private static final String DEFAULT_I_45 = "AAAAAAAAAA";
    private static final String UPDATED_I_45 = "BBBBBBBBBB";

    private static final String DEFAULT_I_46 = "AAAAAAAAAA";
    private static final String UPDATED_I_46 = "BBBBBBBBBB";

    private static final String DEFAULT_I_47 = "AAAAAAAAAA";
    private static final String UPDATED_I_47 = "BBBBBBBBBB";

    private static final String DEFAULT_I_48 = "AAAAAAAAAA";
    private static final String UPDATED_I_48 = "BBBBBBBBBB";

    private static final String DEFAULT_I_49 = "AAAAAAAAAA";
    private static final String UPDATED_I_49 = "BBBBBBBBBB";

    private static final String DEFAULT_I_50 = "AAAAAAAAAA";
    private static final String UPDATED_I_50 = "BBBBBBBBBB";

    private static final String DEFAULT_I_51 = "AAAAAAAAAA";
    private static final String UPDATED_I_51 = "BBBBBBBBBB";

    private static final String DEFAULT_I_52 = "AAAAAAAAAA";
    private static final String UPDATED_I_52 = "BBBBBBBBBB";

    private static final String DEFAULT_I_53 = "AAAAAAAAAA";
    private static final String UPDATED_I_53 = "BBBBBBBBBB";

    private static final String DEFAULT_I_54 = "AAAAAAAAAA";
    private static final String UPDATED_I_54 = "BBBBBBBBBB";

    private static final String DEFAULT_I_55 = "AAAAAAAAAA";
    private static final String UPDATED_I_55 = "BBBBBBBBBB";

    private static final String DEFAULT_DOCTOR = "AAAAAAAAAA";
    private static final String UPDATED_DOCTOR = "BBBBBBBBBB";

    private static final String DEFAULT_R_56 = "AAAAAAAAAA";
    private static final String UPDATED_R_56 = "BBBBBBBBBB";

    private static final String DEFAULT_R_57 = "AAAAAAAAAA";
    private static final String UPDATED_R_57 = "BBBBBBBBBB";

    private static final String DEFAULT_R_58 = "AAAAAAAAAA";
    private static final String UPDATED_R_58 = "BBBBBBBBBB";

    private static final String DEFAULT_R_59 = "AAAAAAAAAA";
    private static final String UPDATED_R_59 = "BBBBBBBBBB";

    private static final String DEFAULT_R_60 = "AAAAAAAAAA";
    private static final String UPDATED_R_60 = "BBBBBBBBBB";

    private static final String DEFAULT_R_61 = "AAAAAAAAAA";
    private static final String UPDATED_R_61 = "BBBBBBBBBB";

    private static final String DEFAULT_R_62 = "AAAAAAAAAA";
    private static final String UPDATED_R_62 = "BBBBBBBBBB";

    private static final String DEFAULT_R_63 = "AAAAAAAAAA";
    private static final String UPDATED_R_63 = "BBBBBBBBBB";

    private static final String DEFAULT_R_64 = "AAAAAAAAAA";
    private static final String UPDATED_R_64 = "BBBBBBBBBB";

    private static final String DEFAULT_I_56 = "AAAAAAAAAA";
    private static final String UPDATED_I_56 = "BBBBBBBBBB";

    private static final String DEFAULT_I_57 = "AAAAAAAAAA";
    private static final String UPDATED_I_57 = "BBBBBBBBBB";

    private static final String DEFAULT_I_58 = "AAAAAAAAAA";
    private static final String UPDATED_I_58 = "BBBBBBBBBB";

    private static final String DEFAULT_I_59 = "AAAAAAAAAA";
    private static final String UPDATED_I_59 = "BBBBBBBBBB";

    private static final String DEFAULT_I_60 = "AAAAAAAAAA";
    private static final String UPDATED_I_60 = "BBBBBBBBBB";

    private static final String DEFAULT_I_61 = "AAAAAAAAAA";
    private static final String UPDATED_I_61 = "BBBBBBBBBB";

    private static final String DEFAULT_I_62 = "AAAAAAAAAA";
    private static final String UPDATED_I_62 = "BBBBBBBBBB";

    private static final String DEFAULT_I_63 = "AAAAAAAAAA";
    private static final String UPDATED_I_63 = "BBBBBBBBBB";

    private static final String DEFAULT_I_64 = "AAAAAAAAAA";
    private static final String UPDATED_I_64 = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_HORAINI = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HORAINI = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ULTIMOIDXOD = 1;
    private static final Integer UPDATED_ULTIMOIDXOD = 2;

    private static final Integer DEFAULT_ULTIMOIDXOI = 1;
    private static final Integer UPDATED_ULTIMOIDXOI = 2;

    private static final Integer DEFAULT_TIPOVISITA = 1;
    private static final Integer UPDATED_TIPOVISITA = 2;

    private static final Boolean DEFAULT_CAMPI = false;
    private static final Boolean UPDATED_CAMPI = true;

    private static final Boolean DEFAULT_TOPO = false;
    private static final Boolean UPDATED_TOPO = true;

    private static final Boolean DEFAULT_OCTP = false;
    private static final Boolean UPDATED_OCTP = true;

    private static final Boolean DEFAULT_OCTA = false;
    private static final Boolean UPDATED_OCTA = true;

    private static final Boolean DEFAULT_RETI = false;
    private static final Boolean UPDATED_RETI = true;

    private static final Boolean DEFAULT_ANGI = false;
    private static final Boolean UPDATED_ANGI = true;

    private static final Boolean DEFAULT_CONTA = false;
    private static final Boolean UPDATED_CONTA = true;

    private static final Boolean DEFAULT_BIO = false;
    private static final Boolean UPDATED_BIO = true;

    private static final Boolean DEFAULT_POLO = false;
    private static final Boolean UPDATED_POLO = true;

    private static final Boolean DEFAULT_PAQUI = false;
    private static final Boolean UPDATED_PAQUI = true;

    private static final Boolean DEFAULT_OTRA_1 = false;
    private static final Boolean UPDATED_OTRA_1 = true;

    private static final Boolean DEFAULT_OTRA_2 = false;
    private static final Boolean UPDATED_OTRA_2 = true;

    private static final Boolean DEFAULT_OTRA_3 = false;
    private static final Boolean UPDATED_OTRA_3 = true;

    private static final Boolean DEFAULT_OTRA_4 = false;
    private static final Boolean UPDATED_OTRA_4 = true;

    private static final String DEFAULT_NUHSA = "1";
    private static final String UPDATED_NUHSA = "2";

    private static final String DEFAULT_HOSP = "AAAAAAAAAA";
    private static final String UPDATED_HOSP = "BBBBBBBBBB";

    @Autowired
    private RetinaRepository retinaRepository;

    @Autowired
    private RetinaService retinaService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRetinaMockMvc;

    private Retina retina;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RetinaResource retinaResource = new RetinaResource(retinaService, null);
        this.restRetinaMockMvc = MockMvcBuilders.standaloneSetup(retinaResource)
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
    public static Retina createEntity(EntityManager em) {
        Retina retina = new Retina()
            .historial(DEFAULT_HISTORIAL)
            .nombre(DEFAULT_NOMBRE)
            .visita(DEFAULT_VISITA)
            .diagangio(DEFAULT_DIAGANGIO)
            .diagoft(DEFAULT_DIAGOFT)
            .fecha(DEFAULT_FECHA)
            .notas(DEFAULT_NOTAS)
            .r1(DEFAULT_R_1)
            .r2(DEFAULT_R_2)
            .r3(DEFAULT_R_3)
            .r4(DEFAULT_R_4)
            .r5(DEFAULT_R_5)
            .r6(DEFAULT_R_6)
            .r7(DEFAULT_R_7)
            .r8(DEFAULT_R_8)
            .r9(DEFAULT_R_9)
            .r10(DEFAULT_R_10)
            .r11(DEFAULT_R_11)
            .r12(DEFAULT_R_12)
            .r13(DEFAULT_R_13)
            .r14(DEFAULT_R_14)
            .r15(DEFAULT_R_15)
            .r16(DEFAULT_R_16)
            .r17(DEFAULT_R_17)
            .r18(DEFAULT_R_18)
            .r19(DEFAULT_R_19)
            .r20(DEFAULT_R_20)
            .r21(DEFAULT_R_21)
            .r22(DEFAULT_R_22)
            .r23(DEFAULT_R_23)
            .r24(DEFAULT_R_24)
            .r25(DEFAULT_R_25)
            .r26(DEFAULT_R_26)
            .r27(DEFAULT_R_27)
            .r28(DEFAULT_R_28)
            .r29(DEFAULT_R_29)
            .r30(DEFAULT_R_30)
            .r31(DEFAULT_R_31)
            .r32(DEFAULT_R_32)
            .r33(DEFAULT_R_33)
            .r34(DEFAULT_R_34)
            .r35(DEFAULT_R_35)
            .r36(DEFAULT_R_36)
            .r37(DEFAULT_R_37)
            .r38(DEFAULT_R_38)
            .r39(DEFAULT_R_39)
            .r40(DEFAULT_R_40)
            .r41(DEFAULT_R_41)
            .r42(DEFAULT_R_42)
            .r43(DEFAULT_R_43)
            .r44(DEFAULT_R_44)
            .r45(DEFAULT_R_45)
            .r46(DEFAULT_R_46)
            .r47(DEFAULT_R_47)
            .r48(DEFAULT_R_48)
            .r49(DEFAULT_R_49)
            .r50(DEFAULT_R_50)
            .r51(DEFAULT_R_51)
            .r52(DEFAULT_R_52)
            .r53(DEFAULT_R_53)
            .r54(DEFAULT_R_54)
            .r55(DEFAULT_R_55)
            .i1(DEFAULT_I_1)
            .i2(DEFAULT_I_2)
            .i3(DEFAULT_I_3)
            .i4(DEFAULT_I_4)
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
            .i17(DEFAULT_I_17)
            .i18(DEFAULT_I_18)
            .i19(DEFAULT_I_19)
            .i20(DEFAULT_I_20)
            .i21(DEFAULT_I_21)
            .i22(DEFAULT_I_22)
            .i23(DEFAULT_I_23)
            .i24(DEFAULT_I_24)
            .i25(DEFAULT_I_25)
            .i26(DEFAULT_I_26)
            .i27(DEFAULT_I_27)
            .i28(DEFAULT_I_28)
            .i29(DEFAULT_I_29)
            .i30(DEFAULT_I_30)
            .i31(DEFAULT_I_31)
            .i32(DEFAULT_I_32)
            .i33(DEFAULT_I_33)
            .i34(DEFAULT_I_34)
            .i35(DEFAULT_I_35)
            .i36(DEFAULT_I_36)
            .i37(DEFAULT_I_37)
            .i38(DEFAULT_I_38)
            .i39(DEFAULT_I_39)
            .i40(DEFAULT_I_40)
            .i41(DEFAULT_I_41)
            .i42(DEFAULT_I_42)
            .i43(DEFAULT_I_43)
            .i44(DEFAULT_I_44)
            .i45(DEFAULT_I_45)
            .i46(DEFAULT_I_46)
            .i47(DEFAULT_I_47)
            .i48(DEFAULT_I_48)
            .i49(DEFAULT_I_49)
            .i50(DEFAULT_I_50)
            .i51(DEFAULT_I_51)
            .i52(DEFAULT_I_52)
            .i53(DEFAULT_I_53)
            .i54(DEFAULT_I_54)
            .i55(DEFAULT_I_55)
            .doctor(DEFAULT_DOCTOR)
            .r56(DEFAULT_R_56)
            .r57(DEFAULT_R_57)
            .r58(DEFAULT_R_58)
            .r59(DEFAULT_R_59)
            .r60(DEFAULT_R_60)
            .r61(DEFAULT_R_61)
            .r62(DEFAULT_R_62)
            .r63(DEFAULT_R_63)
            .r64(DEFAULT_R_64)
            .i56(DEFAULT_I_56)
            .i57(DEFAULT_I_57)
            .i58(DEFAULT_I_58)
            .i59(DEFAULT_I_59)
            .i60(DEFAULT_I_60)
            .i61(DEFAULT_I_61)
            .i62(DEFAULT_I_62)
            .i63(DEFAULT_I_63)
            .i64(DEFAULT_I_64)
            .horaini(DEFAULT_HORAINI)
            .ultimoidxod(DEFAULT_ULTIMOIDXOD)
            .ultimoidxoi(DEFAULT_ULTIMOIDXOI)
            .tipovisita(DEFAULT_TIPOVISITA)
            .campi(DEFAULT_CAMPI)
            .topo(DEFAULT_TOPO)
            .octp(DEFAULT_OCTP)
            .octa(DEFAULT_OCTA)
            .reti(DEFAULT_RETI)
            .angi(DEFAULT_ANGI)
            .conta(DEFAULT_CONTA)
            .bio(DEFAULT_BIO)
            .polo(DEFAULT_POLO)
            .paqui(DEFAULT_PAQUI)
            .otra1(DEFAULT_OTRA_1)
            .otra2(DEFAULT_OTRA_2)
            .otra3(DEFAULT_OTRA_3)
            .otra4(DEFAULT_OTRA_4)
            .nuhsa(DEFAULT_NUHSA)
            .hosp(DEFAULT_HOSP);
        return retina;
    }

    @Before
    public void initTest() {
        retina = createEntity(em);
    }

    @Test
    @Transactional
    public void createRetina() throws Exception {
        int databaseSizeBeforeCreate = retinaRepository.findAll().size();

        // Create the Retina
        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isCreated());

        // Validate the Retina in the database
        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeCreate + 1);
        Retina testRetina = retinaList.get(retinaList.size() - 1);
        assertThat(testRetina.getHistorial()).isEqualTo(DEFAULT_HISTORIAL);
        assertThat(testRetina.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testRetina.getVisita()).isEqualTo(DEFAULT_VISITA);
        assertThat(testRetina.getDiagangio()).isEqualTo(DEFAULT_DIAGANGIO);
        assertThat(testRetina.getDiagoft()).isEqualTo(DEFAULT_DIAGOFT);
        assertThat(testRetina.getFecha()).isEqualTo(DEFAULT_FECHA);
        assertThat(testRetina.getNotas()).isEqualTo(DEFAULT_NOTAS);
        assertThat(testRetina.getr1()).isEqualTo(DEFAULT_R_1);
        assertThat(testRetina.getr2()).isEqualTo(DEFAULT_R_2);
        assertThat(testRetina.getr3()).isEqualTo(DEFAULT_R_3);
        assertThat(testRetina.getr4()).isEqualTo(DEFAULT_R_4);
        assertThat(testRetina.getr5()).isEqualTo(DEFAULT_R_5);
        assertThat(testRetina.getr6()).isEqualTo(DEFAULT_R_6);
        assertThat(testRetina.getr7()).isEqualTo(DEFAULT_R_7);
        assertThat(testRetina.getr8()).isEqualTo(DEFAULT_R_8);
        assertThat(testRetina.getr9()).isEqualTo(DEFAULT_R_9);
        assertThat(testRetina.getr10()).isEqualTo(DEFAULT_R_10);
        assertThat(testRetina.getr11()).isEqualTo(DEFAULT_R_11);
        assertThat(testRetina.getr12()).isEqualTo(DEFAULT_R_12);
        assertThat(testRetina.getr13()).isEqualTo(DEFAULT_R_13);
        assertThat(testRetina.getr14()).isEqualTo(DEFAULT_R_14);
        assertThat(testRetina.getr15()).isEqualTo(DEFAULT_R_15);
        assertThat(testRetina.getr16()).isEqualTo(DEFAULT_R_16);
        assertThat(testRetina.getr17()).isEqualTo(DEFAULT_R_17);
        assertThat(testRetina.getr18()).isEqualTo(DEFAULT_R_18);
        assertThat(testRetina.getr19()).isEqualTo(DEFAULT_R_19);
        assertThat(testRetina.getr20()).isEqualTo(DEFAULT_R_20);
        assertThat(testRetina.getr21()).isEqualTo(DEFAULT_R_21);
        assertThat(testRetina.getr22()).isEqualTo(DEFAULT_R_22);
        assertThat(testRetina.getr23()).isEqualTo(DEFAULT_R_23);
        assertThat(testRetina.getr24()).isEqualTo(DEFAULT_R_24);
        assertThat(testRetina.getr25()).isEqualTo(DEFAULT_R_25);
        assertThat(testRetina.getr26()).isEqualTo(DEFAULT_R_26);
        assertThat(testRetina.getr27()).isEqualTo(DEFAULT_R_27);
        assertThat(testRetina.getr28()).isEqualTo(DEFAULT_R_28);
        assertThat(testRetina.getr29()).isEqualTo(DEFAULT_R_29);
        assertThat(testRetina.getr30()).isEqualTo(DEFAULT_R_30);
        assertThat(testRetina.getr31()).isEqualTo(DEFAULT_R_31);
        assertThat(testRetina.getr32()).isEqualTo(DEFAULT_R_32);
        assertThat(testRetina.getr33()).isEqualTo(DEFAULT_R_33);
        assertThat(testRetina.getr34()).isEqualTo(DEFAULT_R_34);
        assertThat(testRetina.getr35()).isEqualTo(DEFAULT_R_35);
        assertThat(testRetina.getr36()).isEqualTo(DEFAULT_R_36);
        assertThat(testRetina.getr37()).isEqualTo(DEFAULT_R_37);
        assertThat(testRetina.getr38()).isEqualTo(DEFAULT_R_38);
        assertThat(testRetina.getr39()).isEqualTo(DEFAULT_R_39);
        assertThat(testRetina.getr40()).isEqualTo(DEFAULT_R_40);
        assertThat(testRetina.getr41()).isEqualTo(DEFAULT_R_41);
        assertThat(testRetina.getr42()).isEqualTo(DEFAULT_R_42);
        assertThat(testRetina.getr43()).isEqualTo(DEFAULT_R_43);
        assertThat(testRetina.getr44()).isEqualTo(DEFAULT_R_44);
        assertThat(testRetina.getr45()).isEqualTo(DEFAULT_R_45);
        assertThat(testRetina.getr46()).isEqualTo(DEFAULT_R_46);
        assertThat(testRetina.getr47()).isEqualTo(DEFAULT_R_47);
        assertThat(testRetina.getr48()).isEqualTo(DEFAULT_R_48);
        assertThat(testRetina.getr49()).isEqualTo(DEFAULT_R_49);
        assertThat(testRetina.getr50()).isEqualTo(DEFAULT_R_50);
        assertThat(testRetina.getr51()).isEqualTo(DEFAULT_R_51);
        assertThat(testRetina.getr52()).isEqualTo(DEFAULT_R_52);
        assertThat(testRetina.getr53()).isEqualTo(DEFAULT_R_53);
        assertThat(testRetina.getr54()).isEqualTo(DEFAULT_R_54);
        assertThat(testRetina.getr55()).isEqualTo(DEFAULT_R_55);
        assertThat(testRetina.geti1()).isEqualTo(DEFAULT_I_1);
        assertThat(testRetina.geti2()).isEqualTo(DEFAULT_I_2);
        assertThat(testRetina.geti3()).isEqualTo(DEFAULT_I_3);
        assertThat(testRetina.geti4()).isEqualTo(DEFAULT_I_4);
        assertThat(testRetina.geti5()).isEqualTo(DEFAULT_I_5);
        assertThat(testRetina.geti6()).isEqualTo(DEFAULT_I_6);
        assertThat(testRetina.geti7()).isEqualTo(DEFAULT_I_7);
        assertThat(testRetina.geti8()).isEqualTo(DEFAULT_I_8);
        assertThat(testRetina.geti9()).isEqualTo(DEFAULT_I_9);
        assertThat(testRetina.geti10()).isEqualTo(DEFAULT_I_10);
        assertThat(testRetina.geti11()).isEqualTo(DEFAULT_I_11);
        assertThat(testRetina.geti12()).isEqualTo(DEFAULT_I_12);
        assertThat(testRetina.geti13()).isEqualTo(DEFAULT_I_13);
        assertThat(testRetina.geti14()).isEqualTo(DEFAULT_I_14);
        assertThat(testRetina.geti15()).isEqualTo(DEFAULT_I_15);
        assertThat(testRetina.geti16()).isEqualTo(DEFAULT_I_16);
        assertThat(testRetina.geti17()).isEqualTo(DEFAULT_I_17);
        assertThat(testRetina.geti18()).isEqualTo(DEFAULT_I_18);
        assertThat(testRetina.geti19()).isEqualTo(DEFAULT_I_19);
        assertThat(testRetina.geti20()).isEqualTo(DEFAULT_I_20);
        assertThat(testRetina.geti21()).isEqualTo(DEFAULT_I_21);
        assertThat(testRetina.geti22()).isEqualTo(DEFAULT_I_22);
        assertThat(testRetina.geti23()).isEqualTo(DEFAULT_I_23);
        assertThat(testRetina.geti24()).isEqualTo(DEFAULT_I_24);
        assertThat(testRetina.geti25()).isEqualTo(DEFAULT_I_25);
        assertThat(testRetina.geti26()).isEqualTo(DEFAULT_I_26);
        assertThat(testRetina.geti27()).isEqualTo(DEFAULT_I_27);
        assertThat(testRetina.geti28()).isEqualTo(DEFAULT_I_28);
        assertThat(testRetina.geti29()).isEqualTo(DEFAULT_I_29);
        assertThat(testRetina.geti30()).isEqualTo(DEFAULT_I_30);
        assertThat(testRetina.geti31()).isEqualTo(DEFAULT_I_31);
        assertThat(testRetina.geti32()).isEqualTo(DEFAULT_I_32);
        assertThat(testRetina.geti33()).isEqualTo(DEFAULT_I_33);
        assertThat(testRetina.geti34()).isEqualTo(DEFAULT_I_34);
        assertThat(testRetina.geti35()).isEqualTo(DEFAULT_I_35);
        assertThat(testRetina.geti36()).isEqualTo(DEFAULT_I_36);
        assertThat(testRetina.geti37()).isEqualTo(DEFAULT_I_37);
        assertThat(testRetina.geti38()).isEqualTo(DEFAULT_I_38);
        assertThat(testRetina.geti39()).isEqualTo(DEFAULT_I_39);
        assertThat(testRetina.geti40()).isEqualTo(DEFAULT_I_40);
        assertThat(testRetina.geti41()).isEqualTo(DEFAULT_I_41);
        assertThat(testRetina.geti42()).isEqualTo(DEFAULT_I_42);
        assertThat(testRetina.geti43()).isEqualTo(DEFAULT_I_43);
        assertThat(testRetina.geti44()).isEqualTo(DEFAULT_I_44);
        assertThat(testRetina.geti45()).isEqualTo(DEFAULT_I_45);
        assertThat(testRetina.geti46()).isEqualTo(DEFAULT_I_46);
        assertThat(testRetina.geti47()).isEqualTo(DEFAULT_I_47);
        assertThat(testRetina.geti48()).isEqualTo(DEFAULT_I_48);
        assertThat(testRetina.geti49()).isEqualTo(DEFAULT_I_49);
        assertThat(testRetina.geti50()).isEqualTo(DEFAULT_I_50);
        assertThat(testRetina.geti51()).isEqualTo(DEFAULT_I_51);
        assertThat(testRetina.geti52()).isEqualTo(DEFAULT_I_52);
        assertThat(testRetina.geti53()).isEqualTo(DEFAULT_I_53);
        assertThat(testRetina.geti54()).isEqualTo(DEFAULT_I_54);
        assertThat(testRetina.geti55()).isEqualTo(DEFAULT_I_55);
        assertThat(testRetina.getDoctor()).isEqualTo(DEFAULT_DOCTOR);
        assertThat(testRetina.getr56()).isEqualTo(DEFAULT_R_56);
        assertThat(testRetina.getr57()).isEqualTo(DEFAULT_R_57);
        assertThat(testRetina.getr58()).isEqualTo(DEFAULT_R_58);
        assertThat(testRetina.getr59()).isEqualTo(DEFAULT_R_59);
        assertThat(testRetina.getr60()).isEqualTo(DEFAULT_R_60);
        assertThat(testRetina.getr61()).isEqualTo(DEFAULT_R_61);
        assertThat(testRetina.getr62()).isEqualTo(DEFAULT_R_62);
        assertThat(testRetina.getr63()).isEqualTo(DEFAULT_R_63);
        assertThat(testRetina.getr64()).isEqualTo(DEFAULT_R_64);
        assertThat(testRetina.geti56()).isEqualTo(DEFAULT_I_56);
        assertThat(testRetina.geti57()).isEqualTo(DEFAULT_I_57);
        assertThat(testRetina.geti58()).isEqualTo(DEFAULT_I_58);
        assertThat(testRetina.geti59()).isEqualTo(DEFAULT_I_59);
        assertThat(testRetina.geti60()).isEqualTo(DEFAULT_I_60);
        assertThat(testRetina.geti61()).isEqualTo(DEFAULT_I_61);
        assertThat(testRetina.geti62()).isEqualTo(DEFAULT_I_62);
        assertThat(testRetina.geti63()).isEqualTo(DEFAULT_I_63);
        assertThat(testRetina.geti64()).isEqualTo(DEFAULT_I_64);
        assertThat(testRetina.getHoraini()).isEqualTo(DEFAULT_HORAINI);
        assertThat(testRetina.getUltimoidxod()).isEqualTo(DEFAULT_ULTIMOIDXOD);
        assertThat(testRetina.getUltimoidxoi()).isEqualTo(DEFAULT_ULTIMOIDXOI);
        assertThat(testRetina.getTipovisita()).isEqualTo(DEFAULT_TIPOVISITA);
        assertThat(testRetina.isCampi()).isEqualTo(DEFAULT_CAMPI);
        assertThat(testRetina.isTopo()).isEqualTo(DEFAULT_TOPO);
        assertThat(testRetina.isOctp()).isEqualTo(DEFAULT_OCTP);
        assertThat(testRetina.isOcta()).isEqualTo(DEFAULT_OCTA);
        assertThat(testRetina.isReti()).isEqualTo(DEFAULT_RETI);
        assertThat(testRetina.isAngi()).isEqualTo(DEFAULT_ANGI);
        assertThat(testRetina.isConta()).isEqualTo(DEFAULT_CONTA);
        assertThat(testRetina.isBio()).isEqualTo(DEFAULT_BIO);
        assertThat(testRetina.isPolo()).isEqualTo(DEFAULT_POLO);
        assertThat(testRetina.isPaqui()).isEqualTo(DEFAULT_PAQUI);
        assertThat(testRetina.isOtra1()).isEqualTo(DEFAULT_OTRA_1);
        assertThat(testRetina.isOtra2()).isEqualTo(DEFAULT_OTRA_2);
        assertThat(testRetina.isOtra3()).isEqualTo(DEFAULT_OTRA_3);
        assertThat(testRetina.isOtra4()).isEqualTo(DEFAULT_OTRA_4);
        assertThat(testRetina.getNuhsa()).isEqualTo(DEFAULT_NUHSA);
        assertThat(testRetina.getHosp()).isEqualTo(DEFAULT_HOSP);
    }

    @Test
    @Transactional
    public void createRetinaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = retinaRepository.findAll().size();

        // Create the Retina with an existing ID
        retina.setHistorial(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        // Validate the Retina in the database
        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkTipovisitaIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setTipovisita(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCampiIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setCampi(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTopoIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setTopo(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOctpIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOctp(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOctaIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOcta(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRetiIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setReti(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAngiIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setAngi(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkContaIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setConta(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBioIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setBio(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPoloIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setPolo(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPaquiIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setPaqui(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOtra1IsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOtra1(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOtra2IsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOtra2(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOtra3IsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOtra3(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOtra4IsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setOtra4(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNuhsaIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setNuhsa(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkHospIsRequired() throws Exception {
        int databaseSizeBeforeTest = retinaRepository.findAll().size();
        // set the field null
        retina.setHosp(null);

        // Create the Retina, which fails.

        restRetinaMockMvc.perform(post("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isBadRequest());

        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllRetinas() throws Exception {
        // Initialize the database
        retinaRepository.saveAndFlush(retina);

        // Get all the retinaList
        restRetinaMockMvc.perform(get("/api/retinas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].historial").value(hasItem(DEFAULT_HISTORIAL)))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE.toString())))
            .andExpect(jsonPath("$.[*].visita").value(hasItem(DEFAULT_VISITA)))
            .andExpect(jsonPath("$.[*].diagangio").value(hasItem(DEFAULT_DIAGANGIO.toString())))
            .andExpect(jsonPath("$.[*].diagoft").value(hasItem(DEFAULT_DIAGOFT.toString())))
            .andExpect(jsonPath("$.[*].fecha").value(hasItem(DEFAULT_FECHA.toString())))
            .andExpect(jsonPath("$.[*].notas").value(hasItem(DEFAULT_NOTAS.toString())))
            .andExpect(jsonPath("$.[*].r1").value(hasItem(DEFAULT_R_1.toString())))
            .andExpect(jsonPath("$.[*].r2").value(hasItem(DEFAULT_R_2.toString())))
            .andExpect(jsonPath("$.[*].r3").value(hasItem(DEFAULT_R_3.toString())))
            .andExpect(jsonPath("$.[*].r4").value(hasItem(DEFAULT_R_4.toString())))
            .andExpect(jsonPath("$.[*].r5").value(hasItem(DEFAULT_R_5.toString())))
            .andExpect(jsonPath("$.[*].r6").value(hasItem(DEFAULT_R_6.toString())))
            .andExpect(jsonPath("$.[*].r7").value(hasItem(DEFAULT_R_7.toString())))
            .andExpect(jsonPath("$.[*].r8").value(hasItem(DEFAULT_R_8.toString())))
            .andExpect(jsonPath("$.[*].r9").value(hasItem(DEFAULT_R_9.toString())))
            .andExpect(jsonPath("$.[*].r10").value(hasItem(DEFAULT_R_10.toString())))
            .andExpect(jsonPath("$.[*].r11").value(hasItem(DEFAULT_R_11.toString())))
            .andExpect(jsonPath("$.[*].r12").value(hasItem(DEFAULT_R_12.toString())))
            .andExpect(jsonPath("$.[*].r13").value(hasItem(DEFAULT_R_13.toString())))
            .andExpect(jsonPath("$.[*].r14").value(hasItem(DEFAULT_R_14.toString())))
            .andExpect(jsonPath("$.[*].r15").value(hasItem(DEFAULT_R_15.toString())))
            .andExpect(jsonPath("$.[*].r16").value(hasItem(DEFAULT_R_16.toString())))
            .andExpect(jsonPath("$.[*].r17").value(hasItem(DEFAULT_R_17.toString())))
            .andExpect(jsonPath("$.[*].r18").value(hasItem(DEFAULT_R_18.toString())))
            .andExpect(jsonPath("$.[*].r19").value(hasItem(DEFAULT_R_19.toString())))
            .andExpect(jsonPath("$.[*].r20").value(hasItem(DEFAULT_R_20.toString())))
            .andExpect(jsonPath("$.[*].r21").value(hasItem(DEFAULT_R_21.toString())))
            .andExpect(jsonPath("$.[*].r22").value(hasItem(DEFAULT_R_22.toString())))
            .andExpect(jsonPath("$.[*].r23").value(hasItem(DEFAULT_R_23.toString())))
            .andExpect(jsonPath("$.[*].r24").value(hasItem(DEFAULT_R_24.toString())))
            .andExpect(jsonPath("$.[*].r25").value(hasItem(DEFAULT_R_25.toString())))
            .andExpect(jsonPath("$.[*].r26").value(hasItem(DEFAULT_R_26.toString())))
            .andExpect(jsonPath("$.[*].r27").value(hasItem(DEFAULT_R_27.toString())))
            .andExpect(jsonPath("$.[*].r28").value(hasItem(DEFAULT_R_28.toString())))
            .andExpect(jsonPath("$.[*].r29").value(hasItem(DEFAULT_R_29.toString())))
            .andExpect(jsonPath("$.[*].r30").value(hasItem(DEFAULT_R_30.toString())))
            .andExpect(jsonPath("$.[*].r31").value(hasItem(DEFAULT_R_31.toString())))
            .andExpect(jsonPath("$.[*].r32").value(hasItem(DEFAULT_R_32.toString())))
            .andExpect(jsonPath("$.[*].r33").value(hasItem(DEFAULT_R_33.toString())))
            .andExpect(jsonPath("$.[*].r34").value(hasItem(DEFAULT_R_34.toString())))
            .andExpect(jsonPath("$.[*].r35").value(hasItem(DEFAULT_R_35.toString())))
            .andExpect(jsonPath("$.[*].r36").value(hasItem(DEFAULT_R_36.toString())))
            .andExpect(jsonPath("$.[*].r37").value(hasItem(DEFAULT_R_37.toString())))
            .andExpect(jsonPath("$.[*].r38").value(hasItem(DEFAULT_R_38.toString())))
            .andExpect(jsonPath("$.[*].r39").value(hasItem(DEFAULT_R_39.toString())))
            .andExpect(jsonPath("$.[*].r40").value(hasItem(DEFAULT_R_40.toString())))
            .andExpect(jsonPath("$.[*].r41").value(hasItem(DEFAULT_R_41.toString())))
            .andExpect(jsonPath("$.[*].r42").value(hasItem(DEFAULT_R_42.toString())))
            .andExpect(jsonPath("$.[*].r43").value(hasItem(DEFAULT_R_43.toString())))
            .andExpect(jsonPath("$.[*].r44").value(hasItem(DEFAULT_R_44.toString())))
            .andExpect(jsonPath("$.[*].r45").value(hasItem(DEFAULT_R_45.toString())))
            .andExpect(jsonPath("$.[*].r46").value(hasItem(DEFAULT_R_46.toString())))
            .andExpect(jsonPath("$.[*].r47").value(hasItem(DEFAULT_R_47.toString())))
            .andExpect(jsonPath("$.[*].r48").value(hasItem(DEFAULT_R_48.toString())))
            .andExpect(jsonPath("$.[*].r49").value(hasItem(DEFAULT_R_49.toString())))
            .andExpect(jsonPath("$.[*].r50").value(hasItem(DEFAULT_R_50.toString())))
            .andExpect(jsonPath("$.[*].r51").value(hasItem(DEFAULT_R_51.toString())))
            .andExpect(jsonPath("$.[*].r52").value(hasItem(DEFAULT_R_52.toString())))
            .andExpect(jsonPath("$.[*].r53").value(hasItem(DEFAULT_R_53.toString())))
            .andExpect(jsonPath("$.[*].r54").value(hasItem(DEFAULT_R_54.toString())))
            .andExpect(jsonPath("$.[*].r55").value(hasItem(DEFAULT_R_55.toString())))
            .andExpect(jsonPath("$.[*].i1").value(hasItem(DEFAULT_I_1.toString())))
            .andExpect(jsonPath("$.[*].i2").value(hasItem(DEFAULT_I_2.toString())))
            .andExpect(jsonPath("$.[*].i3").value(hasItem(DEFAULT_I_3.toString())))
            .andExpect(jsonPath("$.[*].i4").value(hasItem(DEFAULT_I_4.toString())))
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
            .andExpect(jsonPath("$.[*].i17").value(hasItem(DEFAULT_I_17.toString())))
            .andExpect(jsonPath("$.[*].i18").value(hasItem(DEFAULT_I_18.toString())))
            .andExpect(jsonPath("$.[*].i19").value(hasItem(DEFAULT_I_19.toString())))
            .andExpect(jsonPath("$.[*].i20").value(hasItem(DEFAULT_I_20.toString())))
            .andExpect(jsonPath("$.[*].i21").value(hasItem(DEFAULT_I_21.toString())))
            .andExpect(jsonPath("$.[*].i22").value(hasItem(DEFAULT_I_22.toString())))
            .andExpect(jsonPath("$.[*].i23").value(hasItem(DEFAULT_I_23.toString())))
            .andExpect(jsonPath("$.[*].i24").value(hasItem(DEFAULT_I_24.toString())))
            .andExpect(jsonPath("$.[*].i25").value(hasItem(DEFAULT_I_25.toString())))
            .andExpect(jsonPath("$.[*].i26").value(hasItem(DEFAULT_I_26.toString())))
            .andExpect(jsonPath("$.[*].i27").value(hasItem(DEFAULT_I_27.toString())))
            .andExpect(jsonPath("$.[*].i28").value(hasItem(DEFAULT_I_28.toString())))
            .andExpect(jsonPath("$.[*].i29").value(hasItem(DEFAULT_I_29.toString())))
            .andExpect(jsonPath("$.[*].i30").value(hasItem(DEFAULT_I_30.toString())))
            .andExpect(jsonPath("$.[*].i31").value(hasItem(DEFAULT_I_31.toString())))
            .andExpect(jsonPath("$.[*].i32").value(hasItem(DEFAULT_I_32.toString())))
            .andExpect(jsonPath("$.[*].i33").value(hasItem(DEFAULT_I_33.toString())))
            .andExpect(jsonPath("$.[*].i34").value(hasItem(DEFAULT_I_34.toString())))
            .andExpect(jsonPath("$.[*].i35").value(hasItem(DEFAULT_I_35.toString())))
            .andExpect(jsonPath("$.[*].i36").value(hasItem(DEFAULT_I_36.toString())))
            .andExpect(jsonPath("$.[*].i37").value(hasItem(DEFAULT_I_37.toString())))
            .andExpect(jsonPath("$.[*].i38").value(hasItem(DEFAULT_I_38.toString())))
            .andExpect(jsonPath("$.[*].i39").value(hasItem(DEFAULT_I_39.toString())))
            .andExpect(jsonPath("$.[*].i40").value(hasItem(DEFAULT_I_40.toString())))
            .andExpect(jsonPath("$.[*].i41").value(hasItem(DEFAULT_I_41.toString())))
            .andExpect(jsonPath("$.[*].i42").value(hasItem(DEFAULT_I_42.toString())))
            .andExpect(jsonPath("$.[*].i43").value(hasItem(DEFAULT_I_43.toString())))
            .andExpect(jsonPath("$.[*].i44").value(hasItem(DEFAULT_I_44.toString())))
            .andExpect(jsonPath("$.[*].i45").value(hasItem(DEFAULT_I_45.toString())))
            .andExpect(jsonPath("$.[*].i46").value(hasItem(DEFAULT_I_46.toString())))
            .andExpect(jsonPath("$.[*].i47").value(hasItem(DEFAULT_I_47.toString())))
            .andExpect(jsonPath("$.[*].i48").value(hasItem(DEFAULT_I_48.toString())))
            .andExpect(jsonPath("$.[*].i49").value(hasItem(DEFAULT_I_49.toString())))
            .andExpect(jsonPath("$.[*].i50").value(hasItem(DEFAULT_I_50.toString())))
            .andExpect(jsonPath("$.[*].i51").value(hasItem(DEFAULT_I_51.toString())))
            .andExpect(jsonPath("$.[*].i52").value(hasItem(DEFAULT_I_52.toString())))
            .andExpect(jsonPath("$.[*].i53").value(hasItem(DEFAULT_I_53.toString())))
            .andExpect(jsonPath("$.[*].i54").value(hasItem(DEFAULT_I_54.toString())))
            .andExpect(jsonPath("$.[*].i55").value(hasItem(DEFAULT_I_55.toString())))
            .andExpect(jsonPath("$.[*].doctor").value(hasItem(DEFAULT_DOCTOR.toString())))
            .andExpect(jsonPath("$.[*].r56").value(hasItem(DEFAULT_R_56.toString())))
            .andExpect(jsonPath("$.[*].r57").value(hasItem(DEFAULT_R_57.toString())))
            .andExpect(jsonPath("$.[*].r58").value(hasItem(DEFAULT_R_58.toString())))
            .andExpect(jsonPath("$.[*].r59").value(hasItem(DEFAULT_R_59.toString())))
            .andExpect(jsonPath("$.[*].r60").value(hasItem(DEFAULT_R_60.toString())))
            .andExpect(jsonPath("$.[*].r61").value(hasItem(DEFAULT_R_61.toString())))
            .andExpect(jsonPath("$.[*].r62").value(hasItem(DEFAULT_R_62.toString())))
            .andExpect(jsonPath("$.[*].r63").value(hasItem(DEFAULT_R_63.toString())))
            .andExpect(jsonPath("$.[*].r64").value(hasItem(DEFAULT_R_64.toString())))
            .andExpect(jsonPath("$.[*].i56").value(hasItem(DEFAULT_I_56.toString())))
            .andExpect(jsonPath("$.[*].i57").value(hasItem(DEFAULT_I_57.toString())))
            .andExpect(jsonPath("$.[*].i58").value(hasItem(DEFAULT_I_58.toString())))
            .andExpect(jsonPath("$.[*].i59").value(hasItem(DEFAULT_I_59.toString())))
            .andExpect(jsonPath("$.[*].i60").value(hasItem(DEFAULT_I_60.toString())))
            .andExpect(jsonPath("$.[*].i61").value(hasItem(DEFAULT_I_61.toString())))
            .andExpect(jsonPath("$.[*].i62").value(hasItem(DEFAULT_I_62.toString())))
            .andExpect(jsonPath("$.[*].i63").value(hasItem(DEFAULT_I_63.toString())))
            .andExpect(jsonPath("$.[*].i64").value(hasItem(DEFAULT_I_64.toString())))
            .andExpect(jsonPath("$.[*].horaini").value(hasItem(DEFAULT_HORAINI.toString())))
            .andExpect(jsonPath("$.[*].ultimoidxod").value(hasItem(DEFAULT_ULTIMOIDXOD)))
            .andExpect(jsonPath("$.[*].ultimoidxoi").value(hasItem(DEFAULT_ULTIMOIDXOI)))
            .andExpect(jsonPath("$.[*].tipovisita").value(hasItem(DEFAULT_TIPOVISITA)))
            .andExpect(jsonPath("$.[*].campi").value(hasItem(DEFAULT_CAMPI.booleanValue())))
            .andExpect(jsonPath("$.[*].topo").value(hasItem(DEFAULT_TOPO.booleanValue())))
            .andExpect(jsonPath("$.[*].octp").value(hasItem(DEFAULT_OCTP.booleanValue())))
            .andExpect(jsonPath("$.[*].octa").value(hasItem(DEFAULT_OCTA.booleanValue())))
            .andExpect(jsonPath("$.[*].reti").value(hasItem(DEFAULT_RETI.booleanValue())))
            .andExpect(jsonPath("$.[*].angi").value(hasItem(DEFAULT_ANGI.booleanValue())))
            .andExpect(jsonPath("$.[*].conta").value(hasItem(DEFAULT_CONTA.booleanValue())))
            .andExpect(jsonPath("$.[*].bio").value(hasItem(DEFAULT_BIO.booleanValue())))
            .andExpect(jsonPath("$.[*].polo").value(hasItem(DEFAULT_POLO.booleanValue())))
            .andExpect(jsonPath("$.[*].paqui").value(hasItem(DEFAULT_PAQUI.booleanValue())))
            .andExpect(jsonPath("$.[*].otra1").value(hasItem(DEFAULT_OTRA_1.booleanValue())))
            .andExpect(jsonPath("$.[*].otra2").value(hasItem(DEFAULT_OTRA_2.booleanValue())))
            .andExpect(jsonPath("$.[*].otra3").value(hasItem(DEFAULT_OTRA_3.booleanValue())))
            .andExpect(jsonPath("$.[*].otra4").value(hasItem(DEFAULT_OTRA_4.booleanValue())))
            .andExpect(jsonPath("$.[*].nuhsa").value(hasItem(DEFAULT_NUHSA.toString())))
            .andExpect(jsonPath("$.[*].hosp").value(hasItem(DEFAULT_HOSP.toString())));
    }

    @Test
    @Transactional
    public void getRetina() throws Exception {
        // Initialize the database
        retinaRepository.saveAndFlush(retina);

        // Get the retina
        restRetinaMockMvc.perform(get("/api/retinas/{id}", retina.getHistorial()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.historial").value(DEFAULT_HISTORIAL))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE.toString()))
            .andExpect(jsonPath("$.visita").value(DEFAULT_VISITA))
            .andExpect(jsonPath("$.diagangio").value(DEFAULT_DIAGANGIO.toString()))
            .andExpect(jsonPath("$.diagoft").value(DEFAULT_DIAGOFT.toString()))
            .andExpect(jsonPath("$.fecha").value(DEFAULT_FECHA.toString()))
            .andExpect(jsonPath("$.notas").value(DEFAULT_NOTAS.toString()))
            .andExpect(jsonPath("$.r1").value(DEFAULT_R_1.toString()))
            .andExpect(jsonPath("$.r2").value(DEFAULT_R_2.toString()))
            .andExpect(jsonPath("$.r3").value(DEFAULT_R_3.toString()))
            .andExpect(jsonPath("$.r4").value(DEFAULT_R_4.toString()))
            .andExpect(jsonPath("$.r5").value(DEFAULT_R_5.toString()))
            .andExpect(jsonPath("$.r6").value(DEFAULT_R_6.toString()))
            .andExpect(jsonPath("$.r7").value(DEFAULT_R_7.toString()))
            .andExpect(jsonPath("$.r8").value(DEFAULT_R_8.toString()))
            .andExpect(jsonPath("$.r9").value(DEFAULT_R_9.toString()))
            .andExpect(jsonPath("$.r10").value(DEFAULT_R_10.toString()))
            .andExpect(jsonPath("$.r11").value(DEFAULT_R_11.toString()))
            .andExpect(jsonPath("$.r12").value(DEFAULT_R_12.toString()))
            .andExpect(jsonPath("$.r13").value(DEFAULT_R_13.toString()))
            .andExpect(jsonPath("$.r14").value(DEFAULT_R_14.toString()))
            .andExpect(jsonPath("$.r15").value(DEFAULT_R_15.toString()))
            .andExpect(jsonPath("$.r16").value(DEFAULT_R_16.toString()))
            .andExpect(jsonPath("$.r17").value(DEFAULT_R_17.toString()))
            .andExpect(jsonPath("$.r18").value(DEFAULT_R_18.toString()))
            .andExpect(jsonPath("$.r19").value(DEFAULT_R_19.toString()))
            .andExpect(jsonPath("$.r20").value(DEFAULT_R_20.toString()))
            .andExpect(jsonPath("$.r21").value(DEFAULT_R_21.toString()))
            .andExpect(jsonPath("$.r22").value(DEFAULT_R_22.toString()))
            .andExpect(jsonPath("$.r23").value(DEFAULT_R_23.toString()))
            .andExpect(jsonPath("$.r24").value(DEFAULT_R_24.toString()))
            .andExpect(jsonPath("$.r25").value(DEFAULT_R_25.toString()))
            .andExpect(jsonPath("$.r26").value(DEFAULT_R_26.toString()))
            .andExpect(jsonPath("$.r27").value(DEFAULT_R_27.toString()))
            .andExpect(jsonPath("$.r28").value(DEFAULT_R_28.toString()))
            .andExpect(jsonPath("$.r29").value(DEFAULT_R_29.toString()))
            .andExpect(jsonPath("$.r30").value(DEFAULT_R_30.toString()))
            .andExpect(jsonPath("$.r31").value(DEFAULT_R_31.toString()))
            .andExpect(jsonPath("$.r32").value(DEFAULT_R_32.toString()))
            .andExpect(jsonPath("$.r33").value(DEFAULT_R_33.toString()))
            .andExpect(jsonPath("$.r34").value(DEFAULT_R_34.toString()))
            .andExpect(jsonPath("$.r35").value(DEFAULT_R_35.toString()))
            .andExpect(jsonPath("$.r36").value(DEFAULT_R_36.toString()))
            .andExpect(jsonPath("$.r37").value(DEFAULT_R_37.toString()))
            .andExpect(jsonPath("$.r38").value(DEFAULT_R_38.toString()))
            .andExpect(jsonPath("$.r39").value(DEFAULT_R_39.toString()))
            .andExpect(jsonPath("$.r40").value(DEFAULT_R_40.toString()))
            .andExpect(jsonPath("$.r41").value(DEFAULT_R_41.toString()))
            .andExpect(jsonPath("$.r42").value(DEFAULT_R_42.toString()))
            .andExpect(jsonPath("$.r43").value(DEFAULT_R_43.toString()))
            .andExpect(jsonPath("$.r44").value(DEFAULT_R_44.toString()))
            .andExpect(jsonPath("$.r45").value(DEFAULT_R_45.toString()))
            .andExpect(jsonPath("$.r46").value(DEFAULT_R_46.toString()))
            .andExpect(jsonPath("$.r47").value(DEFAULT_R_47.toString()))
            .andExpect(jsonPath("$.r48").value(DEFAULT_R_48.toString()))
            .andExpect(jsonPath("$.r49").value(DEFAULT_R_49.toString()))
            .andExpect(jsonPath("$.r50").value(DEFAULT_R_50.toString()))
            .andExpect(jsonPath("$.r51").value(DEFAULT_R_51.toString()))
            .andExpect(jsonPath("$.r52").value(DEFAULT_R_52.toString()))
            .andExpect(jsonPath("$.r53").value(DEFAULT_R_53.toString()))
            .andExpect(jsonPath("$.r54").value(DEFAULT_R_54.toString()))
            .andExpect(jsonPath("$.r55").value(DEFAULT_R_55.toString()))
            .andExpect(jsonPath("$.i1").value(DEFAULT_I_1.toString()))
            .andExpect(jsonPath("$.i2").value(DEFAULT_I_2.toString()))
            .andExpect(jsonPath("$.i3").value(DEFAULT_I_3.toString()))
            .andExpect(jsonPath("$.i4").value(DEFAULT_I_4.toString()))
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
            .andExpect(jsonPath("$.i17").value(DEFAULT_I_17.toString()))
            .andExpect(jsonPath("$.i18").value(DEFAULT_I_18.toString()))
            .andExpect(jsonPath("$.i19").value(DEFAULT_I_19.toString()))
            .andExpect(jsonPath("$.i20").value(DEFAULT_I_20.toString()))
            .andExpect(jsonPath("$.i21").value(DEFAULT_I_21.toString()))
            .andExpect(jsonPath("$.i22").value(DEFAULT_I_22.toString()))
            .andExpect(jsonPath("$.i23").value(DEFAULT_I_23.toString()))
            .andExpect(jsonPath("$.i24").value(DEFAULT_I_24.toString()))
            .andExpect(jsonPath("$.i25").value(DEFAULT_I_25.toString()))
            .andExpect(jsonPath("$.i26").value(DEFAULT_I_26.toString()))
            .andExpect(jsonPath("$.i27").value(DEFAULT_I_27.toString()))
            .andExpect(jsonPath("$.i28").value(DEFAULT_I_28.toString()))
            .andExpect(jsonPath("$.i29").value(DEFAULT_I_29.toString()))
            .andExpect(jsonPath("$.i30").value(DEFAULT_I_30.toString()))
            .andExpect(jsonPath("$.i31").value(DEFAULT_I_31.toString()))
            .andExpect(jsonPath("$.i32").value(DEFAULT_I_32.toString()))
            .andExpect(jsonPath("$.i33").value(DEFAULT_I_33.toString()))
            .andExpect(jsonPath("$.i34").value(DEFAULT_I_34.toString()))
            .andExpect(jsonPath("$.i35").value(DEFAULT_I_35.toString()))
            .andExpect(jsonPath("$.i36").value(DEFAULT_I_36.toString()))
            .andExpect(jsonPath("$.i37").value(DEFAULT_I_37.toString()))
            .andExpect(jsonPath("$.i38").value(DEFAULT_I_38.toString()))
            .andExpect(jsonPath("$.i39").value(DEFAULT_I_39.toString()))
            .andExpect(jsonPath("$.i40").value(DEFAULT_I_40.toString()))
            .andExpect(jsonPath("$.i41").value(DEFAULT_I_41.toString()))
            .andExpect(jsonPath("$.i42").value(DEFAULT_I_42.toString()))
            .andExpect(jsonPath("$.i43").value(DEFAULT_I_43.toString()))
            .andExpect(jsonPath("$.i44").value(DEFAULT_I_44.toString()))
            .andExpect(jsonPath("$.i45").value(DEFAULT_I_45.toString()))
            .andExpect(jsonPath("$.i46").value(DEFAULT_I_46.toString()))
            .andExpect(jsonPath("$.i47").value(DEFAULT_I_47.toString()))
            .andExpect(jsonPath("$.i48").value(DEFAULT_I_48.toString()))
            .andExpect(jsonPath("$.i49").value(DEFAULT_I_49.toString()))
            .andExpect(jsonPath("$.i50").value(DEFAULT_I_50.toString()))
            .andExpect(jsonPath("$.i51").value(DEFAULT_I_51.toString()))
            .andExpect(jsonPath("$.i52").value(DEFAULT_I_52.toString()))
            .andExpect(jsonPath("$.i53").value(DEFAULT_I_53.toString()))
            .andExpect(jsonPath("$.i54").value(DEFAULT_I_54.toString()))
            .andExpect(jsonPath("$.i55").value(DEFAULT_I_55.toString()))
            .andExpect(jsonPath("$.doctor").value(DEFAULT_DOCTOR.toString()))
            .andExpect(jsonPath("$.r56").value(DEFAULT_R_56.toString()))
            .andExpect(jsonPath("$.r57").value(DEFAULT_R_57.toString()))
            .andExpect(jsonPath("$.r58").value(DEFAULT_R_58.toString()))
            .andExpect(jsonPath("$.r59").value(DEFAULT_R_59.toString()))
            .andExpect(jsonPath("$.r60").value(DEFAULT_R_60.toString()))
            .andExpect(jsonPath("$.r61").value(DEFAULT_R_61.toString()))
            .andExpect(jsonPath("$.r62").value(DEFAULT_R_62.toString()))
            .andExpect(jsonPath("$.r63").value(DEFAULT_R_63.toString()))
            .andExpect(jsonPath("$.r64").value(DEFAULT_R_64.toString()))
            .andExpect(jsonPath("$.i56").value(DEFAULT_I_56.toString()))
            .andExpect(jsonPath("$.i57").value(DEFAULT_I_57.toString()))
            .andExpect(jsonPath("$.i58").value(DEFAULT_I_58.toString()))
            .andExpect(jsonPath("$.i59").value(DEFAULT_I_59.toString()))
            .andExpect(jsonPath("$.i60").value(DEFAULT_I_60.toString()))
            .andExpect(jsonPath("$.i61").value(DEFAULT_I_61.toString()))
            .andExpect(jsonPath("$.i62").value(DEFAULT_I_62.toString()))
            .andExpect(jsonPath("$.i63").value(DEFAULT_I_63.toString()))
            .andExpect(jsonPath("$.i64").value(DEFAULT_I_64.toString()))
            .andExpect(jsonPath("$.horaini").value(DEFAULT_HORAINI.toString()))
            .andExpect(jsonPath("$.ultimoidxod").value(DEFAULT_ULTIMOIDXOD))
            .andExpect(jsonPath("$.ultimoidxoi").value(DEFAULT_ULTIMOIDXOI))
            .andExpect(jsonPath("$.tipovisita").value(DEFAULT_TIPOVISITA))
            .andExpect(jsonPath("$.campi").value(DEFAULT_CAMPI.booleanValue()))
            .andExpect(jsonPath("$.topo").value(DEFAULT_TOPO.booleanValue()))
            .andExpect(jsonPath("$.octp").value(DEFAULT_OCTP.booleanValue()))
            .andExpect(jsonPath("$.octa").value(DEFAULT_OCTA.booleanValue()))
            .andExpect(jsonPath("$.reti").value(DEFAULT_RETI.booleanValue()))
            .andExpect(jsonPath("$.angi").value(DEFAULT_ANGI.booleanValue()))
            .andExpect(jsonPath("$.conta").value(DEFAULT_CONTA.booleanValue()))
            .andExpect(jsonPath("$.bio").value(DEFAULT_BIO.booleanValue()))
            .andExpect(jsonPath("$.polo").value(DEFAULT_POLO.booleanValue()))
            .andExpect(jsonPath("$.paqui").value(DEFAULT_PAQUI.booleanValue()))
            .andExpect(jsonPath("$.otra1").value(DEFAULT_OTRA_1.booleanValue()))
            .andExpect(jsonPath("$.otra2").value(DEFAULT_OTRA_2.booleanValue()))
            .andExpect(jsonPath("$.otra3").value(DEFAULT_OTRA_3.booleanValue()))
            .andExpect(jsonPath("$.otra4").value(DEFAULT_OTRA_4.booleanValue()))
            .andExpect(jsonPath("$.nuhsa").value(DEFAULT_NUHSA.toString()))
            .andExpect(jsonPath("$.hosp").value(DEFAULT_HOSP.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRetina() throws Exception {
        // Get the retina
        restRetinaMockMvc.perform(get("/api/retinas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRetina() throws Exception {
        // Initialize the database
        retinaService.save(retina);

        int databaseSizeBeforeUpdate = retinaRepository.findAll().size();

        // Update the retina
        Retina updatedRetina = retinaRepository.findOne((int) (long)retina.getHistorial());
        updatedRetina
            .historial(UPDATED_HISTORIAL)
            .nombre(UPDATED_NOMBRE)
            .visita(UPDATED_VISITA)
            .diagangio(UPDATED_DIAGANGIO)
            .diagoft(UPDATED_DIAGOFT)
            .fecha(UPDATED_FECHA)
            .notas(UPDATED_NOTAS)
            .r1(UPDATED_R_1)
            .r2(UPDATED_R_2)
            .r3(UPDATED_R_3)
            .r4(UPDATED_R_4)
            .r5(UPDATED_R_5)
            .r6(UPDATED_R_6)
            .r7(UPDATED_R_7)
            .r8(UPDATED_R_8)
            .r9(UPDATED_R_9)
            .r10(UPDATED_R_10)
            .r11(UPDATED_R_11)
            .r12(UPDATED_R_12)
            .r13(UPDATED_R_13)
            .r14(UPDATED_R_14)
            .r15(UPDATED_R_15)
            .r16(UPDATED_R_16)
            .r17(UPDATED_R_17)
            .r18(UPDATED_R_18)
            .r19(UPDATED_R_19)
            .r20(UPDATED_R_20)
            .r21(UPDATED_R_21)
            .r22(UPDATED_R_22)
            .r23(UPDATED_R_23)
            .r24(UPDATED_R_24)
            .r25(UPDATED_R_25)
            .r26(UPDATED_R_26)
            .r27(UPDATED_R_27)
            .r28(UPDATED_R_28)
            .r29(UPDATED_R_29)
            .r30(UPDATED_R_30)
            .r31(UPDATED_R_31)
            .r32(UPDATED_R_32)
            .r33(UPDATED_R_33)
            .r34(UPDATED_R_34)
            .r35(UPDATED_R_35)
            .r36(UPDATED_R_36)
            .r37(UPDATED_R_37)
            .r38(UPDATED_R_38)
            .r39(UPDATED_R_39)
            .r40(UPDATED_R_40)
            .r41(UPDATED_R_41)
            .r42(UPDATED_R_42)
            .r43(UPDATED_R_43)
            .r44(UPDATED_R_44)
            .r45(UPDATED_R_45)
            .r46(UPDATED_R_46)
            .r47(UPDATED_R_47)
            .r48(UPDATED_R_48)
            .r49(UPDATED_R_49)
            .r50(UPDATED_R_50)
            .r51(UPDATED_R_51)
            .r52(UPDATED_R_52)
            .r53(UPDATED_R_53)
            .r54(UPDATED_R_54)
            .r55(UPDATED_R_55)
            .i1(UPDATED_I_1)
            .i2(UPDATED_I_2)
            .i3(UPDATED_I_3)
            .i4(UPDATED_I_4)
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
            .i17(UPDATED_I_17)
            .i18(UPDATED_I_18)
            .i19(UPDATED_I_19)
            .i20(UPDATED_I_20)
            .i21(UPDATED_I_21)
            .i22(UPDATED_I_22)
            .i23(UPDATED_I_23)
            .i24(UPDATED_I_24)
            .i25(UPDATED_I_25)
            .i26(UPDATED_I_26)
            .i27(UPDATED_I_27)
            .i28(UPDATED_I_28)
            .i29(UPDATED_I_29)
            .i30(UPDATED_I_30)
            .i31(UPDATED_I_31)
            .i32(UPDATED_I_32)
            .i33(UPDATED_I_33)
            .i34(UPDATED_I_34)
            .i35(UPDATED_I_35)
            .i36(UPDATED_I_36)
            .i37(UPDATED_I_37)
            .i38(UPDATED_I_38)
            .i39(UPDATED_I_39)
            .i40(UPDATED_I_40)
            .i41(UPDATED_I_41)
            .i42(UPDATED_I_42)
            .i43(UPDATED_I_43)
            .i44(UPDATED_I_44)
            .i45(UPDATED_I_45)
            .i46(UPDATED_I_46)
            .i47(UPDATED_I_47)
            .i48(UPDATED_I_48)
            .i49(UPDATED_I_49)
            .i50(UPDATED_I_50)
            .i51(UPDATED_I_51)
            .i52(UPDATED_I_52)
            .i53(UPDATED_I_53)
            .i54(UPDATED_I_54)
            .i55(UPDATED_I_55)
            .doctor(UPDATED_DOCTOR)
            .r56(UPDATED_R_56)
            .r57(UPDATED_R_57)
            .r58(UPDATED_R_58)
            .r59(UPDATED_R_59)
            .r60(UPDATED_R_60)
            .r61(UPDATED_R_61)
            .r62(UPDATED_R_62)
            .r63(UPDATED_R_63)
            .r64(UPDATED_R_64)
            .i56(UPDATED_I_56)
            .i57(UPDATED_I_57)
            .i58(UPDATED_I_58)
            .i59(UPDATED_I_59)
            .i60(UPDATED_I_60)
            .i61(UPDATED_I_61)
            .i62(UPDATED_I_62)
            .i63(UPDATED_I_63)
            .i64(UPDATED_I_64)
            .horaini(UPDATED_HORAINI)
            .ultimoidxod(UPDATED_ULTIMOIDXOD)
            .ultimoidxoi(UPDATED_ULTIMOIDXOI)
            .tipovisita(UPDATED_TIPOVISITA)
            .campi(UPDATED_CAMPI)
            .topo(UPDATED_TOPO)
            .octp(UPDATED_OCTP)
            .octa(UPDATED_OCTA)
            .reti(UPDATED_RETI)
            .angi(UPDATED_ANGI)
            .conta(UPDATED_CONTA)
            .bio(UPDATED_BIO)
            .polo(UPDATED_POLO)
            .paqui(UPDATED_PAQUI)
            .otra1(UPDATED_OTRA_1)
            .otra2(UPDATED_OTRA_2)
            .otra3(UPDATED_OTRA_3)
            .otra4(UPDATED_OTRA_4)
            .nuhsa(UPDATED_NUHSA)
            .hosp(UPDATED_HOSP);

        restRetinaMockMvc.perform(put("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRetina)))
            .andExpect(status().isOk());

        // Validate the Retina in the database
        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeUpdate);
        Retina testRetina = retinaList.get(retinaList.size() - 1);
        assertThat(testRetina.getHistorial()).isEqualTo(UPDATED_HISTORIAL);
        assertThat(testRetina.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testRetina.getVisita()).isEqualTo(UPDATED_VISITA);
        assertThat(testRetina.getDiagangio()).isEqualTo(UPDATED_DIAGANGIO);
        assertThat(testRetina.getDiagoft()).isEqualTo(UPDATED_DIAGOFT);
        assertThat(testRetina.getFecha()).isEqualTo(UPDATED_FECHA);
        assertThat(testRetina.getNotas()).isEqualTo(UPDATED_NOTAS);
        assertThat(testRetina.getr1()).isEqualTo(UPDATED_R_1);
        assertThat(testRetina.getr2()).isEqualTo(UPDATED_R_2);
        assertThat(testRetina.getr3()).isEqualTo(UPDATED_R_3);
        assertThat(testRetina.getr4()).isEqualTo(UPDATED_R_4);
        assertThat(testRetina.getr5()).isEqualTo(UPDATED_R_5);
        assertThat(testRetina.getr6()).isEqualTo(UPDATED_R_6);
        assertThat(testRetina.getr7()).isEqualTo(UPDATED_R_7);
        assertThat(testRetina.getr8()).isEqualTo(UPDATED_R_8);
        assertThat(testRetina.getr9()).isEqualTo(UPDATED_R_9);
        assertThat(testRetina.getr10()).isEqualTo(UPDATED_R_10);
        assertThat(testRetina.getr11()).isEqualTo(UPDATED_R_11);
        assertThat(testRetina.getr12()).isEqualTo(UPDATED_R_12);
        assertThat(testRetina.getr13()).isEqualTo(UPDATED_R_13);
        assertThat(testRetina.getr14()).isEqualTo(UPDATED_R_14);
        assertThat(testRetina.getr15()).isEqualTo(UPDATED_R_15);
        assertThat(testRetina.getr16()).isEqualTo(UPDATED_R_16);
        assertThat(testRetina.getr17()).isEqualTo(UPDATED_R_17);
        assertThat(testRetina.getr18()).isEqualTo(UPDATED_R_18);
        assertThat(testRetina.getr19()).isEqualTo(UPDATED_R_19);
        assertThat(testRetina.getr20()).isEqualTo(UPDATED_R_20);
        assertThat(testRetina.getr21()).isEqualTo(UPDATED_R_21);
        assertThat(testRetina.getr22()).isEqualTo(UPDATED_R_22);
        assertThat(testRetina.getr23()).isEqualTo(UPDATED_R_23);
        assertThat(testRetina.getr24()).isEqualTo(UPDATED_R_24);
        assertThat(testRetina.getr25()).isEqualTo(UPDATED_R_25);
        assertThat(testRetina.getr26()).isEqualTo(UPDATED_R_26);
        assertThat(testRetina.getr27()).isEqualTo(UPDATED_R_27);
        assertThat(testRetina.getr28()).isEqualTo(UPDATED_R_28);
        assertThat(testRetina.getr29()).isEqualTo(UPDATED_R_29);
        assertThat(testRetina.getr30()).isEqualTo(UPDATED_R_30);
        assertThat(testRetina.getr31()).isEqualTo(UPDATED_R_31);
        assertThat(testRetina.getr32()).isEqualTo(UPDATED_R_32);
        assertThat(testRetina.getr33()).isEqualTo(UPDATED_R_33);
        assertThat(testRetina.getr34()).isEqualTo(UPDATED_R_34);
        assertThat(testRetina.getr35()).isEqualTo(UPDATED_R_35);
        assertThat(testRetina.getr36()).isEqualTo(UPDATED_R_36);
        assertThat(testRetina.getr37()).isEqualTo(UPDATED_R_37);
        assertThat(testRetina.getr38()).isEqualTo(UPDATED_R_38);
        assertThat(testRetina.getr39()).isEqualTo(UPDATED_R_39);
        assertThat(testRetina.getr40()).isEqualTo(UPDATED_R_40);
        assertThat(testRetina.getr41()).isEqualTo(UPDATED_R_41);
        assertThat(testRetina.getr42()).isEqualTo(UPDATED_R_42);
        assertThat(testRetina.getr43()).isEqualTo(UPDATED_R_43);
        assertThat(testRetina.getr44()).isEqualTo(UPDATED_R_44);
        assertThat(testRetina.getr45()).isEqualTo(UPDATED_R_45);
        assertThat(testRetina.getr46()).isEqualTo(UPDATED_R_46);
        assertThat(testRetina.getr47()).isEqualTo(UPDATED_R_47);
        assertThat(testRetina.getr48()).isEqualTo(UPDATED_R_48);
        assertThat(testRetina.getr49()).isEqualTo(UPDATED_R_49);
        assertThat(testRetina.getr50()).isEqualTo(UPDATED_R_50);
        assertThat(testRetina.getr51()).isEqualTo(UPDATED_R_51);
        assertThat(testRetina.getr52()).isEqualTo(UPDATED_R_52);
        assertThat(testRetina.getr53()).isEqualTo(UPDATED_R_53);
        assertThat(testRetina.getr54()).isEqualTo(UPDATED_R_54);
        assertThat(testRetina.getr55()).isEqualTo(UPDATED_R_55);
        assertThat(testRetina.geti1()).isEqualTo(UPDATED_I_1);
        assertThat(testRetina.geti2()).isEqualTo(UPDATED_I_2);
        assertThat(testRetina.geti3()).isEqualTo(UPDATED_I_3);
        assertThat(testRetina.geti4()).isEqualTo(UPDATED_I_4);
        assertThat(testRetina.geti5()).isEqualTo(UPDATED_I_5);
        assertThat(testRetina.geti6()).isEqualTo(UPDATED_I_6);
        assertThat(testRetina.geti7()).isEqualTo(UPDATED_I_7);
        assertThat(testRetina.geti8()).isEqualTo(UPDATED_I_8);
        assertThat(testRetina.geti9()).isEqualTo(UPDATED_I_9);
        assertThat(testRetina.geti10()).isEqualTo(UPDATED_I_10);
        assertThat(testRetina.geti11()).isEqualTo(UPDATED_I_11);
        assertThat(testRetina.geti12()).isEqualTo(UPDATED_I_12);
        assertThat(testRetina.geti13()).isEqualTo(UPDATED_I_13);
        assertThat(testRetina.geti14()).isEqualTo(UPDATED_I_14);
        assertThat(testRetina.geti15()).isEqualTo(UPDATED_I_15);
        assertThat(testRetina.geti16()).isEqualTo(UPDATED_I_16);
        assertThat(testRetina.geti17()).isEqualTo(UPDATED_I_17);
        assertThat(testRetina.geti18()).isEqualTo(UPDATED_I_18);
        assertThat(testRetina.geti19()).isEqualTo(UPDATED_I_19);
        assertThat(testRetina.geti20()).isEqualTo(UPDATED_I_20);
        assertThat(testRetina.geti21()).isEqualTo(UPDATED_I_21);
        assertThat(testRetina.geti22()).isEqualTo(UPDATED_I_22);
        assertThat(testRetina.geti23()).isEqualTo(UPDATED_I_23);
        assertThat(testRetina.geti24()).isEqualTo(UPDATED_I_24);
        assertThat(testRetina.geti25()).isEqualTo(UPDATED_I_25);
        assertThat(testRetina.geti26()).isEqualTo(UPDATED_I_26);
        assertThat(testRetina.geti27()).isEqualTo(UPDATED_I_27);
        assertThat(testRetina.geti28()).isEqualTo(UPDATED_I_28);
        assertThat(testRetina.geti29()).isEqualTo(UPDATED_I_29);
        assertThat(testRetina.geti30()).isEqualTo(UPDATED_I_30);
        assertThat(testRetina.geti31()).isEqualTo(UPDATED_I_31);
        assertThat(testRetina.geti32()).isEqualTo(UPDATED_I_32);
        assertThat(testRetina.geti33()).isEqualTo(UPDATED_I_33);
        assertThat(testRetina.geti34()).isEqualTo(UPDATED_I_34);
        assertThat(testRetina.geti35()).isEqualTo(UPDATED_I_35);
        assertThat(testRetina.geti36()).isEqualTo(UPDATED_I_36);
        assertThat(testRetina.geti37()).isEqualTo(UPDATED_I_37);
        assertThat(testRetina.geti38()).isEqualTo(UPDATED_I_38);
        assertThat(testRetina.geti39()).isEqualTo(UPDATED_I_39);
        assertThat(testRetina.geti40()).isEqualTo(UPDATED_I_40);
        assertThat(testRetina.geti41()).isEqualTo(UPDATED_I_41);
        assertThat(testRetina.geti42()).isEqualTo(UPDATED_I_42);
        assertThat(testRetina.geti43()).isEqualTo(UPDATED_I_43);
        assertThat(testRetina.geti44()).isEqualTo(UPDATED_I_44);
        assertThat(testRetina.geti45()).isEqualTo(UPDATED_I_45);
        assertThat(testRetina.geti46()).isEqualTo(UPDATED_I_46);
        assertThat(testRetina.geti47()).isEqualTo(UPDATED_I_47);
        assertThat(testRetina.geti48()).isEqualTo(UPDATED_I_48);
        assertThat(testRetina.geti49()).isEqualTo(UPDATED_I_49);
        assertThat(testRetina.geti50()).isEqualTo(UPDATED_I_50);
        assertThat(testRetina.geti51()).isEqualTo(UPDATED_I_51);
        assertThat(testRetina.geti52()).isEqualTo(UPDATED_I_52);
        assertThat(testRetina.geti53()).isEqualTo(UPDATED_I_53);
        assertThat(testRetina.geti54()).isEqualTo(UPDATED_I_54);
        assertThat(testRetina.geti55()).isEqualTo(UPDATED_I_55);
        assertThat(testRetina.getDoctor()).isEqualTo(UPDATED_DOCTOR);
        assertThat(testRetina.getr56()).isEqualTo(UPDATED_R_56);
        assertThat(testRetina.getr57()).isEqualTo(UPDATED_R_57);
        assertThat(testRetina.getr58()).isEqualTo(UPDATED_R_58);
        assertThat(testRetina.getr59()).isEqualTo(UPDATED_R_59);
        assertThat(testRetina.getr60()).isEqualTo(UPDATED_R_60);
        assertThat(testRetina.getr61()).isEqualTo(UPDATED_R_61);
        assertThat(testRetina.getr62()).isEqualTo(UPDATED_R_62);
        assertThat(testRetina.getr63()).isEqualTo(UPDATED_R_63);
        assertThat(testRetina.getr64()).isEqualTo(UPDATED_R_64);
        assertThat(testRetina.geti56()).isEqualTo(UPDATED_I_56);
        assertThat(testRetina.geti57()).isEqualTo(UPDATED_I_57);
        assertThat(testRetina.geti58()).isEqualTo(UPDATED_I_58);
        assertThat(testRetina.geti59()).isEqualTo(UPDATED_I_59);
        assertThat(testRetina.geti60()).isEqualTo(UPDATED_I_60);
        assertThat(testRetina.geti61()).isEqualTo(UPDATED_I_61);
        assertThat(testRetina.geti62()).isEqualTo(UPDATED_I_62);
        assertThat(testRetina.geti63()).isEqualTo(UPDATED_I_63);
        assertThat(testRetina.geti64()).isEqualTo(UPDATED_I_64);
        assertThat(testRetina.getHoraini()).isEqualTo(UPDATED_HORAINI);
        assertThat(testRetina.getUltimoidxod()).isEqualTo(UPDATED_ULTIMOIDXOD);
        assertThat(testRetina.getUltimoidxoi()).isEqualTo(UPDATED_ULTIMOIDXOI);
        assertThat(testRetina.getTipovisita()).isEqualTo(UPDATED_TIPOVISITA);
        assertThat(testRetina.isCampi()).isEqualTo(UPDATED_CAMPI);
        assertThat(testRetina.isTopo()).isEqualTo(UPDATED_TOPO);
        assertThat(testRetina.isOctp()).isEqualTo(UPDATED_OCTP);
        assertThat(testRetina.isOcta()).isEqualTo(UPDATED_OCTA);
        assertThat(testRetina.isReti()).isEqualTo(UPDATED_RETI);
        assertThat(testRetina.isAngi()).isEqualTo(UPDATED_ANGI);
        assertThat(testRetina.isConta()).isEqualTo(UPDATED_CONTA);
        assertThat(testRetina.isBio()).isEqualTo(UPDATED_BIO);
        assertThat(testRetina.isPolo()).isEqualTo(UPDATED_POLO);
        assertThat(testRetina.isPaqui()).isEqualTo(UPDATED_PAQUI);
        assertThat(testRetina.isOtra1()).isEqualTo(UPDATED_OTRA_1);
        assertThat(testRetina.isOtra2()).isEqualTo(UPDATED_OTRA_2);
        assertThat(testRetina.isOtra3()).isEqualTo(UPDATED_OTRA_3);
        assertThat(testRetina.isOtra4()).isEqualTo(UPDATED_OTRA_4);
        assertThat(testRetina.getNuhsa()).isEqualTo(UPDATED_NUHSA);
        assertThat(testRetina.getHosp()).isEqualTo(UPDATED_HOSP);
    }

    @Test
    @Transactional
    public void updateNonExistingRetina() throws Exception {
        int databaseSizeBeforeUpdate = retinaRepository.findAll().size();

        // Create the Retina

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRetinaMockMvc.perform(put("/api/retinas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(retina)))
            .andExpect(status().isCreated());

        // Validate the Retina in the database
        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRetina() throws Exception {
        // Initialize the database
        retinaService.save(retina);

        int databaseSizeBeforeDelete = retinaRepository.findAll().size();

        // Get the retina
        restRetinaMockMvc.perform(delete("/api/retinas/{id}", retina.getHistorial())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Retina> retinaList = retinaRepository.findAll();
        assertThat(retinaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Retina.class);
        Retina retina1 = new Retina();
        retina1.setHistorial(1L);
        Retina retina2 = new Retina();
        retina2.setHistorial(retina1.getHistorial());
        assertThat(retina1).isEqualTo(retina2);
        retina2.setHistorial(2L);
        assertThat(retina1).isNotEqualTo(retina2);
        retina1.setHistorial(null);
        assertThat(retina1).isNotEqualTo(retina2);
    }
}
