package com.fitec.formation.wiki.services;

import java.util.List;

public interface ICommentService<Comment> {

    boolean addComment (Comment comment);

    Comment getComment (Long id);

    boolean updateComment (Comment comment);

    boolean deleteComment (Long id);

    List<Comment> getComments ();

    List<Comment> getCommentsByParent (Comment parentComment);

//    List<Comment> getCommentsByUser (String username);

}
