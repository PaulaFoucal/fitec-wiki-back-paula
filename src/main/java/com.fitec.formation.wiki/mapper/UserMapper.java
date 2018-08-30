package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Adress;
import com.fitec.formation.wiki.entity.UserDetail;
import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.entity.UserLogIn;
import com.fitec.formation.wiki.model.ArticleModel;
import com.fitec.formation.wiki.model.CommentModel;
import com.fitec.formation.wiki.model.UserModel;
import utils.Messages;

/*
 * Map model and entity
 * 
 * User
 * 
 */

public class UserMapper {

	public static UserModel mapToUserModel(User u) {
		UserModel um = new UserModel();
		um.setUserName(u.getUserLogin().getUserName());
		um.setPassword(u.getUserLogin().getPassword());
		um.setCreationDate(u.getUserLogin().getCreationDate());
		um.setLastName(u.getUserDetail().getLastName());
		um.setFirstName(u.getUserDetail().getFirstName());
		um.setEmail(u.getUserLogin().getEmail());
		um.setTelephoneNumber(u.getUserDetail().getTelephoneNumber());
		um.setBirthday(u.getUserDetail().getBirthday());
		um.setHouseNumber(u.getUserDetail().getAdress().getHouseNumber());
		um.setStreet(u.getUserDetail().getAdress().getStreet());
		um.setZipcode(u.getUserDetail().getAdress().getZipcode());
		um.setCity(u.getUserDetail().getAdress().getCity());
		um.setCountry(u.getUserDetail().getAdress().getCountry());
		um.setStatusModel(StatusMapper.mapToStatusModel(u.getStatus()));
		um.setProfileModel(ProfileMapper.mapToProfileModel(u.getUserLogin().getProfile()));
		for (Article a : u.getArticles()) {
			um.getArticlesModel().add(ArticleMapper.mapToArticleModel(a));
		}
		for (Comment c : u.getComments()) {
			um.getCommentsModel().add(CommentMapper.mapToCommentModel(c));
		}
		System.out.println(Messages.USER_SUCCESS_MESSAGE);
		return um;
	}

	public static User mapToUser(UserModel um) {

		User u = new User();
		u.setUserLogin(new UserLogIn(um.getEmail(), um.getUserName(), um.getPassword(),
				um.getCreationDate(), ProfileMapper.mapToProfile(um.getProfileModel())));
		u.setUserDetail(new UserDetail(um.getLastName(), um.getFirstName(),
				um.getTelephoneNumber(), um.getBirthday(),
				new Adress(um.getHouseNumber(), um.getStreet(), um.getZipcode(),
						um.getCity(), um.getCountry())));
		u.setStatus(StatusMapper.mapToStatus(um.getStatusModel()));
		for (ArticleModel am : um.getArticlesModel()) {
			u.getArticles().add(ArticleMapper.mapToArticle(am));
		}
		for (CommentModel cm : um.getCommentsModel()) {
			u.getComments().add(CommentMapper.mapToComment(cm));
		}
		System.out.println(Messages.USER_SUCCESS_MESSAGE);
		return u;

	}

}
