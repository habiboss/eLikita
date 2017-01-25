package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profile_info")
public class Profile_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "student_fk")
	private Student studentDetail;
	@Column(name = "favorite_quran_reciter")
	private String favoriteQuranReciter;
	@Column(name = "favorite_game")
	private String favoriteGame;
	@Column(name = "facebook_url")
	private String facebookURL;
	@Column(name = "linkedIn_url")
	private String linkedInURL;
	@Column(name = "created")
	private String created;
	@Column(name = "modified")
	private String modified;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFavoriteQuranReciter() {
		return favoriteQuranReciter;
	}
	public void setFavoriteQuranReciter(String favoriteQuranReciter) {
		this.favoriteQuranReciter = favoriteQuranReciter;
	}
	public String getFavoriteGame() {
		return favoriteGame;
	}
	public void setFavoriteGame(String favoriteGame) {
		this.favoriteGame = favoriteGame;
	}
	public String getFacebookURL() {
		return facebookURL;
	}
	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}
	public String getLinkedInURL() {
		return linkedInURL;
	}
	public void setLinkedInURL(String linkedInURL) {
		this.linkedInURL = linkedInURL;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	
	
	

}
