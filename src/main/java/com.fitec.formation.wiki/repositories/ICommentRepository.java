package com.fitec.formation.wiki.repositories;

import com.fitec.formation.wiki.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByParentComment (Comment parentComment);

//    List<Comment> findByUser_UserLogin_UserName (String username);

}
