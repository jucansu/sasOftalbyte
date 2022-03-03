package es.surmedid.angiobyte.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Angio.
 */
@Entity
@Table(name = "angio")
public class Angio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "historial", nullable = false)
    private Long historial;

    @NotNull
    @Size(max = 80)
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "visita", nullable = false)
    private Integer visita;

    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "fechanac")
    private LocalDate fechanac;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "notas")
    private String notas;

    @Size(max = 80)
    @Column(name = "ciudad", length = 80)
    private String ciudad;

    @Size(max = 80)
    @Column(name = "procedencia", length = 80)
    private String procedencia;

    @Size(max = 80)
    @Column(name = "profesion", length = 80)
    private String profesion;

    @Size(max = 250)
    @Column(name = "antecedentes", length = 250)
    private String antecedentes;

    @Column(name = "i5")
    private String i5;

    @Column(name = "i6")
    private String i6;

    @Column(name = "i7")
    private String i7;

    @Column(name = "i8")
    private String i8;

    @Column(name = "i9")
    private String i9;

    @Column(name = "i10")
    private String i10;

    @Column(name = "i11")
    private String i11;

    @Column(name = "i12")
    private String i12;

    @Column(name = "i13")
    private String i13;

    @Column(name = "i14")
    private String i14;

    @Column(name = "i15")
    private String i15;

    @Column(name = "i16")
    private String i16;

    @Column(name = "imaginet")
    private Integer imaginet;

    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "nuhsa")
    private String nuhsa;

    public Long getHistorial() {
        return historial;
    }

    public Angio historial(Long historial) {
        this.historial = historial;
        return this;
    }

    public void setHistorial(Long historial) {
        this.historial = historial;
    }

    public String getNombre() {
        return nombre;
    }

    public Angio nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVisita() {
        return visita;
    }

    public Angio visita(Integer visita) {
        this.visita = visita;
        return this;
    }

    public void setVisita(Integer visita) {
        this.visita = visita;
    }

    public String getDireccion() {
        return direccion;
    }

    public Angio direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public Angio fechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
        return this;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Angio fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNotas() {
        return notas;
    }

    public Angio notas(String notas) {
        this.notas = notas;
        return this;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Angio ciudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public Angio procedencia(String procedencia) {
        this.procedencia = procedencia;
        return this;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getProfesion() {
        return profesion;
    }

    public Angio profesion(String profesion) {
        this.profesion = profesion;
        return this;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public Angio antecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
        return this;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String geti5() {
        return i5;
    }

    public Angio i5(String i5) {
        this.i5 = i5;
        return this;
    }

    public void seti5(String i5) {
        this.i5 = i5;
    }

    public String geti6() {
        return i6;
    }

    public Angio i6(String i6) {
        this.i6 = i6;
        return this;
    }

    public void seti6(String i6) {
        this.i6 = i6;
    }

    public String geti7() {
        return i7;
    }

    public Angio i7(String i7) {
        this.i7 = i7;
        return this;
    }

    public void seti7(String i7) {
        this.i7 = i7;
    }

    public String geti8() {
        return i8;
    }

    public Angio i8(String i8) {
        this.i8 = i8;
        return this;
    }

    public void seti8(String i8) {
        this.i8 = i8;
    }

    public String geti9() {
        return i9;
    }

    public Angio i9(String i9) {
        this.i9 = i9;
        return this;
    }

    public void seti9(String i9) {
        this.i9 = i9;
    }

    public String geti10() {
        return i10;
    }

    public Angio i10(String i10) {
        this.i10 = i10;
        return this;
    }

    public void seti10(String i10) {
        this.i10 = i10;
    }

    public String geti11() {
        return i11;
    }

    public Angio i11(String i11) {
        this.i11 = i11;
        return this;
    }

    public void seti11(String i11) {
        this.i11 = i11;
    }

    public String geti12() {
        return i12;
    }

    public Angio i12(String i12) {
        this.i12 = i12;
        return this;
    }

    public void seti12(String i12) {
        this.i12 = i12;
    }

    public String geti13() {
        return i13;
    }

    public Angio i13(String i13) {
        this.i13 = i13;
        return this;
    }

    public void seti13(String i13) {
        this.i13 = i13;
    }

    public String geti14() {
        return i14;
    }

    public Angio i14(String i14) {
        this.i14 = i14;
        return this;
    }

    public void seti14(String i14) {
        this.i14 = i14;
    }

    public String geti15() {
        return i15;
    }

    public Angio i15(String i15) {
        this.i15 = i15;
        return this;
    }

    public void seti15(String i15) {
        this.i15 = i15;
    }

    public String geti16() {
        return i16;
    }

    public Angio i16(String i16) {
        this.i16 = i16;
        return this;
    }

    public void seti16(String i16) {
        this.i16 = i16;
    }

    public Integer getImaginet() {
        return imaginet;
    }

    public Angio imaginet(Integer imaginet) {
        this.imaginet = imaginet;
        return this;
    }

    public void setImaginet(Integer imaginet) {
        this.imaginet = imaginet;
    }

    public String getNuhsa() {
        return nuhsa;
    }

    public Angio nuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
        return this;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
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
        Angio angio = (Angio) o;
        if (angio.getHistorial() == null || getHistorial() == null) {
            return false;
        }
        return Objects.equals(getHistorial(), angio.getHistorial());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getHistorial());
    }

    @Override
    public String toString() {
        return "Angio{" +
            ", historial='" + getHistorial() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", visita='" + getVisita() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", fechanac='" + getFechanac() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", notas='" + getNotas() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", procedencia='" + getProcedencia() + "'" +
            ", profesion='" + getProfesion() + "'" +
            ", antecedentes='" + getAntecedentes() + "'" +
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
            ", imaginet='" + getImaginet() + "'" +
            ", nuhsa='" + getNuhsa() + "'" +
            "}";
    }
}
