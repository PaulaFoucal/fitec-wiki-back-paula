package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.services.ArticleService;
import com.fitec.formation.wiki.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleTest {

    @Autowired
    Utils utils;

    @Autowired
    StatusTest statusTest;

    @Autowired
    UserTest userTest;

    public List<Article> initArticleSuite() {
        List<Article> articles = new ArrayList<>();

        List<User> users = userTest.initUserSuite();

        final Article a01 = new Article();
        a01.setTitle("title01");
        a01.setContent("content01");
        a01.setCreationDate(utils.createDate("01-01-2011"));
        a01.setStatus(statusTest.initStatusSuite().get(0));
        a01.setUser(users.get(0));
        articles.add(a01);

        final Article a02 = new Article();
        a02.setTitle("title02");
        a02.setContent("content02");
        a02.setCreationDate(utils.createDate("02-02-2012"));
        a02.setStatus(statusTest.initStatusSuite().get(0));
        a02.setUser(users.get(1));
        articles.add(a02);

        final Article a03 = new Article();
        a03.setTitle("title03");
        a03.setContent("content03");
        a03.setCreationDate(utils.createDate("03-03-2013"));
        a03.setStatus(statusTest.initStatusSuite().get(0));
        a03.setUser(users.get(2));
        articles.add(a03);

        System.out.println("Inside ArticleTest");

        return articles;
    }
}