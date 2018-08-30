package com.fitec.formation.wiki.repositories;

import java.util.List;
import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByUser_UserLogin_UserName (String username);

	List<Article> findByStatus (Status status);

	List<Article> findByCreationDate_Year (String year);

}
