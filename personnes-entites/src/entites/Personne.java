package entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("unused")
@Entity
@Table(name="jpa01_personne")
public class Personne {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "VERSION", nullable = false)
	@Version
	private int version;

	@Column(name = "NOM", length = 30, nullable = false, unique = true)
	private String nom;

	@Column(name = "PRENOM", length = 30, nullable = false)
	private String prenom;

	@Column(name = "DATENAISSANCE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	@Column(name = "MARIE", nullable = false)
	private boolean marie;

	@Column(name = "NBENFANTS", nullable = false)
	private int nbenfants;

	// constructeurs
	public Personne() {
	}

	public Personne(String nom, String prenom, Date datenaissance, boolean marie,
			int nbenfants) {
		setNom(nom);
		setPrenom(prenom);
		setDatenaissance(datenaissance);
		setMarie(marie);
		setNbenfants(nbenfants);
	}

	// toString
	public String toString() {
		return String.format("[%d,%d,%s,%s,%s,%s,%d]", getId(), getVersion(),
				getNom(), getPrenom(), new SimpleDateFormat("dd/MM/yyyy")
						.format(getDatenaissance()), isMarie(), getNbenfants());
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	private void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public boolean isMarie() {
		return marie;
	}

	public void setMarie(boolean marie) {
		this.marie = marie;
	}

	public int getNbenfants() {
		return nbenfants;
	}

	public void setNbenfants(int nbenfants) {
		this.nbenfants = nbenfants;
	}
}
