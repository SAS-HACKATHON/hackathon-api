package com.sofrecom.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.model.Commentaire;

public interface CommentaireRepo extends JpaRepository<Commentaire, Integer>  {
	
	List<Commentaire> findByArticle(Article id);

}
