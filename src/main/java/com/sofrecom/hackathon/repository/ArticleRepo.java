package com.sofrecom.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.model.Category;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

	List<Article> findArticleByTitle(String title);

	List<Article> findByCategory(Category category);
	List<Article> findByType(String type);
}
