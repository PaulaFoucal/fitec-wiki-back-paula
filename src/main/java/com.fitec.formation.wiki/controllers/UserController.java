package com.fitec.formation.wiki.controllers;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.services.ArticleService;
import com.fitec.formation.wiki.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    Article a = new Article();
    @Autowired
    ArticleService as;


}
