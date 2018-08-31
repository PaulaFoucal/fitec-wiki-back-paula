package com.fitec.formation.wiki.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserLogger {

//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_USER_LOGGER")
//	private Long idUserLogger;
    private String email;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date creationDate;

	@ManyToOne (cascade = CascadeType.ALL)
	@NotNull
	private Profile profile;

}
