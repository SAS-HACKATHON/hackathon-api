package com.sofrecom.hackathon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.model.Commentaire;
import com.sofrecom.hackathon.service.CommentaireService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = { "Commentaire"})
public class CommentaireController {

	@Autowired
	CommentaireService commentaireService;

	@SuppressWarnings("null")
	@ApiOperation(value = "get comments by article", notes = "", response = Commentaire.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Commentaire.class) })
	@RequestMapping(value = "/article/{id}/comments", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Commentaire>> commentsByArticle(@ApiParam(value = "article id ", required = true) @PathVariable("id") Integer id) {

		List<Commentaire> commentaires = commentaireService.findByArticle(id);
		
		if (commentaires != null || !commentaires.isEmpty()) {
			return new ResponseEntity<>(commentaires, HttpStatus.OK);
		}
		
		else {
			return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}

		

	}
}
