package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.model.CommentModel;
import utils.Messages;

/*
 * Map model and entity
 * 
 * Comment
 * 
 */

public class CommentMapper {

	public static Comment mapToComment(CommentModel cm) {
		Comment c = new Comment();
		c.setContent(cm.getContent());
		c.setCreationDate(cm.getCreationDate());
		c.setStatus(StatusMapper.mapToStatus(cm.getStatusModel()));
		c.setArticle(ArticleMapper.mapToArticle(cm.getArticleModel()));
		c.setUser(UserMapper.mapToUser(cm.getUserModel()));
		c.setParentComment(CommentMapper.mapToComment(cm.getParentCommentModel()));
		for (CommentModel i : cm.getChildCommentsModel()) {
			c.getChildComments().add(CommentMapper.mapToComment(i));
		}
		System.out.println(Messages.COMMENT_SUCCESS_MESSAGE);
		return c;
	}

	public static CommentModel mapToCommentModel(Comment c) {
		CommentModel cm = new CommentModel();
		cm.setContent(c.getContent());
		cm.setCreationDate(c.getCreationDate());
		cm.setStatusModel(StatusMapper.mapToStatusModel(c.getStatus()));
		cm.setArticleModel(ArticleMapper.mapToArticleModel(c.getArticle()));
		cm.setUserModel(UserMapper.mapToUserModel(c.getUser()));
		cm.setParentCommentModel(CommentMapper.mapToCommentModel(c.getParentComment()));
		for (Comment i : c.getChildComments()) {
			cm.getChildCommentsModel().add(CommentMapper.mapToCommentModel(i));
		}
		System.out.println(Messages.COMMENT_SUCCESS_MESSAGE);
		return cm;
	}

}
