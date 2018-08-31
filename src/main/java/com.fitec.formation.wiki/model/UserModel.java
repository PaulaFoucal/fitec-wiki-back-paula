package com.fitec.formation.wiki.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fitec.formation.wiki.utils.Constants;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

	private String userName;
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
	private Date creationDate;
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN)
	private Date birthday;
	private String street;
	private String zipcode;
	private String city;
	private String country;

	private StatusModel statusModel;
	private ProfileModel profileModel;
	private List<ArticleModel> articlesModel;
	private List<CommentModel> commentsModel;

}
