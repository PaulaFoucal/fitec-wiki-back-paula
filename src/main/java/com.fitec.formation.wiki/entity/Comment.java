package com.fitec.formation.wiki.entity;

import java.util.Date;
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
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMMENT")
	private Long idComment;
	private String title;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

    @ManyToOne (cascade = CascadeType.ALL)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
	private Article article;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @NotNull
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENT_COMMENT", referencedColumnName = "ID_COMMENT")
    private Comment parentComment;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childComments;

}
