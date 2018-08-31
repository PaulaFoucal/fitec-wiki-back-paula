package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Address;
import com.fitec.formation.wiki.entity.UserInfo;
import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.entity.UserLogger;
import com.fitec.formation.wiki.model.ArticleModel;
import com.fitec.formation.wiki.model.CommentModel;
import com.fitec.formation.wiki.model.UserModel;
import com.fitec.formation.wiki.utils.Messages;

/*
 * Map model and entity
 * 
 * User
 * 
 */

public class UserMapper {

	public static UserModel mapToUserModel(User u) {
		UserModel um = new UserModel();
		um.setUserName(u.getUserLogger().getUsername());
		um.setPassword(u.getUserLogger().getPassword());
		um.setCreationDate(u.getUserLogger().getCreationDate());
		um.setLastName(u.getUserInfo().getLastName());
		um.setFirstName(u.getUserInfo().getFirstName());
		um.setEmail(u.getUserLogger().getEmail());
		um.setPhone(u.getUserInfo().getPhone());
		um.setBirthday(u.getUserInfo().getBirthday());
		um.setStreet(u.getUserInfo().getAddress().getStreet());
		um.setZipcode(u.getUserInfo().getAddress().getZipcode());
		um.setCity(u.getUserInfo().getAddress().getCity());
		um.setCountry(u.getUserInfo().getAddress().getCountry());
		um.setStatusModel(StatusMapper.mapToStatusModel(u.getStatus()));
		um.setProfileModel(ProfileMapper.mapToProfileModel(u.getUserLogger().getProfile()));
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
		u.setUserLogger(new UserLogger(um.getEmail(), um.getUserName(), um.getPassword(),
				um.getCreationDate(), ProfileMapper.mapToProfile(um.getProfileModel())));
		u.setUserInfo(new UserInfo(um.getLastName(), um.getFirstName(),
				um.getPhone(), um.getBirthday(),
				new Address(um.getStreet(), um.getZipcode(),
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
