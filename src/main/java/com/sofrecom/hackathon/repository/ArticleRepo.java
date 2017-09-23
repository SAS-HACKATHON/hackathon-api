package com.sofrecom.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.Article;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

}
