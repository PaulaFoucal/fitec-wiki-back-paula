package com.fitec.formation.wiki.services;

import java.util.List;
import java.util.Objects;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.repositories.IArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitec.formation.wiki.utils.Messages;

import static com.fitec.formation.wiki.utils.Utils.getNullPropertyNames;

@Service
public class ArticleService implements IArticleService<Article> {

	@Autowired
	IArticleRepository articleRepository;

	@Override
	public boolean addArticle(Article article) {
		boolean result = false;
		if (Objects.nonNull(article)) {
            result = Objects.nonNull(articleRepository.save(article));
            System.out.println(Messages.ARTICLE_SUCCESS_ADDED);
        } else {
            System.out.println(Messages.ARTICLE_ERROR_NULL);
        }
		return result;
	}

    @Override
    public Article getArticle(Long id) {
        Article article = articleRepository.getOne(id);
        return article;
    }

	@Override
	public boolean updateArticle(Article sourceArticle) {
		boolean result = false;
		Article targetArticle = articleRepository.getOne(sourceArticle.getIdArticle());
		if (Objects.nonNull(sourceArticle) && articleRepository.existsById(sourceArticle.getIdArticle())) {
            BeanUtils.copyProperties(sourceArticle, targetArticle, getNullPropertyNames(sourceArticle));
		    result = Objects.nonNull(articleRepository.save(targetArticle));
		    System.out.println(Messages.ARTICLE_SUCCESS_UPDATED);
        } else {
            System.out.println(Messages.ARTICLE_ERROR_NULL_DONT_EXIST);
		}
		return result;
	}

	@Override
	public boolean deleteArticle(Long idArticle) {
		boolean result = false;
		if (articleRepository.existsById(idArticle)) {
            articleRepository.delete(getArticle(idArticle));
            result = true;
            System.out.println(Messages.ARTICLE_SUCCESS_DELETED);
        } else {
            System.out.println(Messages.ARTICLE_ERROR_DONT_EXIST);
        }
		return result;
	}

	@Override
	public List<Article> getArticles() {
		List<Article> articles = articleRepository.findAll();
		return articles;
	}

    @Override
    public List<Article> getArticlesByStatus(Status status) {
        List<Article> articles = articleRepository.findByStatus(status);
	    return articles;
    }

    @Override
    public List<Article> getArticlesByUser(String username) {
        List<Article> articles = articleRepository.findByUser_UserLogin_UserName(username);
        return articles;
    }

    @Override
    public List<Article> getArticlesByYear(String year) {
        List<Article> articles = articleRepository.findByCreationDate_Year(year);
	    return articles;
    }

}
