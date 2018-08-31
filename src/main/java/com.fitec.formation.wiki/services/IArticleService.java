package com.fitec.formation.wiki.services;

import com.fitec.formation.wiki.entity.Status;

import java.util.List;

public interface IArticleService<Article> {

    boolean addArticle (Article article);

    Article getArticle (Long id);

    boolean updateArticle (Article article);

    boolean deleteArticle (Long id);

    List<Article> getArticles ();

    List<Article> getArticlesByStatus (Status status);

//    List<Article> getArticlesByUser (String username);

//    List<Article> getArticlesByYear (String year);

}
