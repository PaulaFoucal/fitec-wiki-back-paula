package com.fitec.formation.wiki;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.services.IArticleService;
import com.fitec.formation.wiki.services.ICommentService;
import com.fitec.formation.wiki.services.IUserService;
import com.fitec.formation.wiki.test.ArticleTest;
import com.fitec.formation.wiki.test.CommentTest;
import com.fitec.formation.wiki.test.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

//FIXME

@SpringBootApplication
public class MainTest implements CommandLineRunner {

    @Autowired
    IUserService userService;
    @Autowired
    IArticleService articleService;
    @Autowired
    ICommentService commentService;

    @Autowired
    UserTest userTest;
    @Autowired
    ArticleTest articleTest;
    @Autowired
    CommentTest commentTest;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainTest.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {

        List<User> users = userTest.initUserSuite();

        userService.addUser(users.get(0));
        userService.addUser(users.get(1));
        userService.addUser(users.get(2));

        List<Article> articles = articleTest.initArticleSuite();

        articleService.addArticle(articles.get(0));
        articleService.addArticle(articles.get(1));
        articleService.addArticle(articles.get(2));

//        List<Comment> comments = commentTest.initCommentSuite();
//
//        commentService.addComment(comments.get(0));
//        commentService.addComment(comments.get(1));
//        commentService.addComment(comments.get(2));
//        commentService.addComment(comments.get(3));
//        commentService.addComment(comments.get(4));
//        commentService.addComment(comments.get(5));
//        commentService.addComment(comments.get(6));
//        commentService.addComment(comments.get(7));
//        commentService.addComment(comments.get(8));

        System.out.printf("MainTest.run");

    }
}
