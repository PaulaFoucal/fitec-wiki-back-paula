package com.fitec.formation.wiki.services;

import java.util.List;
import java.util.Objects;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.repositories.ICommentRepository;
import com.fitec.formation.wiki.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitec.formation.wiki.utils.Messages;

@Service
public class CommentService implements ICommentService<Comment> {

	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	Utils utils;
	
	@Override
	public boolean addComment(Comment comment) {
		boolean result = false;
		if (Objects.nonNull(comment)) {
            result = Objects.nonNull(commentRepository.save(comment));
            System.out.println(Messages.COMMENT_SUCCESS_ADDED);
        } else {
            System.out.println(Messages.COMMENT_ERROR_NULL);
        }
		return result;
	}

    @Override
    public Comment getComment (Long id) {
	    Comment comment = commentRepository.getOne(id);
        return comment;
    }

	@Override
	public boolean updateComment(Comment sourceComment) {
		boolean result = false;
		Comment targetComment = commentRepository.getOne(sourceComment.getIdComment());
		if (Objects.nonNull(sourceComment) && commentRepository.existsById(sourceComment.getIdComment())) {
            BeanUtils.copyProperties(sourceComment, targetComment, utils.getNullPropertyNames(sourceComment));
            result = Objects.nonNull(commentRepository.save(targetComment));
            System.out.println(Messages.COMMENT_SUCCESS_UPDATED);
        } else {
		    System.out.println(Messages.COMMENT_ERROR_NULL_DONT_EXIST);
        }
		return result;
	}

	@Override
	public boolean deleteComment(Long id) {
        boolean result = false;
        if (commentRepository.existsById(id)) {
            commentRepository.delete(getComment(id));
            result = true;
            System.out.println(Messages.COMMENT_SUCCESS_DELETED);
        } else {
            System.out.println(Messages.COMMENT_ERROR_DONT_EXIST);
        }
        return result;
	}

	@Override
	public List<Comment> getComments() {
        List<Comment> comments = commentRepository.findAll();
		return comments;
	}

	@Override
	public List<Comment> getCommentsByParent(Comment parentComment) {
        List<Comment> comments = commentRepository.findByParentComment(parentComment);
	    return comments;
	}

//	@Override
//	public List<Comment> getCommentsByUser(String username) {
//        List<Comment> comments = commentRepository.findByUser_UserLogin_UserName(username);
//		return comments;
//	}

}
