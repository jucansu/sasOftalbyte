package es.surmedid.angiobyte.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class RetinaEmbedded implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Column(name = "Nuhsa")
    private String nuhsa;

    @Column(name = "Visita")
    private Integer visita;

	public String getNuhsa() {
		return nuhsa;
	}

	public void setNuhsa(String nuhsa) {
		this.nuhsa = nuhsa;
	}

	public Integer getVisita() {
		return visita;
	}

	public void setVisita(Integer visita) {
		this.visita = visita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nuhsa == null) ? 0 : nuhsa.hashCode());
		result = prime * result + ((visita == null) ? 0 : visita.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetinaEmbedded other = (RetinaEmbedded) obj;
		if (nuhsa == null) {
			if (other.nuhsa != null)
				return false;
		} else if (!nuhsa.equals(other.nuhsa))
			return false;
		if (visita == null) {
			if (other.visita != null)
				return false;
		} else if (!visita.equals(other.visita))
			return false;
		return true;
	}
    
    

}
