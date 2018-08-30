package com.fitec.formation.wiki.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long idUser;

	@Embedded
	private UserLogIn userLogin;

	@Embedded
	private UserDetail userDetail;

	@OneToMany(mappedBy = "ARTICLE")
	private List<Article> articles;
	
	@OneToMany(mappedBy = "COMMENT")
	private List<Comment> comments;

	@Column(name = "STATUS_TYPE", nullable = false)
	@ManyToOne
	private Status status;

}
