package com.fitec.formation.wiki.entity;

import java.util.List;

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
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
	private Long idUser;

	@Embedded
	private UserLogger userLogger;

	@Embedded
	private UserInfo userInfo;

    @ManyToOne (cascade = CascadeType.ALL)
    private Status status;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

}
