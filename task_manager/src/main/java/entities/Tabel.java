package entities;
// Generated Jul 12, 2016 12:05:47 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tabel generated by hbm2java
 */
@Entity
@Table(name = "tabel", catalog = "test")
public class Tabel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTabel;
	private String nume;

	public Tabel() {
	}

	public Tabel(String nume) {
		this.nume = nume;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_tabel", unique = true, nullable = false)
	public Integer getIdTabel() {
		return this.idTabel;
	}

	public void setIdTabel(Integer idTabel) {
		this.idTabel = idTabel;
	}

	@Column(name = "nume", nullable = false, length = 20)
	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

}
