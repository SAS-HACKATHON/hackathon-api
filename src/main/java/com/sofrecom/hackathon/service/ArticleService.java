package com.sofrecom.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.repository.ArticleRepo;
import com.sofrecom.hackathon.repository.CategoryRepo;

@Service
public class ArticleService {

	@Autowired
	ArticleRepo articleRepo;

	@Autowired
	CategoryRepo categoryRepo;

	public List<Article> findAll() {
		return articleRepo.findAll();
	}

	public boolean insertOrSaveUser(Article article) {
		this.articleRepo.save(article);
		return true;
	}

	public List<Article> findByCategory(Integer id) {
		return articleRepo.findByCategory(categoryRepo.findOne(id));
	}
	
	public List<Article> findByType(String type) {
		return articleRepo.findByType(type);
	}
}
