package com.fitec.formation.wiki.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserInfo {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_USER_INFO")
//    private Long idUserInfo;
    private String firstName;
	private String lastName;
	private String phone;
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Embedded
	private Address address;

}
