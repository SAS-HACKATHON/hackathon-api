package com.sofrecom.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.model.Commentaire;
import com.sofrecom.hackathon.repository.ArticleRepo;
import com.sofrecom.hackathon.repository.CommentaireRepo;

@Service
public class CommentaireService {

	@Autowired
	CommentaireRepo commentaireRepo;

	@Autowired
	ArticleRepo articleRepo;

	public List<Commentaire> findAll() {
		return commentaireRepo.findAll();
	}

	public List<Commentaire> findByArticle(Integer id) {
		return commentaireRepo.findByArticle(articleRepo.findOne(id));
	}

	public boolean insertOrSaveCommentaire(Commentaire commentaire) {
		commentaireRepo.save(commentaire);
		return true;
	}

	public void deleteCommentaire(Commentaire commentaire) {
		commentaireRepo.delete(commentaire);
	}

	public Commentaire findById(Integer id) {
		return commentaireRepo.findOne(id);
	}
}
