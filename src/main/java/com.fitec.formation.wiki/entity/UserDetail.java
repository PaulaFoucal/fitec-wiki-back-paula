package com.fitec.formation.wiki.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class UserDetail {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER_DETAIL")
	private Long idUserDetail;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "TELEPHONE")
	private String telephoneNumber;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	@Embedded
	private Adress adress;

	public UserDetail(String lastName, String firstName, String telephoneNumber, Date birthday,
			Adress adress) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.telephoneNumber = telephoneNumber;
		this.birthday = birthday;
		this.adress = adress;
	}

}
