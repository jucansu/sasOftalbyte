package es.surmedid.angiobyte.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Retina.
 */
@Entity
@Table(name = "retina")
public class Retina implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")    
    @EmbeddedId
    private RetinaEmbedded id;

    @Column(name = "Historial")
    private Integer historial;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Visita", insertable = false, updatable = false)
    private Integer visita;

    @Column(name = "Diagangio")
    private String diagangio;

    @Column(name = "Diagoft")
    private String diagoft;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @Column(name = "Notas")
    private String notas;

    @Column(name = "R1")
    private String r1;

    @Column(name = "R2")
    private String r2;

    @Column(name = "R3")
    private String r3;

    @Column(name = "R4")
    private String r4;

    @Column(name = "R5")
    private String r5;

    @Column(name = "R6")
    private String r6;

    @Column(name = "R7")
    private String r7;

    @Column(name = "R8")
    private String r8;

    @Column(name = "R9")
    private String r9;

    @Column(name = "R10")
    private String r10;

    @Column(name = "R11")
    private String r11;

    @Column(name = "R12")
    private String r12;

    @Column(name = "R13")
    private String r13;

    @Column(name = "R14")
    private String r14;

    @Column(name = "R15")
    private String r15;

    @Column(name = "R16")
    private String r16;

    @Column(name = "R17")
    private String r17;

    @Column(name = "R18")
    private String r18;

    @Column(name = "R19")
    private String r19;

    @Column(name = "R20")
    private String r20;

    @Column(name = "R21")
    private String r21;

    @Column(name = "R22")
    private String r22;

    @Column(name = "R23")
    private String r23;

    @Column(name = "R24")
    private String r24;

    @Column(name = "R25")
    private String r25;

    @Column(name = "R26")
    private String r26;

    @Column(name = "R27")
    private String r27;

    @Column(name = "R28")
    private String r28;

    @Column(name = "R29")
    private String r29;

    @Column(name = "R30")
    private String r30;

    @Column(name = "R31")
    private String r31;

    @Column(name = "R32")
    private String r32;

    @Column(name = "R33")
    private String r33;

    @Column(name = "R34")
    private String r34;

    @Column(name = "R35")
    private String r35;

    @Column(name = "R36")
    private String r36;

    @Column(name = "R37")
    private String r37;

    @Column(name = "R38")
    private String r38;

    @Column(name = "R39")
    private String r39;

    @Column(name = "R40")
    private String r40;

    @Column(name = "R41")
    private String r41;

    @Column(name = "R42")
    private String r42;

    @Column(name = "R43")
    private String r43;

    @Column(name = "R44")
    private String r44;

    @Column(name = "R45")
    private String r45;

    @Column(name = "R46")
    private String r46;

    @Column(name = "R47")
    private String r47;

    @Column(name = "R48")
    private String r48;

    @Column(name = "R49")
    private String r49;

    @Column(name = "R50")
    private String r50;

    @Column(name = "R51")
    private String r51;

    @Column(name = "R52")
    private String r52;

    @Column(name = "R53")
    private String r53;

    @Column(name = "R54")
    private String r54;

    @Column(name = "R55")
    private String r55;

    @Column(name = "I1")
    private String i1;

    @Column(name = "I2")
    private String i2;

    @Column(name = "I3")
    private String i3;

    @Column(name = "I4")
    private String i4;

    @Column(name = "I5")
    private String i5;

    @Column(name = "I6")
    private String i6;

    @Column(name = "I7")
    private String i7;

    @Column(name = "I8")
    private String i8;

    @Column(name = "I9")
    private String i9;

    @Column(name = "I10")
    private String i10;

    @Column(name = "I11")
    private String i11;

    @Column(name = "I12")
    private String i12;

    @Column(name = "I13")
    private String i13;

    @Column(name = "I14")
    private String i14;

    @Column(name = "I15")
    private String i15;

    @Column(name = "I16")
    private String i16;

    @Column(name = "I17")
    private String i17;

    @Column(name = "I18")
    private String i18;

    @Column(name = "I19")
    private String i19;

    @Column(name = "I20")
    private String i20;

    @Column(name = "I21")
    private String i21;

    @Column(name = "I22")
    private String i22;

    @Column(name = "I23")
    private String i23;

    @Column(name = "I24")
    private String i24;

    @Column(name = "I25")
    private String i25;

    @Column(name = "I26")
    private String i26;

    @Column(name = "I27")
    private String i27;

    @Column(name = "I28")
    private String i28;

    @Column(name = "I29")
    private String i29;

    @Column(name = "I30")
    private String i30;

    @Column(name = "I31")
    private String i31;

    @Column(name = "I32")
    private String i32;

    @Column(name = "I33")
    private String i33;

    @Column(name = "I34")
    private String i34;

    @Column(name = "I35")
    private String i35;

    @Column(name = "I36")
    private String i36;

    @Column(name = "I37")
    private String i37;

    @Column(name = "I38")
    private String i38;

    @Column(name = "I39")
    private String i39;

    @Column(name = "I40")
    private String i40;

    @Column(name = "I41")
    private String i41;

    @Column(name = "I42")
    private String i42;

    @Column(name = "I43")
    private String i43;

    @Column(name = "I44")
    private String i44;

    @Column(name = "I45")
    private String i45;

    @Column(name = "I46")
    private String i46;

    @Column(name = "I47")
    private String i47;

    @Column(name = "I48")
    private String i48;

    @Column(name = "I49")
    private String i49;

    @Column(name = "I50")
    private String i50;

    @Column(name = "I51")
    private String i51;

    @Column(name = "I52")
    private String i52;

    @Column(name = "I53")
    private String i53;

    @Column(name = "I54")
    private String i54;

    @Column(name = "I55")
    private String i55;

    @Size(max = 80)
    @Column(name = "Doctor", length = 80)
    private String doctor;

    @Column(name = "R56")
    private String r56;

    @Column(name = "R57")
    private String r57;

    @Column(name = "R58")
    private String r58;

    @Column(name = "R59")
    private String r59;

    @Column(name = "R60")
    private String r60;

    @Column(name = "R61")
    private String r61;

    @Column(name = "R62")
    private String r62;

    @Column(name = "R63")
    private String r63;

    @Column(name = "R64")
    private String r64;

    @Column(name = "I56")
    private String i56;

    @Column(name = "I57")
    private String i57;

    @Column(name = "I58")
    private String i58;

    @Column(name = "I59")
    private String i59;

    @Column(name = "I60")
    private String i60;

    @Column(name = "I61")
    private String i61;

    @Column(name = "I62")
    private String i62;

    @Column(name = "I63")
    private String i63;

    @Column(name = "I64")
    private String i64;

    @Column(name = "Horaini")
    private LocalDate horaini;

    @Column(name = "Ultimoidxod")
    private Integer ultimoidxod;

    @Column(name = "Ultimoidxoi")
    private Integer ultimoidxoi;

    @NotNull
    @Column(name = "Tipovisita", nullable = false)
    private Integer tipovisita;

    @NotNull
    @Column(name = "Campi", nullable = false)
    private Boolean campi;

    @NotNull
    @Column(name = "Topo", nullable = false)
    private Boolean topo;

    @NotNull
    @Column(name = "Octp", nullable = false)
    private Boolean octp;

    @NotNull
    @Column(name = "Octa", nullable = false)
    private Boolean octa;

    @NotNull
    @Column(name = "Reti", nullable = false)
    private Boolean reti;

    @NotNull
    @Column(name = "Angi", nullable = false)
    private Boolean angi;

    @NotNull
    @Column(name = "Conta", nullable = false)
    private Boolean conta;

    @NotNull
    @Column(name = "Bio", nullable = false)
    private Boolean bio;

    @NotNull
    @Column(name = "Polo", nullable = false)
    private Boolean polo;

    @NotNull
    @Column(name = "Paqui", nullable = false)
    private Boolean paqui;

    @NotNull
    @Column(name = "Otra1", nullable = false)
    private Boolean otra1;

    @NotNull
    @Column(name = "Otra2", nullable = false)
    private Boolean otra2;

    @NotNull
    @Column(name = "Otra3", nullable = false)
    private Boolean otra3;

    @NotNull
    @Column(name = "Otra4", nullable = false)
    private Boolean otra4;

    @NotNull
    @Column(name = "Nuhsa", insertable = false, updatable = false)
    private Integer nuhsa;

    @NotNull
    @Size(max = 50)
    @Column(name = "Hosp", length = 50, nullable = false)
    private String hosp;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove

    public Integer getHistorial() {
        return historial;
    }

    public Retina historial(Integer historial) {
        this.historial = historial;
        return this;
    }

    public void setHistorial(Integer historial) {
        this.historial = historial;
    }

    public String getNombre() {
        return nombre;
    }

    public Retina nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVisita() {
        return visita;
    }

    public Retina visita(Integer visita) {
        this.visita = visita;
        return this;
    }

    public void setVisita(Integer visita) {
        this.visita = visita;
    }

    public String getDiagangio() {
        return diagangio;
    }

    public Retina diagangio(String diagangio) {
        this.diagangio = diagangio;
        return this;
    }

    public void setDiagangio(String diagangio) {
        this.diagangio = diagangio;
    }

    public String getDiagoft() {
        return diagoft;
    }

    public Retina diagoft(String diagoft) {
        this.diagoft = diagoft;
        return this;
    }

    public void setDiagoft(String diagoft) {
        this.diagoft = diagoft;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Retina fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNotas() {
        return notas;
    }

    public Retina notas(String notas) {
        this.notas = notas;
        return this;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getr1() {
        return r1;
    }

    public Retina r1(String r1) {
        this.r1 = r1;
        return this;
    }

    public void setr1(String r1) {
        this.r1 = r1;
    }

    public String getr2() {
        return r2;
    }

    public Retina r2(String r2) {
        this.r2 = r2;
        return this;
    }

    public void setr2(String r2) {
        this.r2 = r2;
    }

    public String getr3() {
        return r3;
    }

    public Retina r3(String r3) {
        this.r3 = r3;
        return this;
    }

    public void setr3(String r3) {
        this.r3 = r3;
    }

    public String getr4() {
        return r4;
    }

    public Retina r4(String r4) {
        this.r4 = r4;
        return this;
    }

    public void setr4(String r4) {
        this.r4 = r4;
    }

    public String getr5() {
        return r5;
    }

    public Retina r5(String r5) {
        this.r5 = r5;
        return this;
    }

    public void setr5(String r5) {
        this.r5 = r5;
    }

    public String getr6() {
        return r6;
    }

    public Retina r6(String r6) {
        this.r6 = r6;
        return this;
    }

    public void setr6(String r6) {
        this.r6 = r6;
    }

    public String getr7() {
        return r7;
    }

    public Retina r7(String r7) {
        this.r7 = r7;
        return this;
    }

    public void setr7(String r7) {
        this.r7 = r7;
    }

    public String getr8() {
        return r8;
    }

    public Retina r8(String r8) {
        this.r8 = r8;
        return this;
    }

    public void setr8(String r8) {
        this.r8 = r8;
    }

    public String getr9() {
        return r9;
    }

    public Retina r9(String r9) {
        this.r9 = r9;
        return this;
    }

    public void setr9(String r9) {
        this.r9 = r9;
    }

    public String getr10() {
        return r10;
    }

    public Retina r10(String r10) {
        this.r10 = r10;
        return this;
    }

    public void setr10(String r10) {
        this.r10 = r10;
    }

    public String getr11() {
        return r11;
    }

    public Retina r11(String r11) {
        this.r11 = r11;
        return this;
    }

    public void setr11(String r11) {
        this.r11 = r11;
    }

    public String getr12() {
        return r12;
    }

    public Retina r12(String r12) {
        this.r12 = r12;
        return this;
    }

    public void setr12(String r12) {
        this.r12 = r12;
    }

    public String getr13() {
        return r13;
    }

    public Retina r13(String r13) {
        this.r13 = r13;
        return this;
    }

    public void setr13(String r13) {
        this.r13 = r13;
    }

    public String getr14() {
        return r14;
    }

    public Retina r14(String r14) {
        this.r14 = r14;
        return this;
    }

    public void setr14(String r14) {
        this.r14 = r14;
    }

    public String getr15() {
        return r15;
    }

    public Retina r15(String r15) {
        this.r15 = r15;
        return this;
    }

    public void setr15(String r15) {
        this.r15 = r15;
    }

    public String getr16() {
        return r16;
    }

    public Retina r16(String r16) {
        this.r16 = r16;
        return this;
    }

    public void setr16(String r16) {
        this.r16 = r16;
    }

    public String getr17() {
        return r17;
    }

    public Retina r17(String r17) {
        this.r17 = r17;
        return this;
    }

    public void setr17(String r17) {
        this.r17 = r17;
    }

    public String getr18() {
        return r18;
    }

    public Retina r18(String r18) {
        this.r18 = r18;
        return this;
    }

    public void setr18(String r18) {
        this.r18 = r18;
    }

    public String getr19() {
        return r19;
    }

    public Retina r19(String r19) {
        this.r19 = r19;
        return this;
    }

    public void setr19(String r19) {
        this.r19 = r19;
    }

    public String getr20() {
        return r20;
    }

    public Retina r20(String r20) {
        this.r20 = r20;
        return this;
    }

    public void setr20(String r20) {
        this.r20 = r20;
    }

    public String getr21() {
        return r21;
    }

    public Retina r21(String r21) {
        this.r21 = r21;
        return this;
    }

    public void setr21(String r21) {
        this.r21 = r21;
    }

    public String getr22() {
        return r22;
    }

    public Retina r22(String r22) {
        this.r22 = r22;
        return this;
    }

    public void setr22(String r22) {
        this.r22 = r22;
    }

    public String getr23() {
        return r23;
    }

    public Retina r23(String r23) {
        this.r23 = r23;
        return this;
    }

    public void setr23(String r23) {
        this.r23 = r23;
    }

    public String getr24() {
        return r24;
    }

    public Retina r24(String r24) {
        this.r24 = r24;
        return this;
    }

    public void setr24(String r24) {
        this.r24 = r24;
    }

    public String getr25() {
        return r25;
    }

    public Retina r25(String r25) {
        this.r25 = r25;
        return this;
    }

    public void setr25(String r25) {
        this.r25 = r25;
    }

    public String getr26() {
        return r26;
    }

    public Retina r26(String r26) {
        this.r26 = r26;
        return this;
    }

    public void setr26(String r26) {
        this.r26 = r26;
    }

    public String getr27() {
        return r27;
    }

    public Retina r27(String r27) {
        this.r27 = r27;
        return this;
    }

    public void setr27(String r27) {
        this.r27 = r27;
    }

    public String getr28() {
        return r28;
    }

    public Retina r28(String r28) {
        this.r28 = r28;
        return this;
    }

    public void setr28(String r28) {
        this.r28 = r28;
    }

    public String getr29() {
        return r29;
    }

    public Retina r29(String r29) {
        this.r29 = r29;
        return this;
    }

    public void setr29(String r29) {
        this.r29 = r29;
    }

    public String getr30() {
        return r30;
    }

    public Retina r30(String r30) {
        this.r30 = r30;
        return this;
    }

    public void setr30(String r30) {
        this.r30 = r30;
    }

    public String getr31() {
        return r31;
    }

    public Retina r31(String r31) {
        this.r31 = r31;
        return this;
    }

    public void setr31(String r31) {
        this.r31 = r31;
    }

    public String getr32() {
        return r32;
    }

    public Retina r32(String r32) {
        this.r32 = r32;
        return this;
    }

    public void setr32(String r32) {
        this.r32 = r32;
    }

    public String getr33() {
        return r33;
    }

    public Retina r33(String r33) {
        this.r33 = r33;
        return this;
    }

    public void setr33(String r33) {
        this.r33 = r33;
    }

    public String getr34() {
        return r34;
    }

    public Retina r34(String r34) {
        this.r34 = r34;
        return this;
    }

    public void setr34(String r34) {
        this.r34 = r34;
    }

    public String getr35() {
        return r35;
    }

    public Retina r35(String r35) {
        this.r35 = r35;
        return this;
    }

    public void setr35(String r35) {
        this.r35 = r35;
    }

    public String getr36() {
        return r36;
    }

    public Retina r36(String r36) {
        this.r36 = r36;
        return this;
    }

    public void setr36(String r36) {
        this.r36 = r36;
    }

    public String getr37() {
        return r37;
    }

    public Retina r37(String r37) {
        this.r37 = r37;
        return this;
    }

    public void setr37(String r37) {
        this.r37 = r37;
    }

    public String getr38() {
        return r38;
    }

    public Retina r38(String r38) {
        this.r38 = r38;
        return this;
    }

    public void setr38(String r38) {
        this.r38 = r38;
    }

    public String getr39() {
        return r39;
    }

    public Retina r39(String r39) {
        this.r39 = r39;
        return this;
    }

    public void setr39(String r39) {
        this.r39 = r39;
    }

    public String getr40() {
        return r40;
    }

    public Retina r40(String r40) {
        this.r40 = r40;
        return this;
    }

    public void setr40(String r40) {
        this.r40 = r40;
    }

    public String getr41() {
        return r41;
    }

    public Retina r41(String r41) {
        this.r41 = r41;
        return this;
    }

    public void setr41(String r41) {
        this.r41 = r41;
    }

    public String getr42() {
        return r42;
    }

    public Retina r42(String r42) {
        this.r42 = r42;
        return this;
    }

    public void setr42(String r42) {
        this.r42 = r42;
    }

    public String getr43() {
        return r43;
    }

    public Retina r43(String r43) {
        this.r43 = r43;
        return this;
    }

    public void setr43(String r43) {
        this.r43 = r43;
    }

    public String getr44() {
        return r44;
    }

    public Retina r44(String r44) {
        this.r44 = r44;
        return this;
    }

    public void setr44(String r44) {
        this.r44 = r44;
    }

    public String getr45() {
        return r45;
    }

    public Retina r45(String r45) {
        this.r45 = r45;
        return this;
    }

    public void setr45(String r45) {
        this.r45 = r45;
    }

    public String getr46() {
        return r46;
    }

    public Retina r46(String r46) {
        this.r46 = r46;
        return this;
    }

    public void setr46(String r46) {
        this.r46 = r46;
    }

    public String getr47() {
        return r47;
    }

    public Retina r47(String r47) {
        this.r47 = r47;
        return this;
    }

    public void setr47(String r47) {
        this.r47 = r47;
    }

    public String getr48() {
        return r48;
    }

    public Retina r48(String r48) {
        this.r48 = r48;
        return this;
    }

    public void setr48(String r48) {
        this.r48 = r48;
    }

    public String getr49() {
        return r49;
    }

    public Retina r49(String r49) {
        this.r49 = r49;
        return this;
    }

    public void setr49(String r49) {
        this.r49 = r49;
    }

    public String getr50() {
        return r50;
    }

    public Retina r50(String r50) {
        this.r50 = r50;
        return this;
    }

    public void setr50(String r50) {
        this.r50 = r50;
    }

    public String getr51() {
        return r51;
    }

    public Retina r51(String r51) {
        this.r51 = r51;
        return this;
    }

    public void setr51(String r51) {
        this.r51 = r51;
    }

    public String getr52() {
        return r52;
    }

    public Retina r52(String r52) {
        this.r52 = r52;
        return this;
    }

    public void setr52(String r52) {
        this.r52 = r52;
    }

    public String getr53() {
        return r53;
    }

    public Retina r53(String r53) {
        this.r53 = r53;
        return this;
    }

    public void setr53(String r53) {
        this.r53 = r53;
    }

    public String getr54() {
        return r54;
    }

    public Retina r54(String r54) {
        this.r54 = r54;
        return this;
    }

    public void setr54(String r54) {
        this.r54 = r54;
    }

    public String getr55() {
        return r55;
    }

    public Retina r55(String r55) {
        this.r55 = r55;
        return this;
    }

    public void setr55(String r55) {
        this.r55 = r55;
    }

    public String geti1() {
        return i1;
    }

    public Retina i1(String i1) {
        this.i1 = i1;
        return this;
    }

    public void seti1(String i1) {
        this.i1 = i1;
    }

    public String geti2() {
        return i2;
    }

    public Retina i2(String i2) {
        this.i2 = i2;
        return this;
    }

    public void seti2(String i2) {
        this.i2 = i2;
    }

    public String geti3() {
        return i3;
    }

    public Retina i3(String i3) {
        this.i3 = i3;
        return this;
    }

    public void seti3(String i3) {
        this.i3 = i3;
    }

    public String geti4() {
        return i4;
    }

    public Retina i4(String i4) {
        this.i4 = i4;
        return this;
    }

    public void seti4(String i4) {
        this.i4 = i4;
    }

    public String geti5() {
        return i5;
    }

    public Retina i5(String i5) {
        this.i5 = i5;
        return this;
    }

    public void seti5(String i5) {
        this.i5 = i5;
    }

    public String geti6() {
        return i6;
    }

    public Retina i6(String i6) {
        this.i6 = i6;
        return this;
    }

    public void seti6(String i6) {
        this.i6 = i6;
    }

    public String geti7() {
        return i7;
    }

    public Retina i7(String i7) {
        this.i7 = i7;
        return this;
    }

    public void seti7(String i7) {
        this.i7 = i7;
    }

    public String geti8() {
        return i8;
    }

    public Retina i8(String i8) {
        this.i8 = i8;
        return this;
    }

    public void seti8(String i8) {
        this.i8 = i8;
    }

    public String geti9() {
        return i9;
    }

    public Retina i9(String i9) {
        this.i9 = i9;
        return this;
    }

    public void seti9(String i9) {
        this.i9 = i9;
    }

    public String geti10() {
        return i10;
    }

    public Retina i10(String i10) {
        this.i10 = i10;
        return this;
    }

    public void seti10(String i10) {
        this.i10 = i10;
    }

    public String geti11() {
        return i11;
    }

    public Retina i11(String i11) {
        this.i11 = i11;
        return this;
    }

    public void seti11(String i11) {
        this.i11 = i11;
    }

    public String geti12() {
        return i12;
    }

    public Retina i12(String i12) {
        this.i12 = i12;
        return this;
    }

    public void seti12(String i12) {
        this.i12 = i12;
    }

    public String geti13() {
        return i13;
    }

    public Retina i13(String i13) {
        this.i13 = i13;
        return this;
    }

    public void seti13(String i13) {
        this.i13 = i13;
    }

    public String geti14() {
        return i14;
    }

    public Retina i14(String i14) {
        this.i14 = i14;
        return this;
    }

    public void seti14(String i14) {
        this.i14 = i14;
    }

    public String geti15() {
        return i15;
    }

    public Retina i15(String i15) {
        this.i15 = i15;
        return this;
    }

    public void seti15(String i15) {
        this.i15 = i15;
    }

    public String geti16() {
        return i16;
    }

    public Retina i16(String i16) {
        this.i16 = i16;
        return this;
    }

    public void seti16(String i16) {
        this.i16 = i16;
    }

    public String geti17() {
        return i17;
    }

    public Retina i17(String i17) {
        this.i17 = i17;
        return this;
    }

    public void seti17(String i17) {
        this.i17 = i17;
    }

    public String geti18() {
        return i18;
    }

    public Retina i18(String i18) {
        this.i18 = i18;
        return this;
    }

    public void seti18(String i18) {
        this.i18 = i18;
    }

    public String geti19() {
        return i19;
    }

    public Retina i19(String i19) {
        this.i19 = i19;
        return this;
    }

    public void seti19(String i19) {
        this.i19 = i19;
    }

    public String geti20() {
        return i20;
    }

    public Retina i20(String i20) {
        this.i20 = i20;
        return this;
    }

    public void seti20(String i20) {
        this.i20 = i20;
    }

    public String geti21() {
        return i21;
    }

    public Retina i21(String i21) {
        this.i21 = i21;
        return this;
    }

    public void seti21(String i21) {
        this.i21 = i21;
    }

    public String geti22() {
        return i22;
    }

    public Retina i22(String i22) {
        this.i22 = i22;
        return this;
    }

    public void seti22(String i22) {
        this.i22 = i22;
    }

    public String geti23() {
        return i23;
    }

    public Retina i23(String i23) {
        this.i23 = i23;
        return this;
    }

    public void seti23(String i23) {
        this.i23 = i23;
    }

    public String geti24() {
        return i24;
    }

    public Retina i24(String i24) {
        this.i24 = i24;
        return this;
    }

    public void seti24(String i24) {
        this.i24 = i24;
    }

    public String geti25() {
        return i25;
    }

    public Retina i25(String i25) {
        this.i25 = i25;
        return this;
    }

    public void seti25(String i25) {
        this.i25 = i25;
    }

    public String geti26() {
        return i26;
    }

    public Retina i26(String i26) {
        this.i26 = i26;
        return this;
    }

    public void seti26(String i26) {
        this.i26 = i26;
    }

    public String geti27() {
        return i27;
    }

    public Retina i27(String i27) {
        this.i27 = i27;
        return this;
    }

    public void seti27(String i27) {
        this.i27 = i27;
    }

    public String geti28() {
        return i28;
    }

    public Retina i28(String i28) {
        this.i28 = i28;
        return this;
    }

    public void seti28(String i28) {
        this.i28 = i28;
    }

    public String geti29() {
        return i29;
    }

    public Retina i29(String i29) {
        this.i29 = i29;
        return this;
    }

    public void seti29(String i29) {
        this.i29 = i29;
    }

    public String geti30() {
        return i30;
    }

    public Retina i30(String i30) {
        this.i30 = i30;
        return this;
    }

    public void seti30(String i30) {
        this.i30 = i30;
    }

    public String geti31() {
        return i31;
    }

    public Retina i31(String i31) {
        this.i31 = i31;
        return this;
    }

    public void seti31(String i31) {
        this.i31 = i31;
    }

    public String geti32() {
        return i32;
    }

    public Retina i32(String i32) {
        this.i32 = i32;
        return this;
    }

    public void seti32(String i32) {
        this.i32 = i32;
    }

    public String geti33() {
        return i33;
    }

    public Retina i33(String i33) {
        this.i33 = i33;
        return this;
    }

    public void seti33(String i33) {
        this.i33 = i33;
    }

    public String geti34() {
        return i34;
    }

    public Retina i34(String i34) {
        this.i34 = i34;
        return this;
    }

    public void seti34(String i34) {
        this.i34 = i34;
    }

    public String geti35() {
        return i35;
    }

    public Retina i35(String i35) {
        this.i35 = i35;
        return this;
    }

    public void seti35(String i35) {
        this.i35 = i35;
    }

    public String geti36() {
        return i36;
    }

    public Retina i36(String i36) {
        this.i36 = i36;
        return this;
    }

    public void seti36(String i36) {
        this.i36 = i36;
    }

    public String geti37() {
        return i37;
    }

    public Retina i37(String i37) {
        this.i37 = i37;
        return this;
    }

    public void seti37(String i37) {
        this.i37 = i37;
    }

    public String geti38() {
        return i38;
    }

    public Retina i38(String i38) {
        this.i38 = i38;
        return this;
    }

    public void seti38(String i38) {
        this.i38 = i38;
    }

    public String geti39() {
        return i39;
    }

    public Retina i39(String i39) {
        this.i39 = i39;
        return this;
    }

    public void seti39(String i39) {
        this.i39 = i39;
    }

    public String geti40() {
        return i40;
    }

    public Retina i40(String i40) {
        this.i40 = i40;
        return this;
    }

    public void seti40(String i40) {
        this.i40 = i40;
    }

    public String geti41() {
        return i41;
    }

    public Retina i41(String i41) {
        this.i41 = i41;
        return this;
    }

    public void seti41(String i41) {
        this.i41 = i41;
    }

    public String geti42() {
        return i42;
    }

    public Retina i42(String i42) {
        this.i42 = i42;
        return this;
    }

    public void seti42(String i42) {
        this.i42 = i42;
    }

    public String geti43() {
        return i43;
    }

    public Retina i43(String i43) {
        this.i43 = i43;
        return this;
    }

    public void seti43(String i43) {
        this.i43 = i43;
    }

    public String geti44() {
        return i44;
    }

    public Retina i44(String i44) {
        this.i44 = i44;
        return this;
    }

    public void seti44(String i44) {
        this.i44 = i44;
    }

    public String geti45() {
        return i45;
    }

    public Retina i45(String i45) {
        this.i45 = i45;
        return this;
    }

    public void seti45(String i45) {
        this.i45 = i45;
    }

    public String geti46() {
        return i46;
    }

    public Retina i46(String i46) {
        this.i46 = i46;
        return this;
    }

    public void seti46(String i46) {
        this.i46 = i46;
    }

    public String geti47() {
        return i47;
    }

    public Retina i47(String i47) {
        this.i47 = i47;
        return this;
    }

    public void seti47(String i47) {
        this.i47 = i47;
    }

    public String geti48() {
        return i48;
    }

    public Retina i48(String i48) {
        this.i48 = i48;
        return this;
    }

    public void seti48(String i48) {
        this.i48 = i48;
    }

    public String geti49() {
        return i49;
    }

    public Retina i49(String i49) {
        this.i49 = i49;
        return this;
    }

    public void seti49(String i49) {
        this.i49 = i49;
    }

    public String geti50() {
        return i50;
    }

    public Retina i50(String i50) {
        this.i50 = i50;
        return this;
    }

    public void seti50(String i50) {
        this.i50 = i50;
    }

    public String geti51() {
        return i51;
    }

    public Retina i51(String i51) {
        this.i51 = i51;
        return this;
    }

    public void seti51(String i51) {
        this.i51 = i51;
    }

    public String geti52() {
        return i52;
    }

    public Retina i52(String i52) {
        this.i52 = i52;
        return this;
    }

    public void seti52(String i52) {
        this.i52 = i52;
    }

    public String geti53() {
        return i53;
    }

    public Retina i53(String i53) {
        this.i53 = i53;
        return this;
    }

    public void seti53(String i53) {
        this.i53 = i53;
    }

    public String geti54() {
        return i54;
    }

    public Retina i54(String i54) {
        this.i54 = i54;
        return this;
    }

    public void seti54(String i54) {
        this.i54 = i54;
    }

    public String geti55() {
        return i55;
    }

    public Retina i55(String i55) {
        this.i55 = i55;
        return this;
    }

    public void seti55(String i55) {
        this.i55 = i55;
    }

    public String getDoctor() {
        return doctor;
    }

    public Retina doctor(String doctor) {
        this.doctor = doctor;
        return this;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getr56() {
        return r56;
    }

    public Retina r56(String r56) {
        this.r56 = r56;
        return this;
    }

    public void setr56(String r56) {
        this.r56 = r56;
    }

    public String getr57() {
        return r57;
    }

    public Retina r57(String r57) {
        this.r57 = r57;
        return this;
    }

    public void setr57(String r57) {
        this.r57 = r57;
    }

    public String getr58() {
        return r58;
    }

    public Retina r58(String r58) {
        this.r58 = r58;
        return this;
    }

    public void setr58(String r58) {
        this.r58 = r58;
    }

    public String getr59() {
        return r59;
    }

    public Retina r59(String r59) {
        this.r59 = r59;
        return this;
    }

    public void setr59(String r59) {
        this.r59 = r59;
    }

    public String getr60() {
        return r60;
    }

    public Retina r60(String r60) {
        this.r60 = r60;
        return this;
    }

    public void setr60(String r60) {
        this.r60 = r60;
    }

    public String getr61() {
        return r61;
    }

    public Retina r61(String r61) {
        this.r61 = r61;
        return this;
    }

    public void setr61(String r61) {
        this.r61 = r61;
    }

    public String getr62() {
        return r62;
    }

    public Retina r62(String r62) {
        this.r62 = r62;
        return this;
    }

    public void setr62(String r62) {
        this.r62 = r62;
    }

    public String getr63() {
        return r63;
    }

    public Retina r63(String r63) {
        this.r63 = r63;
        return this;
    }

    public void setr63(String r63) {
        this.r63 = r63;
    }

    public String getr64() {
        return r64;
    }

    public Retina r64(String r64) {
        this.r64 = r64;
        return this;
    }

    public void setr64(String r64) {
        this.r64 = r64;
    }

    public String geti56() {
        return i56;
    }

    public Retina i56(String i56) {
        this.i56 = i56;
        return this;
    }

    public void seti56(String i56) {
        this.i56 = i56;
    }

    public String geti57() {
        return i57;
    }

    public Retina i57(String i57) {
        this.i57 = i57;
        return this;
    }

    public void seti57(String i57) {
        this.i57 = i57;
    }

    public String geti58() {
        return i58;
    }

    public Retina i58(String i58) {
        this.i58 = i58;
        return this;
    }

    public void seti58(String i58) {
        this.i58 = i58;
    }

    public String geti59() {
        return i59;
    }

    public Retina i59(String i59) {
        this.i59 = i59;
        return this;
    }

    public void seti59(String i59) {
        this.i59 = i59;
    }

    public String geti60() {
        return i60;
    }

    public Retina i60(String i60) {
        this.i60 = i60;
        return this;
    }

    public void seti60(String i60) {
        this.i60 = i60;
    }

    public String geti61() {
        return i61;
    }

    public Retina i61(String i61) {
        this.i61 = i61;
        return this;
    }

    public void seti61(String i61) {
        this.i61 = i61;
    }

    public String geti62() {
        return i62;
    }

    public Retina i62(String i62) {
        this.i62 = i62;
        return this;
    }

    public void seti62(String i62) {
        this.i62 = i62;
    }

    public String geti63() {
        return i63;
    }

    public Retina i63(String i63) {
        this.i63 = i63;
        return this;
    }

    public void seti63(String i63) {
        this.i63 = i63;
    }

    public String geti64() {
        return i64;
    }

    public Retina i64(String i64) {
        this.i64 = i64;
        return this;
    }

    public void seti64(String i64) {
        this.i64 = i64;
    }

    public LocalDate getHoraini() {
        return horaini;
    }

    public Retina horaini(LocalDate horaini) {
        this.horaini = horaini;
        return this;
    }

    public void setHoraini(LocalDate horaini) {
        this.horaini = horaini;
    }

    public Integer getUltimoidxod() {
        return ultimoidxod;
    }

    public Retina ultimoidxod(Integer ultimoidxod) {
        this.ultimoidxod = ultimoidxod;
        return this;
    }

    public void setUltimoidxod(Integer ultimoidxod) {
        this.ultimoidxod = ultimoidxod;
    }

    public Integer getUltimoidxoi() {
        return ultimoidxoi;
    }

    public Retina ultimoidxoi(Integer ultimoidxoi) {
        this.ultimoidxoi = ultimoidxoi;
        return this;
    }

    public void setUltimoidxoi(Integer ultimoidxoi) {
        this.ultimoidxoi = ultimoidxoi;
    }

    public Integer getTipovisita() {
        return tipovisita;
    }

    public Retina tipovisita(Integer tipovisita) {
        this.tipovisita = tipovisita;
        return this;
    }

    public void setTipovisita(Integer tipovisita) {
        this.tipovisita = tipovisita;
    }

    public Boolean isCampi() {
        return campi;
    }

    public Retina campi(Boolean campi) {
        this.campi = campi;
        return this;
    }

    public void setCampi(Boolean campi) {
        this.campi = campi;
    }

    public Boolean isTopo() {
        return topo;
    }

    public Retina topo(Boolean topo) {
        this.topo = topo;
        return this;
    }

    public void setTopo(Boolean topo) {
        this.topo = topo;
    }

    public Boolean isOctp() {
        return octp;
    }

    public Retina octp(Boolean octp) {
        this.octp = octp;
        return this;
    }

    public void setOctp(Boolean octp) {
        this.octp = octp;
    }

    public Boolean isOcta() {
        return octa;
    }

    public Retina octa(Boolean octa) {
        this.octa = octa;
        return this;
    }

    public void setOcta(Boolean octa) {
        this.octa = octa;
    }

    public Boolean isReti() {
        return reti;
    }

    public Retina reti(Boolean reti) {
        this.reti = reti;
        return this;
    }

    public void setReti(Boolean reti) {
        this.reti = reti;
    }

    public Boolean isAngi() {
        return angi;
    }

    public Retina angi(Boolean angi) {
        this.angi = angi;
        return this;
    }

    public void setAngi(Boolean angi) {
        this.angi = angi;
    }

    public Boolean isConta() {
        return conta;
    }

    public Retina conta(Boolean conta) {
        this.conta = conta;
        return this;
    }

    public void setConta(Boolean conta) {
        this.conta = conta;
    }

    public Boolean isBio() {
        return bio;
    }

    public Retina bio(Boolean bio) {
        this.bio = bio;
        return this;
    }

    public void setBio(Boolean bio) {
        this.bio = bio;
    }

    public Boolean isPolo() {
        return polo;
    }

    public Retina polo(Boolean polo) {
        this.polo = polo;
        return this;
    }

    public void setPolo(Boolean polo) {
        this.polo = polo;
    }

    public Boolean isPaqui() {
        return paqui;
    }

    public Retina paqui(Boolean paqui) {
        this.paqui = paqui;
        return this;
    }

    public void setPaqui(Boolean paqui) {
        this.paqui = paqui;
    }

    public Boolean isOtra1() {
        return otra1;
    }

    public Retina otra1(Boolean otra1) {
        this.otra1 = otra1;
        return this;
    }

    public void setOtra1(Boolean otra1) {
        this.otra1 = otra1;
    }

    public Boolean isOtra2() {
        return otra2;
    }

    public Retina otra2(Boolean otra2) {
        this.otra2 = otra2;
        return this;
    }

    public void setOtra2(Boolean otra2) {
        this.otra2 = otra2;
    }

    public Boolean isOtra3() {
        return otra3;
    }

    public Retina otra3(Boolean otra3) {
        this.otra3 = otra3;
        return this;
    }

    public void setOtra3(Boolean otra3) {
        this.otra3 = otra3;
    }

    public Boolean isOtra4() {
        return otra4;
    }

    public Retina otra4(Boolean otra4) {
        this.otra4 = otra4;
        return this;
    }

    public void setOtra4(Boolean otra4) {
        this.otra4 = otra4;
    }

    public Integer getNuhsa() {
        return nuhsa;
    }

    public Retina nuhsa(Integer nuhsa) {
        this.nuhsa = nuhsa;
        return this;
    }

    public void setNuhsa(Integer nuhsa) {
        this.nuhsa = nuhsa;
    }

    public String getHosp() {
        return hosp;
    }

    public Retina hosp(String hosp) {
        this.hosp = hosp;
        return this;
    }

    public void setHosp(String hosp) {
        this.hosp = hosp;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Retina retina = (Retina) o;
        if (retina.getHistorial() == null || getHistorial() == null) {
            return false;
        }
        return Objects.equals(getHistorial(), retina.getHistorial());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getHistorial());
    }

    @Override
    public String toString() {
        return "Retina{" +
            ", historial='" + getHistorial() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", visita='" + getVisita() + "'" +
            ", diagangio='" + getDiagangio() + "'" +
            ", diagoft='" + getDiagoft() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", notas='" + getNotas() + "'" +
            ", r1='" + getr1() + "'" +
            ", r2='" + getr2() + "'" +
            ", r3='" + getr3() + "'" +
            ", r4='" + getr4() + "'" +
            ", r5='" + getr5() + "'" +
            ", r6='" + getr6() + "'" +
            ", r7='" + getr7() + "'" +
            ", r8='" + getr8() + "'" +
            ", r9='" + getr9() + "'" +
            ", r10='" + getr10() + "'" +
            ", r11='" + getr11() + "'" +
            ", r12='" + getr12() + "'" +
            ", r13='" + getr13() + "'" +
            ", r14='" + getr14() + "'" +
            ", r15='" + getr15() + "'" +
            ", r16='" + getr16() + "'" +
            ", r17='" + getr17() + "'" +
            ", r18='" + getr18() + "'" +
            ", r19='" + getr19() + "'" +
            ", r20='" + getr20() + "'" +
            ", r21='" + getr21() + "'" +
            ", r22='" + getr22() + "'" +
            ", r23='" + getr23() + "'" +
            ", r24='" + getr24() + "'" +
            ", r25='" + getr25() + "'" +
            ", r26='" + getr26() + "'" +
            ", r27='" + getr27() + "'" +
            ", r28='" + getr28() + "'" +
            ", r29='" + getr29() + "'" +
            ", r30='" + getr30() + "'" +
            ", r31='" + getr31() + "'" +
            ", r32='" + getr32() + "'" +
            ", r33='" + getr33() + "'" +
            ", r34='" + getr34() + "'" +
            ", r35='" + getr35() + "'" +
            ", r36='" + getr36() + "'" +
            ", r37='" + getr37() + "'" +
            ", r38='" + getr38() + "'" +
            ", r39='" + getr39() + "'" +
            ", r40='" + getr40() + "'" +
            ", r41='" + getr41() + "'" +
            ", r42='" + getr42() + "'" +
            ", r43='" + getr43() + "'" +
            ", r44='" + getr44() + "'" +
            ", r45='" + getr45() + "'" +
            ", r46='" + getr46() + "'" +
            ", r47='" + getr47() + "'" +
            ", r48='" + getr48() + "'" +
            ", r49='" + getr49() + "'" +
            ", r50='" + getr50() + "'" +
            ", r51='" + getr51() + "'" +
            ", r52='" + getr52() + "'" +
            ", r53='" + getr53() + "'" +
            ", r54='" + getr54() + "'" +
            ", r55='" + getr55() + "'" +
            ", i1='" + geti1() + "'" +
            ", i2='" + geti2() + "'" +
            ", i3='" + geti3() + "'" +
            ", i4='" + geti4() + "'" +
            ", i5='" + geti5() + "'" +
            ", i6='" + geti6() + "'" +
            ", i7='" + geti7() + "'" +
            ", i8='" + geti8() + "'" +
            ", i9='" + geti9() + "'" +
            ", i10='" + geti10() + "'" +
            ", i11='" + geti11() + "'" +
            ", i12='" + geti12() + "'" +
            ", i13='" + geti13() + "'" +
            ", i14='" + geti14() + "'" +
            ", i15='" + geti15() + "'" +
            ", i16='" + geti16() + "'" +
            ", i17='" + geti17() + "'" +
            ", i18='" + geti18() + "'" +
            ", i19='" + geti19() + "'" +
            ", i20='" + geti20() + "'" +
            ", i21='" + geti21() + "'" +
            ", i22='" + geti22() + "'" +
            ", i23='" + geti23() + "'" +
            ", i24='" + geti24() + "'" +
            ", i25='" + geti25() + "'" +
            ", i26='" + geti26() + "'" +
            ", i27='" + geti27() + "'" +
            ", i28='" + geti28() + "'" +
            ", i29='" + geti29() + "'" +
            ", i30='" + geti30() + "'" +
            ", i31='" + geti31() + "'" +
            ", i32='" + geti32() + "'" +
            ", i33='" + geti33() + "'" +
            ", i34='" + geti34() + "'" +
            ", i35='" + geti35() + "'" +
            ", i36='" + geti36() + "'" +
            ", i37='" + geti37() + "'" +
            ", i38='" + geti38() + "'" +
            ", i39='" + geti39() + "'" +
            ", i40='" + geti40() + "'" +
            ", i41='" + geti41() + "'" +
            ", i42='" + geti42() + "'" +
            ", i43='" + geti43() + "'" +
            ", i44='" + geti44() + "'" +
            ", i45='" + geti45() + "'" +
            ", i46='" + geti46() + "'" +
            ", i47='" + geti47() + "'" +
            ", i48='" + geti48() + "'" +
            ", i49='" + geti49() + "'" +
            ", i50='" + geti50() + "'" +
            ", i51='" + geti51() + "'" +
            ", i52='" + geti52() + "'" +
            ", i53='" + geti53() + "'" +
            ", i54='" + geti54() + "'" +
            ", i55='" + geti55() + "'" +
            ", doctor='" + getDoctor() + "'" +
            ", r56='" + getr56() + "'" +
            ", r57='" + getr57() + "'" +
            ", r58='" + getr58() + "'" +
            ", r59='" + getr59() + "'" +
            ", r60='" + getr60() + "'" +
            ", r61='" + getr61() + "'" +
            ", r62='" + getr62() + "'" +
            ", r63='" + getr63() + "'" +
            ", r64='" + getr64() + "'" +
            ", i56='" + geti56() + "'" +
            ", i57='" + geti57() + "'" +
            ", i58='" + geti58() + "'" +
            ", i59='" + geti59() + "'" +
            ", i60='" + geti60() + "'" +
            ", i61='" + geti61() + "'" +
            ", i62='" + geti62() + "'" +
            ", i63='" + geti63() + "'" +
            ", i64='" + geti64() + "'" +
            ", horaini='" + getHoraini() + "'" +
            ", ultimoidxod='" + getUltimoidxod() + "'" +
            ", ultimoidxoi='" + getUltimoidxoi() + "'" +
            ", tipovisita='" + getTipovisita() + "'" +
            ", campi='" + isCampi() + "'" +
            ", topo='" + isTopo() + "'" +
            ", octp='" + isOctp() + "'" +
            ", octa='" + isOcta() + "'" +
            ", reti='" + isReti() + "'" +
            ", angi='" + isAngi() + "'" +
            ", conta='" + isConta() + "'" +
            ", bio='" + isBio() + "'" +
            ", polo='" + isPolo() + "'" +
            ", paqui='" + isPaqui() + "'" +
            ", otra1='" + isOtra1() + "'" +
            ", otra2='" + isOtra2() + "'" +
            ", otra3='" + isOtra3() + "'" +
            ", otra4='" + isOtra4() + "'" +
            ", nuhsa='" + getNuhsa() + "'" +
            ", hosp='" + getHosp() + "'" +
            "}";
    }
}
