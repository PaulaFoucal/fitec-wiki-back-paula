package com.fitec.formation.wiki.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserLogIn {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER_LOGIN")
	private Long idUserLogin;
    @Column(name = "E_MAIL")
    private String email;
	@Column(name = "USERNAME", nullable = false)
	private String userName;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;

	@Column(name = "PROFILE_TYPE", nullable = false)
	@ManyToOne
	private Profile profile;

	public UserLogIn(String email, String userName, String password, Date creationDate, Profile profile) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
		this.profile = profile;
	}
	
}
