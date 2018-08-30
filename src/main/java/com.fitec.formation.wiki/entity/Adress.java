package com.fitec.formation.wiki.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Adress {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADRESS")
	private Long idAdress;
	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;
	@Column(name = "STREET")
	private String street;
	@Column(name = "ZIPCODE")
	private String zipcode;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	
	public Adress(String houseNumber, String street, String zipcode, String city, String country) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
	}
	
}
