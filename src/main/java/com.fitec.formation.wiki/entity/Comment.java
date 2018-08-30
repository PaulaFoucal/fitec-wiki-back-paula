package com.fitec.formation.wiki.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMENT")
	private Long idComment;
	@Column(name = "CONTENT")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION")
	private Date creationDate;

    @Column(name = "STATUS_TYPE", nullable = false)
    @ManyToOne
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
	@Column(nullable = false)
	private Article article;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENT_COMMENT", referencedColumnName = "ID_COMMENT")
    private Comment parentComment;
    @OneToMany(mappedBy = "PARENT_COMMENT")
    private List<Comment> childComments;

}
