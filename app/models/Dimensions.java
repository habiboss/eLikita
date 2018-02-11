/*package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import play.db.jpa.JPA;
import services.CourseSvr;

@Entity
@Table(name = "dw_dimensions")
public class Dimensions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "entite")
	private String entite;
	@Column(name = "champ")
	private String champ;
	@Column(name = "valeur", length = 1000)
	private String valeur;
	@Column(name = "typeChamp")
	private String type;
	@Column(name = "IID")
	private String IID;
	
	@Transient
	final static String iid = "3482xx120";
	
	private Dimensions createDim(String entity, String champ, String valeur, String typeChamp, String iid) {
		Dimensions dim = new Dimensions();
		dim.setEntite(entity);
		dim.setChamp(champ);
		dim.setValeur(valeur);
		dim.setType(typeChamp);
		dim.setIID(iid);
		return dim;
	}
	
	public List<Dimensions> courses() {
		final String entityName = "course";
		List<Dimensions> all = new ArrayList<>();
		List<Course> course = new CourseSvr().findList();
		for (Course cr : course) {
			all.add(createDim(entityName, "code", cr.getCourseCode(), "String", iid));
			all.add(createDim(entityName, "intitule", cr.getCourseTitle(), "String", iid));
		}
		return all;
	}
	
	public String save() {
		List<Dimensions> all = new ArrayList<>();
		
		for (Dimensions dim : courses()) {
			all.add(dim);
		}
		String result = null;
		for (int i = 0; i < all.size(); i++) {
			try {
				JPA.em().persist(all.get(i));
			} catch (Exception e) {
				result = e.toString();
			}
		}

		return result;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEntite() {
		return entite;
	}
	public void setEntite(String entite) {
		this.entite = entite;
	}
	public String getChamp() {
		return champ;
	}
	public void setChamp(String champ) {
		this.champ = champ;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIID() {
		return IID;
	}
	public void setIID(String iID) {
		IID = iID;
	}
	
	
	
	
	
}
*/