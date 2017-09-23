package com.sofrecom.hackathon.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.model.Commentaire;
import com.sofrecom.hackathon.service.CommentaireService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = { "Commentaire" })
public class CommentaireController extends BaseController {
	
	public final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	CommentaireService commentaireService;

	@ApiOperation(value = "get comments by article", notes = "", response = Commentaire.class)
	@RequestMapping(value = "/article/{id}/comments", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Commentaire>> commentsByArticle(
			@ApiParam(value = "article id ", required = true) @PathVariable("id") Integer id) {

		List<Commentaire> commentaires = commentaireService.findByArticle(id);

		if (commentaires != null || !commentaires.isEmpty()) {
			return new ResponseEntity<>(commentaires, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

	}

	@ApiOperation(value = "Add new Commentaire")
	@RequestMapping(value = "/comment/add", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Commentaire> addNewComment(@RequestBody Commentaire commentaire, HttpServletRequest req) {
		boolean commentaireAddSuccess = commentaireService.insertOrSaveCommentaire(commentaire);
		if (commentaireAddSuccess == true) {
			return new ResponseEntity<>(commentaire, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(commentaire, HttpStatus.NOT_FOUND);
		}

	}

	@ApiOperation(value = "update  Commentaire" )
	@RequestMapping(value = "/comments/update", method = RequestMethod.PUT, produces = { "application/json" })
	  public ResponseEntity<Commentaire> updateComment(@RequestBody Commentaire commentaire) {
		
		boolean commentaireAddSuccess = commentaireService.insertOrSaveCommentaire(commentaire);
		
		if (commentaireAddSuccess == true) {
			return new ResponseEntity<>(commentaire, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(commentaire, HttpStatus.NOT_FOUND);
		}
	  }
	
	@ApiOperation(value = "delete  commentaire")
	@RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteArticle(@PathVariable("id") Integer id) {

		Commentaire commentaire = commentaireService.findById(id);
		if (commentaire == null) {
			logger.error("Unable to delete. Article with id {} not found.", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		commentaireService.deleteCommentaire(commentaire);
		return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
	}
}
